package com.xiaoxiao;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ServerInfo;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

import java.io.OutputStream;
import java.net.Socket;

public final class MyClient {
    public static KeyBinding key1;
    public static KeyBinding key2;
    public static KeyBinding key3;
    public static KeyBinding key4;
    public static KeyBinding key5;
    public static KeyBinding key6;


    public static void register() {
        key1 = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "打开菜单", // 键绑定的翻译键
                InputUtil.Type.KEYSYM, // 输入类型
                GLFW.GLFW_KEY_B, // 默认键(这里是M键)
                "月华" // 键绑定类别的翻译键
        ));

        key2 = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "释放主动技能1", // 键绑定的翻译键
                InputUtil.Type.KEYSYM, // 输入类型
                GLFW.GLFW_KEY_1, // 默认键(这里是M键)
                "月华" // 键绑定类别的翻译键
        ));

        key3 = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "释放主动技能2", // 键绑定的翻译键
                InputUtil.Type.KEYSYM, // 输入类型
                GLFW.GLFW_KEY_2, // 默认键(这里是M键)
                "月华" // 键绑定类别的翻译键
        ));

        key4 = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "释放主动技能3", // 键绑定的翻译键
                InputUtil.Type.KEYSYM, // 输入类型
                GLFW.GLFW_KEY_3, // 默认键(这里是M键)
                "月华" // 键绑定类别的翻译键
        ));

        key5 = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "释放主动技能4", // 键绑定的翻译键
                InputUtil.Type.KEYSYM, // 输入类型
                GLFW.GLFW_KEY_4, // 默认键(这里是M键)
                "月华" // 键绑定类别的翻译键
        ));

        key6 = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "释放主动技能5", // 键绑定的翻译键
                InputUtil.Type.KEYSYM, // 输入类型
                GLFW.GLFW_KEY_5, // 默认键(这里是M键)
                "月华" // 键绑定类别的翻译键
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            ClientPlayerEntity player = client.player;
            if (player == null) {
                return;
            }
            ServerInfo serverInfo = client.getCurrentServerEntry();
            if (serverInfo == null) {
                return;
            }
            String address = serverInfo.address;
            String ip = address.split(":")[0];
            while (key1.wasPressed()) {
                try (Socket socket = new Socket(ip, 23456);
                     OutputStream out = socket.getOutputStream()) {
                    String data = "menu->" + player.getName().getString();
                    out.write(data.getBytes());
                    out.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            while (key2.wasPressed()) {
                try (Socket socket = new Socket(ip, 23456);
                     OutputStream out = socket.getOutputStream()) {
                    String data = "skill1->" + player.getName().getString();
                    out.write(data.getBytes());
                    out.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            while (key3.wasPressed()) {
                try (Socket socket = new Socket(ip, 23456);
                     OutputStream out = socket.getOutputStream()) {
                    String data = "skill2->" + player.getName().getString();
                    out.write(data.getBytes());
                    out.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            while (key4.wasPressed()) {
                try (Socket socket = new Socket(ip, 23456);
                     OutputStream out = socket.getOutputStream()) {
                    String data = "skill3->" + player.getName().getString();
                    out.write(data.getBytes());
                    out.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            while (key5.wasPressed()) {
                try (Socket socket = new Socket(ip, 23456);
                     OutputStream out = socket.getOutputStream()) {
                    String data = "skill4->" + player.getName().getString();
                    out.write(data.getBytes());
                    out.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            while (key6.wasPressed()) {
                try (Socket socket = new Socket(ip, 23456);
                     OutputStream out = socket.getOutputStream()) {
                    String data = "skill5->" + player.getName().getString();
                    out.write(data.getBytes());
                    out.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });


    }
}
