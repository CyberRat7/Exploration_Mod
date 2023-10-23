package net.venture.cyber2000.core.registry.factory;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static net.venture.cyber2000.core.registry.object.VentureBlocks.BLOCKS;

public interface DefaultBlockFactory extends ObjectFactory {
    static RegistryObject<Block> create(String name, BlockBehaviour.Properties properties) {
        return create(name, () -> new Block(properties));
    }

    private static RegistryObject<Block> create(String name, Supplier<Block> blockSupplier) {
        return BLOCKS.register(name, blockSupplier);
    }

    static <T extends Block> RegistryObject<T> createTyped(String name, Supplier<T> typedBlockSupplier) {
        return BLOCKS.register(name, typedBlockSupplier);
    }
}
