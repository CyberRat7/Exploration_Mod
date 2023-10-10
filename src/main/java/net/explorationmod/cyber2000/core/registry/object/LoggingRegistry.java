package net.explorationmod.cyber2000.core.registry.object;

import net.explorationmod.cyber2000.core.log.InfoLoggable;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

public class LoggingRegistry {
    public static void register(DeferredRegister<?> registry, IEventBus eventBus) {
        registry.register(eventBus);
        new InfoLoggable(registry.getRegistryName().getNamespace()).log();
    }
}
