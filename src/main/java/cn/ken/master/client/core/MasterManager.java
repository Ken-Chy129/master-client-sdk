package cn.ken.master.client.core;

import cn.ken.master.client.exception.MasterErrorCode;
import cn.ken.master.client.exception.MasterException;
import cn.ken.master.client.util.AnnotationUtil;

/**
 * Master管理类
 * @author Ken-Chy129
 * @date 2024/8/11
 */
public class MasterManager {

    // 服务端ip地址
    private String ip;

    // 服务端端口号
    private Integer port;

    private Boolean isConnected;

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * 向服务端注册变量管控类
     * @param appName 应用名称
     * @param clazz 变量管控类
     */
    public void register(String appName, Class<?> clazz) {
        // 2.校验appName和clazz
        if (appName == null || !AnnotationUtil.isVariableMasterClazzValid(clazz)) {
            throw new MasterException(MasterErrorCode.PARAM_INVALID);
        }
        // 3.保存变量控制类
        MasterConfigContext.addVariableMaster(clazz);
    }

    public void init() {
        // 1.连接上服务端

        // 2.向服务端发送变量管控类

        // 3.启动线程监听服务端命令

    }
}
