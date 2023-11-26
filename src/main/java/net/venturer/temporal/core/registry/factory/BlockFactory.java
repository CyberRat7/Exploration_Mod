package net.venturer.temporal.core.registry.factory;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static net.venturer.temporal.core.registry.object.VenturerBlocks.BLOCKS;

public interface BlockFactory extends ObjectFactory {
    static RegistryObject<Block> create(String name, BlockBehaviour.Properties properties) {
        return create(name, () -> new Block(properties));
    }

    private static RegistryObject<Block> create(String name, Supplier<Block> blockSupplier) {
        RegistryObject<Block> block = BLOCKS.register(name, blockSupplier);
        ItemFactory.createTyped(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    static <T extends Block> RegistryObject<T> createTyped(String name, Supplier<T> typedBlockSupplier) {
        RegistryObject<T> typedBlock = BLOCKS.register(name, typedBlockSupplier);
        ItemFactory.createTyped(name, () -> new BlockItem(typedBlock.get(), new Item.Properties()));
        return typedBlock;
    }
}
