package net.temporal.venturer.core.registry.object;

import com.temporal.api.common.block.FlammableRotatedPillarBlock;
import com.temporal.api.core.registry.factory.common.BlockFactory;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.temporal.venturer.common.object.block.StingingNettleBlock;
import net.temporal.venturer.core.registry.facade.VenturerBlockFactory;

public class VenturerBlocks {
    public static final VenturerBlockFactory BLOCK_FACTORY = VenturerBlockFactory.getInstance();

    public static final RegistryObject<? extends FlowerBlock> STINGING_NETTLE = BLOCK_FACTORY.createFlower("stinging_nettle", () ->
            new StingingNettleBlock(BlockBehaviour.Properties.copy(Blocks.DEAD_BUSH)));
    public static final RegistryObject<FlowerPotBlock> POTTED_STINGING_NETTLE = BLOCK_FACTORY.createPot("potted_stinging_nettle",
            BlockBehaviour.Properties.copy(Blocks.POTTED_DEAD_BUSH), STINGING_NETTLE);
    public static final RegistryObject<Block> BAG_OF_NETTLE_LEAVES = BLOCK_FACTORY.create("bag_of_nettle_leaves", BlockBehaviour.Properties.copy(Blocks.BLACK_WOOL));

    public static final RegistryObject<Block> JUNIPER_PLANKS = BLOCK_FACTORY.create("juniper_planks", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS));
    public static final RegistryObject<LeavesBlock> JUNIPER_LEAVES = BLOCK_FACTORY.createLeaves("juniper_leaves", BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES));
    public static final RegistryObject<LeavesBlock> FLOWERING_JUNIPER_LEAVES = BLOCK_FACTORY.createLeaves("flowering_juniper_leaves", BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES));
    public static final RegistryObject<LeavesBlock> FRUITING_JUNIPER_LEAVES = BLOCK_FACTORY.createLeaves("fruiting_juniper_leaves", BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES));
    public static final RegistryObject<LeavesBlock> BUDDING_JUNIPER_LEAVES = BLOCK_FACTORY.createLeaves("budding_juniper_leaves", BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES));
    public static final RegistryObject<FlammableRotatedPillarBlock> JUNIPER_LOG = BLOCK_FACTORY.createFlammableRotatedPillar( "juniper_log", BlockBehaviour.Properties.copy(Blocks.ACACIA_LOG));
    public static final RegistryObject<FlammableRotatedPillarBlock> JUNIPER_WOOD = BLOCK_FACTORY.createFlammableRotatedPillar( "juniper_wood", BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD));
    public static final RegistryObject<FlammableRotatedPillarBlock> STRIPPED_JUNIPER_LOG = BLOCK_FACTORY.createFlammableRotatedPillar( "stripped_juniper_log", BlockBehaviour.Properties.copy(Blocks.ACACIA_LOG));
    public static final RegistryObject<FlammableRotatedPillarBlock> STRIPPED_JUNIPER_WOOD = BLOCK_FACTORY.createFlammableRotatedPillar( "stripped_juniper_wood", BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD));
    public static final RegistryObject<PressurePlateBlock> JUNIPER_PRESSURE_PLATE = BLOCK_FACTORY.createPressurePlate( "juniper_pressure_plate", BlockBehaviour.Properties.copy(Blocks.ACACIA_PRESSURE_PLATE), BlockSetType.OAK, PressurePlateBlock.Sensitivity.EVERYTHING);
    public static final RegistryObject<TrapDoorBlock> JUNIPER_TRAPDOOR = BLOCK_FACTORY.createTrapDoor( "juniper_trapdoor", BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), BlockSetType.OAK);
    public static final RegistryObject<DoorBlock> JUNIPER_DOOR = BLOCK_FACTORY.createDoor( "juniper_door", BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), BlockSetType.OAK);
    public static final RegistryObject<SlabBlock> JUNIPER_SLAB = BLOCK_FACTORY.createSlab( "juniper_slab", BlockBehaviour.Properties.copy(Blocks.OAK_SLAB));
    public static final RegistryObject<StairBlock> JUNIPER_STAIRS= BLOCK_FACTORY.createStair( "juniper_stairs", Blocks.ACACIA_STAIRS ,BlockBehaviour.Properties.copy(Blocks.ACACIA_STAIRS));
    public static final RegistryObject<FenceBlock> JUNIPER_FENCE = BLOCK_FACTORY.createFence("juniper_fence", BlockBehaviour.Properties.copy(Blocks.OAK_FENCE));
    public static final RegistryObject<FenceGateBlock> JUNIPER_FENCE_GATE = BLOCK_FACTORY.createFenceGate("juniper_fence_gate", BlockBehaviour.Properties.copy(Blocks.OAK_FENCE), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE);
    public static final RegistryObject<ButtonBlock> JUNIPER_BUTTON = BLOCK_FACTORY.createButton( "juniper_button", BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), BlockSetType.OAK, 15, true);
    public static final RegistryObject<LeavesBlock> JUNIPER_ROOTS = BLOCK_FACTORY.createLeaves("juniper_roots", BlockBehaviour.Properties.copy(Blocks.MANGROVE_ROOTS));
    public static final RegistryObject<LeavesBlock> RED_SANDY_JUNIPER_ROOTS = BLOCK_FACTORY.createLeaves("red_sandy_juniper_roots", BlockBehaviour.Properties.copy(Blocks.MANGROVE_ROOTS));
    public static void register(IEventBus eventBus) {
        BlockFactory.getInstance().register(eventBus);
    }
}
