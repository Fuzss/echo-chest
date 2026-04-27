package fuzs.echochest.common.client.renderer.special;

import com.mojang.serialization.MapCodec;
import fuzs.echochest.common.client.renderer.blockentity.EchoChestRenderer;
import net.minecraft.client.model.object.chest.ChestModel;
import net.minecraft.client.renderer.MultiblockChestResources;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.block.BuiltInBlockModels;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.renderer.block.model.ConditionalBlockModel;
import net.minecraft.client.renderer.block.model.properties.conditional.IsXmas;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.client.renderer.special.ChestSpecialRenderer;
import net.minecraft.client.renderer.special.NoDataSpecialModelRenderer;
import net.minecraft.client.renderer.special.SpecialModelRenderer;
import net.minecraft.client.resources.model.sprite.SpriteId;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.state.properties.ChestType;

import java.util.Optional;

public record UnbakedEchoChestSpecialRenderer(Identifier texture,
                                              float openness) implements NoDataSpecialModelRenderer.Unbaked {
    public static final MapCodec<UnbakedEchoChestSpecialRenderer> MAP_CODEC = ChestSpecialRenderer.Unbaked.MAP_CODEC.xmap(
            (ChestSpecialRenderer.Unbaked unbaked) -> new UnbakedEchoChestSpecialRenderer(unbaked.texture(),
                    unbaked.openness()),
            (UnbakedEchoChestSpecialRenderer unbaked) -> new ChestSpecialRenderer.Unbaked(unbaked.texture(),
                    unbaked.openness(),
                    ChestType.SINGLE));

    public UnbakedEchoChestSpecialRenderer(Identifier texture) {
        this(texture, 0.0F);
    }

    @Override
    public MapCodec<UnbakedEchoChestSpecialRenderer> type() {
        return MAP_CODEC;
    }

    @Override
    public ChestSpecialRenderer bake(SpecialModelRenderer.BakingContext context) {
        // We have to use this the bake our own model layer, as the echo chest does not have a lock model part like other chests.
        // Using the vanilla model will render the lock black, since a solid render type is used, not cutout.
        ChestModel chestModel = new ChestModel(context.entityModelSet()
                .bakeLayer(EchoChestRenderer.ECHO_CHEST_MODEL_LAYER_LOCATION));
        SpriteId sprite = Sheets.CHEST_MAPPER.apply(this.texture);
        return new ChestSpecialRenderer(context.sprites(), chestModel, sprite, this.openness);
    }

    /**
     * @see BuiltInBlockModels#createXmasChest(MultiblockChestResources)
     */
    public static BuiltInBlockModels.SpecialModelFactory createXmasChest(Identifier texture) {
        return BuiltInBlockModels.specialModelWithPropertyDispatch(ChestBlock.FACING,
                (Direction facing) -> new ConditionalBlockModel.Unbaked(Optional.empty(),
                        new IsXmas(),
                        BuiltInBlockModels.createChest(ChestSpecialRenderer.CHRISTMAS.single(),
                                ChestType.SINGLE,
                                facing),
                        createChest(texture, facing)));
    }

    /**
     * @see BuiltInBlockModels#createChest(Identifier, ChestType, Direction)
     */
    public static BlockModel.Unbaked createChest(Identifier texture, Direction facing) {
        return BuiltInBlockModels.special(new UnbakedEchoChestSpecialRenderer(texture),
                ChestRenderer.modelTransformation(facing));
    }
}
