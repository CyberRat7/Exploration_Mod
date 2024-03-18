package net.temporal.venturer.core.registry.facade;

import com.temporal.api.core.registry.factory.common.BlockFactory;
import com.temporal.api.core.registry.factory.extension.block.*;

public class VenturerBlockFactory extends BlockFactory implements BushExtension, PressurePlateExtension, FenceExtension, FenceGateExtension, StairExtension, SlabExtension, ButtonExtension, TrapDoorExtension,  FlowerExtension, DoorExtension, LeavesExtension, StrippableFlammableRotatedPillarBlockExtension, FlammableRotatedPillarBlockExtension, PottedFlowerExtension {
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
