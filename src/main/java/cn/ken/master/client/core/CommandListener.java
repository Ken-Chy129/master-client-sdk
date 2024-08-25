package cn.ken.master.client.core;

import cn.ken.master.client.common.domain.CommandRequest;
import cn.ken.master.client.common.domain.Result;
import cn.ken.master.client.handle.RequestHandleStrategy;
import cn.ken.master.client.handle.RequestHandlerFactory;
import cn.ken.master.client.util.StringUtil;

import java.io.*;
import java.net.Socket;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.ExecutorService;

/**
 * 命令监听处理
 *
 * @author Ken-Chy129
 * @date 2024/8/11
 */
public class CommandListener extends Thread {

    private final Socket serverSocket;

    private ExecutorService executorService;

    public CommandListener(Socket serverSocket) {
        this.serverSocket = serverSocket;
    }


    @Override
    public void run() {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
                ObjectOutputStream out = new ObjectOutputStream(serverSocket.getOutputStream());
        ) {
            while (true) {
                String rawRequest = in.readLine();
                // 消息解析
                CommandRequest commandRequest = parseRequest(rawRequest);
                RequestHandleStrategy requestHandler = RequestHandlerFactory.getRequestHandler(commandRequest.getRequestName());
                if (Objects.isNull(requestHandler)) {
                    out.writeObject(Result.error("请输入正确的方法名"));
                    continue;
                }
                out.writeObject(requestHandler.handleRequest(commandRequest));
            }
        } catch (IOException e) {

        }
    }

    /**
     * 将服务端发送的请求进行解析
     * @param rawRequest 格式为：/请求方法名?参数名=值&参数名=值
     * @return 解析后的请求对象
     */
    private CommandRequest parseRequest(String rawRequest) {
        CommandRequest commandRequest = new CommandRequest();
        if (StringUtil.isBlank(rawRequest)) {
            return commandRequest;
        }
        String[] split = rawRequest.split("\\?");
        if (split.length != 2) {
            return commandRequest;
        }
        String[] requestNameSplit = split[0].split("/");
        String requestName = requestNameSplit.length == 2 ? requestNameSplit[1] : requestNameSplit[0];
        commandRequest.setRequestName(requestName.strip());
        String parameters = split[1];
        for (String parameter : parameters.split("&")) {
            if (StringUtil.isBlank(parameter)) {
                continue;
            }
            String[] pair = parameter.split("=");
            if (pair.length != 2) {
                continue;
            }
            String key = pair[0].strip();
            String value = URLDecoder.decode(pair[1].strip(), StandardCharsets.UTF_8);
            commandRequest.addParameter(key, value);
        }
        return commandRequest;
    }
}
