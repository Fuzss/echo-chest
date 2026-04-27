package fuzs.echochest.client;

import fuzs.echochest.EchoChest;
import fuzs.echochest.client.gui.screens.inventory.EchoChestScreen;
import fuzs.echochest.client.renderer.blockentity.EchoChestRenderer;
import fuzs.echochest.client.renderer.special.UnbakedEchoChestSpecialRenderer;
import fuzs.echochest.init.ModRegistry;
import fuzs.echochest.world.level.block.EchoChestBlock;
import fuzs.puzzleslib.common.api.client.core.v1.ClientModConstructor;
import fuzs.puzzleslib.common.api.client.core.v1.context.*;
import fuzs.puzzleslib.common.api.client.gui.v2.tooltip.ItemTooltipRegistry;

public class EchoChestClient implements ClientModConstructor {

    @Override
    public void onClientSetup() {
        ItemTooltipRegistry.BLOCK.registerItemTooltip(EchoChestBlock.class, EchoChestBlock::getDescriptionComponent);
    }

    @Override
    public void onRegisterBlockEntityRenderers(BlockEntityRenderersContext context) {
        context.registerBlockEntityRenderer(ModRegistry.ECHO_CHEST_BLOCK_ENTITY_TYPE.value(), EchoChestRenderer::new);
    }

    @Override
    public void onRegisterMenuScreens(MenuScreensContext context) {
        context.registerMenuScreen(ModRegistry.ECHO_CHEST_MENU_TYPE.value(), EchoChestScreen::new);
    }

    @Override
    public void onRegisterLayerDefinitions(LayerDefinitionsContext context) {
        context.registerLayerDefinition(EchoChestRenderer.ECHO_CHEST_MODEL_LAYER_LOCATION,
                EchoChestRenderer::createSingleBodyLayer);
    }

    @Override
    public void onRegisterItemModels(ItemModelsContext context) {
        context.registerSpecialModelRenderer(EchoChest.id("echo_chest"), UnbakedEchoChestSpecialRenderer.MAP_CODEC);
    }

    @Override
    public void onRegisterBuiltInBlockModels(BuiltInBlockModelsContext context) {
        context.registerModelFactory(ModRegistry.ECHO_CHEST_BLOCK.value(),
                UnbakedEchoChestSpecialRenderer.createXmasChest(EchoChestRenderer.ECHO_CHEST_TEXTURE));
    }
}
