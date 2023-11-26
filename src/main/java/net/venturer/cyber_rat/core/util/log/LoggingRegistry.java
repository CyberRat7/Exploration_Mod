package net.venturer.cyber_rat.core.util.log;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

public class LoggingRegistry {
    public static <T> void register(DeferredRegister<T> registry, String info, IEventBus eventBus) {
        registry.register(eventBus);
        new InfoLoggable(info).log();
    }
}
