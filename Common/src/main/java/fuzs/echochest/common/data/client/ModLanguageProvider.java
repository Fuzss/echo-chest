package fuzs.echochest.common.data.client;

import fuzs.echochest.common.init.ModRegistry;
import fuzs.echochest.common.world.level.block.EchoChestBlock;
import fuzs.echochest.common.world.level.block.entity.EchoChestBlockEntity;
import fuzs.puzzleslib.common.api.client.data.v3.language.AbstractLanguageProvider;
import fuzs.puzzleslib.common.api.data.v3.core.DataProviderContext;

public class ModLanguageProvider extends AbstractLanguageProvider {

    public ModLanguageProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void addTranslations() {
        this.add(ModRegistry.ECHO_CHEST_BLOCK.value(), "Echo Chest");
        this.add(EchoChestBlockEntity.CONTAINER_ECHO_CHEST, "Echo Chest");
        this.add(((EchoChestBlock) ModRegistry.ECHO_CHEST_BLOCK.value()).getDescriptionComponent(), "Collects items and experience from mobs dropped nearby in a radius of 8 blocks.");
    }
}
