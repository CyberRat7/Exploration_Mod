package net.venture.cyber2000.core.registry.object;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimPattern;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.venture.cyber2000.Venture;
import net.venture.cyber2000.core.registry.factory.DefaultTrimPatternFactory;
import net.venture.cyber2000.core.util.log.LoggingRegistry;

public class VentureTrimPatterns {
    public static final DeferredRegister<TrimPattern> TRIM_PATTERNS = DeferredRegister.create(Registries.TRIM_PATTERN, Venture.MOD_ID);

    //Use DefaultTrimPatternFactory.create(String name, Holder< Item > holder, String description);
    //For example ...create("my_pattern", VentureItems.MY_TRIM, "Description")

    public static void register(IEventBus eventBus) {
        LoggingRegistry.register(TRIM_PATTERNS, "trim_patterns", eventBus);
    }
}
