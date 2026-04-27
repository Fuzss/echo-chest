package fuzs.echochest.common.client.renderer.blockentity;

import fuzs.echochest.common.EchoChest;
import fuzs.echochest.common.world.level.block.entity.EchoChestBlockEntity;
import fuzs.puzzleslib.common.api.client.init.v1.ModelLayerFactory;
import fuzs.puzzleslib.common.api.client.renderer.v1.SingleChestRenderer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.object.chest.ChestModel;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.sprite.SpriteId;
import net.minecraft.resources.Identifier;

public class EchoChestRenderer extends SingleChestRenderer<EchoChestBlockEntity, ChestModel, SingleChestRenderer.SingleChestRenderState> {
    static final ModelLayerFactory MODEL_LAYERS = ModelLayerFactory.from(EchoChest.MOD_ID);
    public static final ModelLayerLocation ECHO_CHEST_MODEL_LAYER_LOCATION = MODEL_LAYERS.registerModelLayer(
            "echo_chest");
    public static final Identifier ECHO_CHEST_TEXTURE = EchoChest.id("echo");
    private static final SpriteId ECHO_CHEST_SPRITE = Sheets.CHEST_MAPPER.apply(ECHO_CHEST_TEXTURE);

    public EchoChestRenderer(BlockEntityRendererProvider.Context context) {
        super(context, new ChestModel(context.bakeLayer(ECHO_CHEST_MODEL_LAYER_LOCATION)));
    }

    public static LayerDefinition createSingleBodyLayer() {
        return ChestModel.createSingleBodyLayer().apply(meshDefinition -> {
            meshDefinition.getRoot().clearChild("lock");
            return meshDefinition;
        });
    }

    @Override
    protected SpriteId getChestSprite(EchoChestBlockEntity blockEntity) {
        return ECHO_CHEST_SPRITE;
    }
}
