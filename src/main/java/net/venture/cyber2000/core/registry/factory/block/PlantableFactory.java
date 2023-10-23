package net.venture.cyber2000.core.registry.factory.block;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;
import net.venture.cyber2000.core.registry.factory.DefaultBlockFactory;

import java.util.function.Supplier;

public interface PlantableFactory extends DefaultBlockFactory {
    static RegistryObject<FlowerBlock> createFlower(String name, BlockBehaviour.Properties properties,
                                                    Supplier<MobEffect> mobEffect, int duration) {
        return DefaultBlockFactory.createTyped(name, () -> new FlowerBlock(mobEffect, duration, properties));
    }

    static RegistryObject<BushBlock> createBush(String name, BlockBehaviour.Properties properties) {
        return DefaultBlockFactory.createTyped(name, () -> new BushBlock(properties));
    }

    static RegistryObject<FlowerPotBlock> createBush(String name, BlockBehaviour.Properties properties,
                                                     Supplier<FlowerPotBlock> emptyPot, Supplier<? extends Block> potContent) {
        return DefaultBlockFactory.createTyped(name, () -> new FlowerPotBlock(emptyPot, potContent, properties));
    }
}
