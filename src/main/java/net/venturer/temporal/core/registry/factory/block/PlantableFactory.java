package net.venturer.temporal.core.registry.factory.block;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;
import net.venturer.temporal.core.registry.factory.BlockFactory;

import java.util.function.Supplier;

public interface PlantableFactory extends BlockFactory {
    static <T extends BushBlock> RegistryObject<T> createTypedPlantable(String name, Supplier<T> bushSupplier) {
        return BlockFactory.createTyped(name, bushSupplier);
    }

    static RegistryObject<FlowerBlock> createFlower(String name, BlockBehaviour.Properties properties,
                                                    Supplier<MobEffect> mobEffect, int duration) {
        return BlockFactory.createTyped(name, () -> new FlowerBlock(mobEffect, duration, properties.noOcclusion().noCollission()));
    }

    static RegistryObject<FlowerPotBlock> createPottedFlower(String name, Supplier<? extends Block> flowerBlockSupplier,
                                                             BlockBehaviour.Properties properties) {
        return BlockFactory.createTyped(name, () -> new FlowerPotBlock(
                () -> ((FlowerPotBlock) Blocks.FLOWER_POT), flowerBlockSupplier, properties.noOcclusion().noCollission()
        ));
    }

    static RegistryObject<BushBlock> createBush(String name, BlockBehaviour.Properties properties) {
        return BlockFactory.createTyped(name, () -> new BushBlock(properties.noOcclusion().noCollission()));
    }

    static RegistryObject<FlowerPotBlock> createBush(String name, BlockBehaviour.Properties properties,
                                                     Supplier<FlowerPotBlock> emptyPot, Supplier<? extends Block> potContent) {
        return BlockFactory.createTyped(name, () -> new FlowerPotBlock(emptyPot, potContent, properties));
    }
}
