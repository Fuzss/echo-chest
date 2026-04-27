package fuzs.echochest.common.data.client;

import fuzs.echochest.common.client.renderer.blockentity.EchoChestRenderer;
import fuzs.echochest.common.client.renderer.special.UnbakedEchoChestSpecialRenderer;
import fuzs.echochest.common.init.ModRegistry;
import fuzs.puzzleslib.common.api.client.data.v2.AbstractModelProvider;
import fuzs.puzzleslib.common.api.client.data.v2.models.ItemModelGenerationHelper;
import fuzs.puzzleslib.common.api.data.v2.core.DataProviderContext;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.world.level.block.Blocks;

public class ModModelProvider extends AbstractModelProvider {

    public ModModelProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void addBlockModels(BlockModelGenerators blockModelGenerators) {
        ItemModelGenerationHelper.generateChest(ModRegistry.ECHO_CHEST_BLOCK.value(),
                Blocks.SCULK,
                EchoChestRenderer.ECHO_CHEST_TEXTURE,
                true,
                UnbakedEchoChestSpecialRenderer::new,
                blockModelGenerators);
    }
}
