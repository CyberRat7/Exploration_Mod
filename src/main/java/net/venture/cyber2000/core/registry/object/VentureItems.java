package net.venture.cyber2000.core.registry.object;

import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;
import net.venture.cyber2000.Venture;
import net.venture.cyber2000.common.object.item.AncientArrowItem;
import net.venture.cyber2000.common.object.item.AncientBowItem;
import net.venture.cyber2000.core.registry.factory.DefaultItemFactory;
import net.venture.cyber2000.core.registry.factory.item.FoodItemFactory;
import net.venture.cyber2000.core.registry.factory.item.MusicDiscFactory;
import net.venture.cyber2000.core.registry.factory.item.WeaponFactory;
import net.venture.cyber2000.core.util.log.LoggingRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class VentureItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, Venture.MOD_ID);

    public static final RegistryObject<Item> FROZEN_TRIDENT = DefaultItemFactory.create("frozen_trident");
    public static final RegistryObject<Item> FROZEN_EMERALD = DefaultItemFactory.create("frozen_emerald");
    public static final RegistryObject<Item> FROZEN_SALMON = DefaultItemFactory.create("frozen_salmon");
    public static final RegistryObject<Item> FROZEN_COD = DefaultItemFactory.create("frozen_cod");
    public static final RegistryObject<Item> FROZEN_PUFFERFISH = DefaultItemFactory.create("frozen_pufferfish");
    public static final RegistryObject<Item> FROZEN_NAUTILUS_SHELL = DefaultItemFactory.create("frozen_nautilus_shell");
    public static final RegistryObject<Item> NETTLE_LEAVES = DefaultItemFactory.create("nettle_leaves");
    public static final RegistryObject<BowlFoodItem> NETTLE_SOUP = FoodItemFactory.createBowl("nettle_soup", 5, 4);
    public static final RegistryObject<RecordItem> FROZEN_DISC = MusicDiscFactory.create("frozen_disc", VentureSoundEvents.FROZEN_DISC_SOUND, 3, 1240);

    //EXPERIMENTAL
    public static final RegistryObject<Item> ANCIENT_BOW = WeaponFactory.createAncientBow("ancient_bow", new Item.Properties().durability(427).rarity(Rarity.EPIC));
    public static final RegistryObject<Item> ANCIENT_ARROW = WeaponFactory.createAncientArrow("ancient_arrow", new Item.Properties().rarity(Rarity.EPIC));

    public static void register(IEventBus eventBus) {
        LoggingRegistry.register(ITEMS, "items", eventBus);
    }
}
