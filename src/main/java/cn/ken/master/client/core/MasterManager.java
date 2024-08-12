package cn.ken.master.client.core;

import cn.ken.master.client.exception.MasterErrorCode;
import cn.ken.master.client.exception.MasterException;
import cn.ken.master.client.util.MasterUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Master管理类
 * @author Ken-Chy129
 * @date 2024/8/11
 */
public class MasterManager {

    // 服务端主机地址
    private String host;

    // 服务端端口号
    private Integer port;

    // 客户端应用名
    private String appName;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    /**
     * 向服务端注册变量管控类
     * @param clazz 变量管控类
     */
    public void register(Class<?> clazz) {
        // 1.校验clazz
        if (!MasterUtil.isVariableMasterClazzValid(clazz)) {
            throw new MasterException(MasterErrorCode.REGISTERED_CLAZZ_INVALID);
        }
        // 3.保存变量控制类
        MasterContainer.addVariableMaster(clazz);
    }

    public void init() {
        // 1.连接服务端
        try (
                Socket serverSocket = new Socket(host, port);
                PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);
        ) {
            // 2.启动线程监听服务端命令
            new CommandListener(serverSocket).start();
            // 3.启动线程定时发送心跳检测包
            new HeatBeatHandler(serverSocket).start();
            // 4.发送应用名
            out.println(appName);
        } catch (UnknownHostException e) {
            throw new MasterException(MasterErrorCode.SERVER_HOST_INVALID);
        } catch (IllegalArgumentException e) {
            throw new MasterException(MasterErrorCode.SERVER_PORT_INVALID);
        } catch (IOException e) {
            throw new MasterException(MasterErrorCode.SERVER_CONNECT_ERROR);
        }
    }
}
