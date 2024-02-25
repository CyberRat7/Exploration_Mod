package net.temporal.venturer.core.registry.object;

import com.temporal.api.core.registry.factory.common.BlockFactory;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.temporal.venturer.common.object.block.StingingNettleBlock;
import net.temporal.venturer.core.registry.facade.VenturerBlockFactory;

public class VenturerBlocks {
    public static final VenturerBlockFactory BLOCK_FACTORY = VenturerBlockFactory.getInstance();

    public static final RegistryObject<? extends FlowerBlock> STINGING_NETTLE = BLOCK_FACTORY.createFlower("stinging_nettle", () ->
            new StingingNettleBlock(BlockBehaviour.Properties.copy(Blocks.DEAD_BUSH)));
    public static final RegistryObject<FlowerPotBlock> POTTED_STINGING_NETTLE = BLOCK_FACTORY.createPot("potted_stinging_nettle",
            BlockBehaviour.Properties.copy(Blocks.POTTED_DEAD_BUSH), STINGING_NETTLE);

    public static final RegistryObject<Block> BAG_OF_NETTLE_LEAVES = BLOCK_FACTORY.create("bag_of_nettle_leaves", BlockBehaviour.Properties.copy(Blocks.BLACK_WOOL));

    public static void register(IEventBus eventBus) {
        BlockFactory.getInstance().register(eventBus);
    }
}
