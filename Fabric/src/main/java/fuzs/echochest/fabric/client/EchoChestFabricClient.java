package fuzs.echochest.fabric.client;

import fuzs.echochest.common.EchoChest;
import fuzs.echochest.common.client.EchoChestClient;
import fuzs.puzzleslib.common.api.client.core.v1.ClientModConstructor;
import net.fabricmc.api.ClientModInitializer;

public class EchoChestFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientModConstructor.construct(EchoChest.MOD_ID, EchoChestClient::new);
    }
}
