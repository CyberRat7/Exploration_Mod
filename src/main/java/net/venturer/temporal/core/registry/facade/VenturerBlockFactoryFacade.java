package net.venturer.temporal.core.registry.facade;

import com.temporal.api.core.registry.factory.common.BlockFactory;
import com.temporal.api.core.registry.factory.extension.block.BushExtension;
import com.temporal.api.core.registry.factory.extension.block.FlowerExtension;
import com.temporal.api.core.registry.factory.extension.block.PottedFlowerExtension;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.registries.RegistryObject;
import net.venturer.temporal.core.registry.object.VenturerBlocks;

import java.util.function.Supplier;

public class VenturerBlockFactoryFacade extends BlockFactory implements BushExtension, FlowerExtension, PottedFlowerExtension {
    private static volatile VenturerBlockFactoryFacade instance;
    
    public VenturerBlockFactoryFacade() {
        super(VenturerBlocks.BLOCKS, VenturerItemFactoryFacade.getInstance());
    }
    
    public RegistryObject<BushBlock> createBush(String name, Object... args) {
        return BushExtension.super.createBush(name, this, args);
    }
    
    public RegistryObject<? extends BushBlock> createBush(String name, Supplier<? extends BushBlock> tTypedSupplier) {
        return BushExtension.super.createBush(name, this, tTypedSupplier);
    }
    
    public RegistryObject<FlowerBlock> createFlower(String name, Object... args) {
        return FlowerExtension.super.createFlower(name, this, args);
    }
    
    public RegistryObject<? extends FlowerBlock> createFlower(String name, Supplier<? extends FlowerBlock> tTypedSupplier) {
        return FlowerExtension.super.createFlower(name, this, tTypedSupplier);
    }

    public RegistryObject<FlowerPotBlock> createPot(String name, Object... args) {
        return PottedFlowerExtension.super.createPot(name, this, args);
    }
    
    public RegistryObject<? extends FlowerPotBlock> createPot(String name, Supplier<? extends FlowerPotBlock> tTypedSupplier) {
        return PottedFlowerExtension.super.createPot(name, this, tTypedSupplier);
    }

    public static VenturerBlockFactoryFacade getInstance() {
        if (instance == null) {
            synchronized (VenturerBlockFactoryFacade.class) {
                if (instance == null) {
                    instance = new VenturerBlockFactoryFacade();
                }
            }
        }
        
        return instance;
    }
}
