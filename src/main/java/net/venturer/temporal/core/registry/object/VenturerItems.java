package net.venturer.temporal.core.registry.object;

import net.minecraft.world.item.*;
import net.venturer.temporal.Venturer;
import net.venturer.temporal.core.registry.factory.ItemFactory;
import net.venturer.temporal.core.registry.factory.item.ArmorFactory;
import net.venturer.temporal.core.registry.factory.item.EdibleItemFactory;
import net.venturer.temporal.core.registry.factory.item.MusicDiscFactory;
import net.venturer.temporal.core.registry.factory.item.WeaponFactory;
import net.venturer.temporal.core.util.log.LoggingRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class VenturerItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, Venturer.MOD_ID);

    public static final RegistryObject<Item> FROZEN_TRIDENT = ItemFactory.create("frozen_trident");
    public static final RegistryObject<SmithingTemplateItem> CHILL_ARMOR_TRIM_SMITHING_TEMPLATE = ArmorFactory.createSmithingTemplate("chill_armor_trim_smithing_template");
    public static final RegistryObject<Item> FROZEN_EMERALD = ItemFactory.create("frozen_emerald");
    public static final RegistryObject<Item> FROZEN_SALMON = ItemFactory.create("frozen_salmon");
    public static final RegistryObject<Item> FROZEN_COD = ItemFactory.create("frozen_cod");
    public static final RegistryObject<Item> FROZEN_PUFFERFISH = ItemFactory.create("frozen_pufferfish");
    public static final RegistryObject<Item> FROZEN_IRON_HORSE_ARMOR = ItemFactory.create("frozen_iron_horse_armor");
    public static final RegistryObject<Item> FROZEN_NAUTILUS_SHELL = ItemFactory.create("frozen_nautilus_shell");
    public static final RegistryObject<Item> NETTLE_LEAVES = ItemFactory.create("nettle_leaves");
    public static final RegistryObject<BowlFoodItem> NETTLE_SOUP = EdibleItemFactory.createBowl("nettle_soup", 5, 0.5f);
    public static final RegistryObject<RecordItem> MUSIC_DISC_THAW = MusicDiscFactory.create("music_disc_thaw", VenturerSoundEvents.MUSIC_DISC_THAW, 3, 6440);

    //EXPERIMENTAL
    public static final RegistryObject<Item> ANCIENT_BOW = WeaponFactory.createAncientBow("ancient_bow", new Item.Properties().durability(427).rarity(Rarity.EPIC));
    public static final RegistryObject<Item> ANCIENT_ARROW = WeaponFactory.createAncientArrow("ancient_arrow", new Item.Properties().rarity(Rarity.EPIC));

    public static void register(IEventBus eventBus) {
        LoggingRegistry.register(ITEMS, "items", eventBus);
    }
}
