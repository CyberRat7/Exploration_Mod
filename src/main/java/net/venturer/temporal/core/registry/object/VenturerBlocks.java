package net.venturer.temporal.core.registry.object;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.venturer.temporal.Venturer;
import net.venturer.temporal.common.object.block.StingingNettleBlock;
import net.venturer.temporal.core.registry.facade.VenturerBlockFactoryFacade;

public class VenturerBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, Venturer.MOD_ID);
    public static final VenturerBlockFactoryFacade BLOCK_FACTORY = VenturerBlockFactoryFacade.getInstance();

    public static final RegistryObject<? extends FlowerBlock> STINGING_NETTLE = BLOCK_FACTORY.createFlower("stinging_nettle", () ->
            new StingingNettleBlock(BlockBehaviour.Properties.copy(Blocks.DEAD_BUSH)));
    public static final RegistryObject<FlowerPotBlock> POTTED_STINGING_NETTLE = BLOCK_FACTORY.createPot("potted_stinging_nettle", STINGING_NETTLE,
            BlockBehaviour.Properties.copy(Blocks.POTTED_DEAD_BUSH));

    public static final  RegistryObject<Block> BAG_OF_NETTLE_LEAVES = BLOCK_FACTORY.create("bag_of_nettle_leaves", BlockBehaviour.Properties.copy(Blocks.BLACK_WOOL));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
