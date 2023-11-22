package net.venturer.cyber2000.core.util.log;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

public class LoggingRegistry {
    public static <T> void register(DeferredRegister<T> registry, String info, IEventBus eventBus) {
        registry.register(eventBus);
        new InfoLoggable(info).log();
    }
}
