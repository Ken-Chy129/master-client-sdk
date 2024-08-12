package cn.ken.master.client.core;

import cn.ken.master.client.common.domain.CommandRequest;
import cn.ken.master.client.handle.RequestHandleStrategy;
import cn.ken.master.client.handle.RequestHandlerFactory;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

/**
 * 命令监听处理
 *
 * @author Ken-Chy129
 * @date 2024/8/11
 */
public class CommandListener extends Thread {

    private final Socket serverSocket;

    // todo:线程池设置,使用虚拟线程？
    private ExecutorService executorService;

    public CommandListener(Socket serverSocket) {
        this.serverSocket = serverSocket;
    }


    @Override
    public void run() {
        while (true) {
            try (
                    BufferedReader br = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()))
                    ) {

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            // socket 监听服务端消息

            // 消息解析
            CommandRequest commandRequest = parseRequest();
            // 线程池异步消息处理
            executorService.submit(() -> {
                RequestHandleStrategy requestHandler = RequestHandlerFactory.getRequestHandler(commandRequest.getRequestType());
                requestHandler.handleRequest(commandRequest);
            });
        }
    }

    private CommandRequest parseRequest() {
        CommandRequest commandRequest = new CommandRequest();

        return commandRequest;
    }
}
