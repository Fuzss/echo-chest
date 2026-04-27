package fuzs.echochest.fabric;

import fuzs.echochest.common.EchoChest;
import fuzs.puzzleslib.common.api.core.v1.ModConstructor;
import net.fabricmc.api.ModInitializer;

public class EchoChestFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        ModConstructor.construct(EchoChest.MOD_ID, EchoChest::new);
    }
}
