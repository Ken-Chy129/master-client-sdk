package cn.ken.master.client.core;

import java.net.Socket;

/**
 * @author Ken-Chy129
 * @date 2024/8/12
 */
public class HeatBeatHandler extends Thread {

    private final Socket serverSocket;

    public HeatBeatHandler(Socket serverSocket) {
        this.serverSocket = serverSocket;
    }


    @Override
    public void run() {

    }
}
