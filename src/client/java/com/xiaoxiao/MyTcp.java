package com.xiaoxiao;

import net.minecraft.client.MinecraftClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public final class MyTcp implements Runnable {
    public static ServerSocket serverSocket;

    public static void register() {
        MinecraftClient client = MinecraftClient.getInstance();
        try {
            serverSocket = new ServerSocket(23454);
        } catch (IOException e) {
            // 关闭游戏
            client.execute(client::close);
        }
    }

    public void run() {
        MinecraftClient client = MinecraftClient.getInstance();
        while (true) {
            try {
                if (serverSocket.isClosed()) {
                    // 关闭游戏
                    client.execute(client::close);
                    break;
                }
                Socket clientSocket = serverSocket.accept(); // 接受客户端连接
                handleClientConnection(clientSocket); // 在同一线程中处理客户端连接
            } catch (IOException e) {
                // 关闭游戏
                client.execute(client::close);
                break;
            }
        }
    }

    private void handleClientConnection(Socket clientSocket) {
        MinecraftClient client = MinecraftClient.getInstance();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            String inputLine;
            String getFromClient = "";
            while ((inputLine = in.readLine()) != null && !clientSocket.isClosed()) {
                getFromClient = inputLine;
            }
            String[] parts = getFromClient.split(";");
            int i = 0;
            MyRender.job = Integer.parseInt(parts[i++]);
            MyRender.attack = Double.parseDouble(parts[i++]);
            MyRender.arrow = Double.parseDouble(parts[i++]);
            MyRender.zhenfa = Double.parseDouble(parts[i++]);
            MyRender.baoji = Double.parseDouble(parts[i++]);
            MyRender.baojixiaoguo = Double.parseDouble(parts[i++]);
            MyRender.cool_reduce = Double.parseDouble(parts[i++]);
            MyRender.hujia = Double.parseDouble(parts[i++]);
            MyRender.pojia = Double.parseDouble(parts[i++]);
            MyRender.fakang = Double.parseDouble(parts[i++]);
            MyRender.pofa = Double.parseDouble(parts[i++]);
            MyRender.gedang = Double.parseDouble(parts[i++]);
            MyRender.shouhu = Double.parseDouble(parts[i++]);
            MyRender.renxing = Double.parseDouble(parts[i++]);
            MyRender.shengji = Double.parseDouble(parts[i++]);
            MyRender.dumian = Double.parseDouble(parts[i++]);
            MyRender.huomian = Double.parseDouble(parts[i++]);
            MyRender.bingmian = Double.parseDouble(parts[i++]);
            MyRender.jianmian = Double.parseDouble(parts[i++]);
            MyRender.shuailuomian = Double.parseDouble(parts[i++]);
            MyRender.sanchajimian = Double.parseDouble(parts[i++]);
            MyRender.hp =Double.parseDouble(parts[i++]);
            MyRender.maxHp = Double.parseDouble(parts[i]);




        } catch (IOException e) {
            client.execute(client::close);
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                client.execute(client::close);
            }
        }
    }


}
