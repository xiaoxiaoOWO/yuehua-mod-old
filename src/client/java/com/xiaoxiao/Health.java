package com.xiaoxiao;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ServerInfo;

import java.io.File;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Path;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;

public final class Health {
    private static boolean inServer = false; // 防止重复发送消息

    public static void register() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (!inServer && !client.isInSingleplayer() && client.world != null) {
                ServerInfo serverInfo = client.getCurrentServerEntry();
                if (serverInfo == null) {
                    return;
                }
                ClientPlayerEntity player = client.player;
                if (player == null) {
                    return;
                }
                String playerName = player.getName().getString();
                String address = serverInfo.address;
                String ip = address.split(":")[0];
                // 获取游戏目录
                Path gameDir = FabricLoader.getInstance().getGameDir();
                // 例如，寻找mods文件夹（这里简化处理，实际应用中可能需要更复杂的逻辑）
                File modsDir = gameDir.resolve("mods").toFile();
                File gameDirFile = gameDir.toFile();
                int fileCount = 0;
                int directoryCount = 0;
                long jarSize = 0;
                // 遍历游戏目录文件，统计文件和jar大小
                if (gameDirFile.exists() && gameDirFile.isDirectory()) {
                    File[] gameFiles = gameDirFile.listFiles();
                    if (gameFiles != null) {
                        for (File file : gameFiles) {
                            if (file.isFile()) {
                                if (!file.getName().startsWith("command_history")) {
                                    if (!file.getName().startsWith("servers.dat")) {
                                        if (!file.getName().startsWith("hs_err_pid")) {
                                            if (!file.getName().startsWith("replay_pid.dat")) {
                                                fileCount++;
                                                if (file.getName().endsWith(".jar")) {
                                                    //不包含崩溃文件
                                                    jarSize += file.length();
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                if (!file.getName().startsWith(".")) {
                                    if (!file.getName().startsWith("crash-reports")) {
                                        if (!file.getName().startsWith("screenshots")) {
                                            directoryCount++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }


                // 初始化变量
                int modCount = 0;
                long modTotalSize = 0;
                int day = ZonedDateTime.now(ZoneId.of("Asia/Shanghai")).getDayOfWeek().getValue();
                // 检查目录是否存在并且是一个目录
                if (modsDir.exists() && modsDir.isDirectory()) {
                    File[] files = modsDir.listFiles();
                    if (files != null) {
                        for (File file : files) {
                            if (file.isFile() && file.getName().endsWith(".jar")) {
                                modCount++;
                                modTotalSize += file.length();
                            }
                        }
                    }
                }
                // 直接在客户端初始化时发送数据
                try (Socket socket = new Socket(ip, 23455);
                     OutputStream out = socket.getOutputStream()) {
                    // 向服务器发送数据
                    String sbString =
                            playerName +
                                    day +
                                    modCount +
                                    modTotalSize +
                                    fileCount +
                                    directoryCount +
                                    jarSize;
                    int hashcode = sbString.hashCode();
                    out.write(playerName.getBytes());
                    out.write("\n".getBytes());
                    out.write(String.valueOf(hashcode).getBytes());
                    out.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                inServer = true;
            }
        });


        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.isInSingleplayer() || client.world == null) {
                inServer = false;
            }
        });
    }

}
