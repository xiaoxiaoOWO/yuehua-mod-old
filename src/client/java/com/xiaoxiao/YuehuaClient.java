package com.xiaoxiao;

import net.fabricmc.api.ClientModInitializer;

public final class YuehuaClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		Health.register();
		MyClient.register();
		MyTcp.register();
		MyRender.register();
		new Thread(new MyTcp()).start();
	}
}