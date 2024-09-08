package cn.ken.master.client.task;

import cn.ken.master.core.model.CommandRequest;

import java.net.Socket;

/**
 * @author Ken-Chy129
 * @date 2024/8/12
 */
public class CommandTask implements Runnable {

    private final String DEFAULT_CHARSET = "utf-8";

    private Socket socket;

    private CommandRequest commandRequest;

    @Override
    public void run() {
        if (socket == null) {
            return;
        }

    }
}
