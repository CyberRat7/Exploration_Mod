package net.venturer.temporal.core.registry.object;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.venturer.temporal.Venturer;
import net.venturer.temporal.common.object.block.StingingNettleBlock;
import net.venturer.temporal.core.registry.factory.BlockFactory;
import net.venturer.temporal.core.registry.factory.block.PlantableFactory;
import net.venturer.temporal.core.util.log.LoggingRegistry;

public class VenturerBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, Venturer.MOD_ID);

    public static final RegistryObject<FlowerBlock> STINGING_NETTLE = PlantableFactory.createTypedPlantable("stinging_nettle", () ->
            new StingingNettleBlock(BlockBehaviour.Properties.copy(Blocks.DEAD_BUSH)));
//    public static final RegistryObject<FlowerBlock> ORANGE_MARIGOLD = PlantableFactory.createFlower("orange_marigold",
//            BlockBehaviour.Properties.copy(Blocks.ORANGE_TULIP), () -> MobEffects.HARM, 3);
//    public static final RegistryObject<FlowerBlock> YELLOW_MARIGOLD = PlantableFactory.createFlower("yellow_marigold",
//            BlockBehaviour.Properties.copy(Blocks.DANDELION), () -> MobEffects.HARM, 3);
    public static final RegistryObject<FlowerPotBlock> POTTED_STINGING_NETTLE = PlantableFactory.createPottedFlower("potted_stinging_nettle", STINGING_NETTLE,
            BlockBehaviour.Properties.copy(Blocks.POTTED_DEAD_BUSH));
//    public static final RegistryObject<FlowerPotBlock> POTTED_YELLOW_MARIGOLD = PlantableFactory.createPottedFlower("potted_yellow_marigold", YELLOW_MARIGOLD,
//            BlockBehaviour.Properties.copy(Blocks.DANDELION));
//    public static final RegistryObject<FlowerPotBlock> POTTED_ORANGE_MARIGOLD = PlantableFactory.createPottedFlower("potted_orange_marigold", ORANGE_MARIGOLD,
//            BlockBehaviour.Properties.copy(Blocks.ORANGE_TULIP));

    public static final  RegistryObject<Block> BAG_OF_NETTLE_LEAVES = BlockFactory.create("bag_of_nettle_leaves", BlockBehaviour.Properties.copy(Blocks.BLACK_WOOL));

    public static void register(IEventBus eventBus) {
        LoggingRegistry.register(BLOCKS, "blocks", eventBus);
    }
}
