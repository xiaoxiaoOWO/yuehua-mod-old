package com.xiaoxiao;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

public final class MyRender {
    public static int job = 1;
    public static double attack;
    public static double arrow;
    public static double zhenfa;
    public static double baoji;
    public static double baojixiaoguo;
    public static double cool_reduce;


    public static double hujia;
    public static double pojia;
    public static double fakang;
    public static double pofa;

    public static double gedang;
    public static double shouhu;
    public static double renxing;
    public static double shengji;


    //特殊免伤系列
    public static double dumian;
    public static double huomian;
    public static double bingmian;
    public static double jianmian;
    public static double shuailuomian;
    public static double sanchajimian;

    public static double hp;
    public static double maxHp;



    public static final Identifier attackId = Identifier.of("yuehua", "textures/gui/attack.png");
    public static final Identifier arrowId = Identifier.of("yuehua", "textures/gui/arrow.png");
    public static final Identifier zhenfaId = Identifier.of("yuehua", "textures/gui/zhenfa.png");
    public static final Identifier baojiId = Identifier.of("yuehua", "textures/gui/baoji.png");
    public static final Identifier baojixiaoguoId = Identifier.of("yuehua", "textures/gui/baojixiaoguo.png");

    public static final Identifier cool_reduceId = Identifier.of("yuehua", "textures/gui/coolreduce.png");
    public static final Identifier hujiaId = Identifier.of("yuehua", "textures/gui/hujia.png");
    public static final Identifier pojiaId = Identifier.of("yuehua", "textures/gui/pojia.png");
    public static final Identifier fakangId = Identifier.of("yuehua", "textures/gui/fakang.png");
    public static final Identifier pofaId = Identifier.of("yuehua", "textures/gui/pofa.png");

    public static final Identifier shouhuId = Identifier.of("yuehua", "textures/gui/shouhu.png");
    public static final Identifier gedangId = Identifier.of("yuehua", "textures/gui/gedang.png");
    public static final Identifier renxingId = Identifier.of("yuehua", "textures/gui/renxing.png");
    public static final Identifier shengjiId = Identifier.of("yuehua", "textures/gui/shengji.png");

    public static final Identifier hpId = Identifier.of("yuehua", "textures/gui/hp.png");
    public static final Identifier hungerId = Identifier.of("yuehua", "textures/gui/hunger.png");
    public static final Identifier dumianId = Identifier.of("yuehua", "textures/gui/dumian.png");
    public static final Identifier huomianId = Identifier.of("yuehua", "textures/gui/huomian.png");

    public static final Identifier bingmianId = Identifier.of("yuehua", "textures/gui/bingmian.png");
    public static final Identifier jianmianId = Identifier.of("yuehua", "textures/gui/jianmian.png");
    public static final Identifier shuailuomianId = Identifier.of("yuehua", "textures/gui/shuailuomian.png");
    public static final Identifier sanchajimianId = Identifier.of("yuehua", "textures/gui/sanchajimian.png");

    public static final Identifier blindId = Identifier.of("yuehua","gui/blind.png");


    public static void register() {


        HudRenderCallback.EVENT.register((DrawContext drawContext, RenderTickCounter renderTickCounter) -> {
                    MinecraftClient client = MinecraftClient.getInstance();
                    if (client.player == null) return;
                    int x1 = client.getWindow().getScaledWidth() / 2 + 95;
                    int x2 = x1 + 60;
                    int x3 = x2 + 60;
                    int x4 = x3 + 60;
                    int y5 = client.getWindow().getScaledHeight() - 10;
                    int y4 = y5 - 10;
                    int y3 = y4 - 10;
                    int y2 = y3 - 10;
                    int y1 = y2 - 10;

                    double absorption = client.player.getAbsorptionAmount();
                    double hunger = client.player.getHungerManager().getFoodLevel();

                    TextRenderer textRenderer = client.textRenderer;
                    RenderSystem.enableBlend();

                    switch (job) {
                        case 0, 1 -> {
                            drawContext.drawTexture(attackId, x1, y1, 0, 0, 9, 9, 9, 9);
                            drawContext.drawText(textRenderer, String.format("%.1f", attack), x1 + 10, y1, Formatting.AQUA.getColorValue(), true);
                        }

                        case 2 -> {
                            drawContext.drawTexture(arrowId, x1, y1, 0, 0, 9, 9, 9, 9);
                            drawContext.drawText(textRenderer, String.format("%.1f", arrow), x1 + 10, y1, Formatting.AQUA.getColorValue(), true);
                        }

                        case 3 -> {
                            drawContext.drawTexture(zhenfaId, x1, y1, 0, 0, 9, 9, 9, 9);
                            drawContext.drawText(textRenderer, String.format("%.1f", zhenfa), x1 + 10, y1, Formatting.AQUA.getColorValue(), true);
                        }
                    }

                    drawContext.drawTexture(baojiId, x2, y1, 0, 0, 9, 9, 9, 9, 9);
                    drawContext.drawText(textRenderer, String.format("%.1f", baoji), x2 + 10, y1, Formatting.AQUA.getColorValue(), true);
                    drawContext.drawText(textRenderer, "%", x2 + 10 + textRenderer.getWidth(String.format("%.1f", baoji)), y1, Formatting.WHITE.getColorValue(), true);

                    drawContext.drawTexture(baojixiaoguoId, x3, y1, 0, 0, 9, 9, 9, 9);
                    drawContext.drawText(textRenderer, String.format("%.1f", baojixiaoguo), x3 + 10, y1, Formatting.AQUA.getColorValue(), true);
                    drawContext.drawText(textRenderer, "%", x3 + 10 + textRenderer.getWidth(String.format("%.1f", baojixiaoguo)), y1, Formatting.WHITE.getColorValue(), true);

                    drawContext.drawTexture(cool_reduceId, x4, y1, 0, 0, 9, 9, 9, 9);
                    drawContext.drawText(textRenderer, String.format("%.1f", cool_reduce), x4 + 10, y1, Formatting.AQUA.getColorValue(), true);
                    drawContext.drawText(textRenderer, "%", x4 + 10 + textRenderer.getWidth(String.format("%.1f", cool_reduce)), y1, Formatting.WHITE.getColorValue(), true);

                    drawContext.drawTexture(hujiaId, x1, y2, 0, 0, 9, 9, 9, 9);
                    drawContext.drawText(textRenderer, String.format("%.1f", hujia), x1 + 10, y2, Formatting.AQUA.getColorValue(), true);

                    drawContext.drawTexture(pojiaId, x2, y2, 0, 0, 9, 9, 9, 9);
                    drawContext.drawText(textRenderer, String.format("%.1f", pojia), x2 + 10, y2, Formatting.AQUA.getColorValue(), true);
                    drawContext.drawTexture(fakangId, x3, y2, 0, 0, 9, 9, 9, 9);
                    drawContext.drawText(textRenderer, String.format("%.1f", fakang), x3 + 10, y2, Formatting.AQUA.getColorValue(), true);
                    drawContext.drawTexture(pofaId, x4, y2, 0, 0, 9, 9, 9, 9);
                    drawContext.drawText(textRenderer, String.format("%.1f", pofa), x4 + 10, y2, Formatting.AQUA.getColorValue(), true);

                    drawContext.drawTexture(shouhuId, x1, y3, 0, 0, 9, 9, 9, 9);
                    drawContext.drawText(textRenderer, String.format("%.1f", absorption), x1 + 10, y3, Formatting.AQUA.getColorValue(), true);
                    drawContext.drawText(textRenderer, "/", x1 + 10 + textRenderer.getWidth(String.format("%.1f", absorption)), y3, Formatting.WHITE.getColorValue(), true);
                    drawContext.drawText(textRenderer, String.format("%.1f", shouhu), x1 + 10 + textRenderer.getWidth(String.format("%.1f", absorption)) + textRenderer.getWidth("/"), y3, Formatting.GREEN.getColorValue(), true);
                    drawContext.drawTexture(gedangId, x2, y3, 0, 0, 9, 9, 9, 9);
                    drawContext.drawText(textRenderer, String.format("%.1f", gedang), x2 + 10, y3, Formatting.AQUA.getColorValue(), true);
                    drawContext.drawTexture(renxingId, x3, y3, 0, 0, 9, 9, 9, 9);
                    drawContext.drawText(textRenderer, String.format("%.1f", renxing), x3 + 10, y3, Formatting.AQUA.getColorValue(), true);
                    drawContext.drawTexture(shengjiId, x4, y3, 0, 0, 9, 9, 9, 9);
                    drawContext.drawText(textRenderer, String.format("%.1f", shengji), x4 + 10, y3, Formatting.AQUA.getColorValue(), true);


                    drawContext.drawTexture(hpId, x1, y4, 0, 0, 9, 9, 9, 9);
                    drawContext.drawText(textRenderer, String.format("%.1f", hp), x1 + 10, y4, Formatting.AQUA.getColorValue(), true);
                    drawContext.drawText(textRenderer, "/", x1 + 10 + textRenderer.getWidth(String.format("%.1f", hp)), y4, Formatting.WHITE.getColorValue(), true);
                    drawContext.drawText(textRenderer, String.format("%.1f", maxHp), x1 + 10 + textRenderer.getWidth(String.format("%.1f", hp)) + textRenderer.getWidth("/"), y4, Formatting.GREEN.getColorValue(), true);
                    drawContext.drawTexture(hungerId, x2, y4, 0, 0, 9, 9, 9, 9);
                    drawContext.drawText(textRenderer, String.format("%.1f", hunger), x2 + 10, y4, Formatting.AQUA.getColorValue(), true);
                    drawContext.drawText(textRenderer, "/", x2 + 10 + textRenderer.getWidth(String.format("%.1f", hunger)), y4, Formatting.WHITE.getColorValue(), true);
                    drawContext.drawText(textRenderer, "20", x2 + 10 + textRenderer.getWidth(String.format("%.1f", hunger)) + textRenderer.getWidth("/"), y4, Formatting.GREEN.getColorValue(), true);
                    drawContext.drawTexture(dumianId, x3, y4, 0, 0, 9, 9, 9, 9);
                    drawContext.drawText(textRenderer, String.format("%.1f", dumian), x3 + 10, y4, Formatting.AQUA.getColorValue(), true);
                    drawContext.drawText(textRenderer, "%", x3 + 10 + textRenderer.getWidth(String.format("%.1f", dumian)), y4, Formatting.WHITE.getColorValue(), true);
                    drawContext.drawTexture(huomianId, x4, y4, 0, 0, 9, 9, 9, 9);
                    drawContext.drawText(textRenderer, String.format("%.1f", huomian), x4 + 10, y4, Formatting.AQUA.getColorValue(), true);
                    drawContext.drawText(textRenderer, "%", x4 + 10 + textRenderer.getWidth(String.format("%.1f", huomian)), y4, Formatting.WHITE.getColorValue(), true);

                    drawContext.drawTexture(bingmianId, x1, y5, 0, 0, 9, 9, 9, 9);
                    drawContext.drawText(textRenderer, String.format("%.1f", bingmian), x1 + 10, y5, Formatting.AQUA.getColorValue(), true);
                    drawContext.drawText(textRenderer, "%", x1 + 10 + textRenderer.getWidth(String.format("%.1f", bingmian)), y5, Formatting.WHITE.getColorValue(), true);
                    drawContext.drawTexture(jianmianId, x2, y5, 0, 0, 9, 9, 9, 9);
                    drawContext.drawText(textRenderer, String.format("%.1f", jianmian), x2 + 10, y5, Formatting.AQUA.getColorValue(), true);
                    drawContext.drawText(textRenderer, "%", x2 + 10 + textRenderer.getWidth(String.format("%.1f", jianmian)), y5, Formatting.WHITE.getColorValue(), true);
                    drawContext.drawTexture(shuailuomianId, x3, y5, 0, 0, 9, 9, 9, 9);
                    drawContext.drawText(textRenderer, String.format("%.1f", shuailuomian), x3 + 10, y5, Formatting.AQUA.getColorValue(), true);
                    drawContext.drawText(textRenderer, "%", x3 + 10 + textRenderer.getWidth(String.format("%.1f", shuailuomian)), y5, Formatting.WHITE.getColorValue(), true);
                    drawContext.drawTexture(sanchajimianId, x4, y5, 0, 0, 9, 9, 9, 9);
                    drawContext.drawText(textRenderer, String.format("%.1f", sanchajimian), x4 + 10, y5, Formatting.AQUA.getColorValue(), true);
                    drawContext.drawText(textRenderer, "%", x4 + 10 + textRenderer.getWidth(String.format("%.1f", sanchajimian)), y5, Formatting.WHITE.getColorValue(), true);



                    RenderSystem.disableBlend();


                }
        );
    }


}
