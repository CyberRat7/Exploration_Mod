package net.venture.cyber2000.core.registry.object;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.venture.cyber2000.Venture;
import net.venture.cyber2000.core.util.log.LoggingRegistry;

public class VentureBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, Venture.MOD_ID);



    public static void register(IEventBus eventBus) {
        LoggingRegistry.register(BLOCKS, eventBus);
    }
}
