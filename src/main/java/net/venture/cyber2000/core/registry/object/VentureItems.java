package net.venture.cyber2000.core.registry.object;

import net.minecraft.world.item.*;
import net.venture.cyber2000.Venture;
import net.venture.cyber2000.core.registry.factory.DefaultItemFactory;
import net.venture.cyber2000.core.registry.factory.item.ArmorFactory;
import net.venture.cyber2000.core.registry.factory.item.EdibleItemFactory;
import net.venture.cyber2000.core.registry.factory.item.MusicDiscFactory;
import net.venture.cyber2000.core.registry.factory.item.WeaponFactory;
import net.venture.cyber2000.core.util.log.LoggingRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class VentureItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, Venture.MOD_ID);

    public static final RegistryObject<Item> FROZEN_TRIDENT = DefaultItemFactory.create("frozen_trident");
    public static final RegistryObject<SmithingTemplateItem> CHILL_ARMOR_TRIM_SMITHING_TEMPLATE = ArmorFactory.create("chill_armor_trim_smithing_template");
    public static final RegistryObject<Item> FROZEN_EMERALD = DefaultItemFactory.create("frozen_emerald");
    public static final RegistryObject<Item> FROZEN_SALMON = DefaultItemFactory.create("frozen_salmon");
    public static final RegistryObject<Item> FROZEN_COD = DefaultItemFactory.create("frozen_cod");
    public static final RegistryObject<Item> FROZEN_PUFFERFISH = DefaultItemFactory.create("frozen_pufferfish");
    public static final RegistryObject<Item> FROZEN_IRON_HORSE_ARMOR = DefaultItemFactory.create("frozen_iron_horse_armor");
    public static final RegistryObject<Item> FROZEN_NAUTILUS_SHELL = DefaultItemFactory.create("frozen_nautilus_shell");
    public static final RegistryObject<Item> NETTLE_LEAVES = DefaultItemFactory.create("nettle_leaves");
    public static final RegistryObject<BowlFoodItem> NETTLE_SOUP = EdibleItemFactory.createBowl("nettle_soup", 5, 0.5f);
    public static final RegistryObject<RecordItem> MUSIC_DISC_THAW = MusicDiscFactory.create("music_disc_thaw", VentureSoundEvents.MUSIC_DISC_THAW, 3, 6440);

    //EXPERIMENTAL
    public static final RegistryObject<Item> ANCIENT_BOW = WeaponFactory.createAncientBow("ancient_bow", new Item.Properties().durability(427).rarity(Rarity.EPIC));
    public static final RegistryObject<Item> ANCIENT_ARROW = WeaponFactory.createAncientArrow("ancient_arrow", new Item.Properties().rarity(Rarity.EPIC));

    public static void register(IEventBus eventBus) {
        LoggingRegistry.register(ITEMS, "items", eventBus);
    }
}
