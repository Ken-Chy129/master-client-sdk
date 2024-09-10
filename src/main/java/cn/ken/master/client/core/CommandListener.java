package cn.ken.master.client.core;

import cn.ken.master.client.handle.RequestHandleStrategy;
import cn.ken.master.client.handle.RequestHandlerFactory;
import cn.ken.master.core.model.Request;
import cn.ken.master.core.model.Result;

import java.io.*;
import java.net.Socket;
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
                ObjectInputStream in = new ObjectInputStream(serverSocket.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(serverSocket.getOutputStream());
        ) {
            while (true) {
                Request commandRequest = (Request) in.readObject();
                if (Objects.isNull(commandRequest)) {
                    continue;
                }
                RequestHandleStrategy requestHandler = RequestHandlerFactory.getRequestHandler(commandRequest.getRequestCode());
                if (Objects.isNull(requestHandler)) {
                    out.writeObject(Result.error("请求的方法不存在"));
                    continue;
                }
                out.writeObject(requestHandler.handleRequest(commandRequest));
            }
        } catch (IOException e) {

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

//    /**
//     * 将服务端发送的请求进行解析
//     * @param rawRequest 格式为：/请求方法名?参数名=值&参数名=值
//     * @return 解析后的请求对象
//     */
//    private CommandRequest parseRequest(String rawRequest) {
//        CommandRequest commandRequest = new CommandRequest();
//        if (StringUtil.isBlank(rawRequest)) {
//            return commandRequest;
//        }
//        String[] split = rawRequest.split("\\?");
//        if (split.length != 2) {
//            return commandRequest;
//        }
//        String[] requestNameSplit = split[0].split("/");
//        String requestName = requestNameSplit.length == 2 ? requestNameSplit[1] : requestNameSplit[0];
//        commandRequest.setRequestName(requestName.strip());
//        String parameters = split[1];
//        for (String parameter : parameters.split("&")) {
//            if (StringUtil.isBlank(parameter)) {
//                continue;
//            }
//            String[] pair = parameter.split("=");
//            if (pair.length != 2) {
//                continue;
//            }
//            String key = pair[0].strip();
//            String value = URLDecoder.decode(pair[1].strip(), StandardCharsets.UTF_8);
//            commandRequest.addParameter(key, value);
//        }
//        return commandRequest;
//    }
}
