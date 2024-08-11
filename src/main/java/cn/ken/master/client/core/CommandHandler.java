package cn.ken.master.client.core;

import cn.ken.master.client.common.domain.CommandRequest;
import cn.ken.master.client.handle.RequestHandleStrategy;
import cn.ken.master.client.handle.RequestHandlerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 命令处理器
 *
 * @author Ken-Chy129
 * @date 2024/8/11
 */
public class CommandHandler implements Runnable {

    // todo:线程池设置,使用虚拟线程？
    private ExecutorService executorService;


    @Override
    public void run() {
        while (true) {
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
