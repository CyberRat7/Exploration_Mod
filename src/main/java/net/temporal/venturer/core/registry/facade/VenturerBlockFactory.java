package net.temporal.venturer.core.registry.facade;

import com.temporal.api.core.registry.factory.common.BlockFactory;
import com.temporal.api.core.registry.factory.extension.block.BushExtension;
import com.temporal.api.core.registry.factory.extension.block.FlowerExtension;
import com.temporal.api.core.registry.factory.extension.block.PottedFlowerExtension;

public class VenturerBlockFactory extends BlockFactory implements BushExtension, FlowerExtension, PottedFlowerExtension {
    private static volatile VenturerBlockFactory instance;

    public static VenturerBlockFactory getInstance() {
        if (instance == null) {
            synchronized (VenturerBlockFactory.class) {
                if (instance == null) {
                    instance = new VenturerBlockFactory();
                }
            }
        }
        
        return instance;
    }
}
