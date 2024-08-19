package cn.ken.master.client.core;

import cn.ken.master.client.common.domain.CommandRequest;
import cn.ken.master.client.handle.RequestHandleStrategy;
import cn.ken.master.client.handle.RequestHandlerFactory;
import cn.ken.master.client.task.CommandTask;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
                BufferedReader br = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
                PrintWriter pw = new PrintWriter(serverSocket.getOutputStream(), true);
        ) {
            while (true) {
                String rawRequest = br.readLine();
                // 消息解析
                CommandRequest commandRequest = parseRequest(rawRequest);
                RequestHandleStrategy requestHandler = RequestHandlerFactory.getRequestHandler(commandRequest.getRequestType());
                requestHandler.handleRequest(commandRequest);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private CommandRequest parseRequest(String rawRequest) {
        CommandRequest commandRequest = new CommandRequest();

        return commandRequest;
    }
}
