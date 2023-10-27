package net.venture.cyber2000.core.registry.object;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.venture.cyber2000.Venture;
import net.venture.cyber2000.core.registry.factory.DefaultBlockFactory;
import net.venture.cyber2000.core.registry.factory.block.PlantableFactory;
import net.venture.cyber2000.core.util.log.LoggingRegistry;

public class VentureBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, Venture.MOD_ID);

    public static final RegistryObject<FlowerBlock> STINGING_NETTLE = PlantableFactory.createFlower("stinging_nettle",
            BlockBehaviour.Properties.copy(Blocks.DEAD_BUSH), () -> MobEffects.CONFUSION, 6);
    public static final RegistryObject<FlowerPotBlock> POTTED_STINGING_NETTLE = PlantableFactory.createPottedFlower("potted_stinging_nettle", STINGING_NETTLE,
            BlockBehaviour.Properties.copy(Blocks.POTTED_DEAD_BUSH));

    public static final  RegistryObject<Block> BAG_OF_NETTLE_LEAVES = DefaultBlockFactory.create("bag_of_nettle_leaves", BlockBehaviour.Properties.copy(Blocks.BLACK_WOOL));

    public static void register(IEventBus eventBus) {
        LoggingRegistry.register(BLOCKS, "blocks", eventBus);
    }
}
