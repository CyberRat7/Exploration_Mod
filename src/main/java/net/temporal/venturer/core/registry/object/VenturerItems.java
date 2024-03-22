package net.temporal.venturer.core.registry.object;

import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.temporal.venturer.common.object.item.AncientArrowItem;
import net.temporal.venturer.common.object.item.AncientBowItem;
import net.temporal.venturer.core.registry.facade.VenturerItemFactory;

public class VenturerItems {
    public static final VenturerItemFactory ITEM_FACTORY = VenturerItemFactory.getInstance();

    public static final RegistryObject<Item> FROZEN_TRIDENT = ITEM_FACTORY.create("frozen_trident");
    public static final RegistryObject<SmithingTemplateItem> CHILL_ARMOR_TRIM_SMITHING_TEMPLATE = ITEM_FACTORY.createSmithingTemplate("chill_armor_trim_smithing_template");
    public static final RegistryObject<Item> FROZEN_EMERALD = ITEM_FACTORY.create("frozen_emerald");
    public static final RegistryObject<Item> FROZEN_SALMON = ITEM_FACTORY.create("frozen_salmon");
    public static final RegistryObject<Item> FROZEN_COD = ITEM_FACTORY.create("frozen_cod");
    public static final RegistryObject<Item> FROZEN_PUFFERFISH = ITEM_FACTORY.create("frozen_pufferfish");
    public static final RegistryObject<Item> FROZEN_IRON_HORSE_ARMOR = ITEM_FACTORY.create("frozen_iron_horse_armor");
    public static final RegistryObject<Item> FROZEN_NAUTILUS_SHELL = ITEM_FACTORY.create("frozen_nautilus_shell");
    public static final RegistryObject<Item> NETTLE_LEAVES = ITEM_FACTORY.create("nettle_leaves");
    public static final RegistryObject<BowlFoodItem> NETTLE_SOUP = ITEM_FACTORY.createBowl("nettle_soup", 5, 0.5f);

    public static final RegistryObject<BowlFoodItem> JUNIPER_BERRIES = ITEM_FACTORY.createBowl("juniper_berries", 1, 0.2f);
    public static final RegistryObject<RecordItem> MUSIC_DISC_THAW = ITEM_FACTORY.createMusicDisc("music_disc_thaw", 3, VenturerSoundEvents.MUSIC_DISC_THAW, 6440);
    public static final RegistryObject<Item> COYOTE_FUR = ITEM_FACTORY.create("coyote_fur");
    public static final RegistryObject<ForgeSpawnEggItem> COYOTE_SPAWN_EGG = ITEM_FACTORY.createSpawnEgg("coyote_spawn_egg", VenturerEntityTypes.COYOTE, 0xC2AEA1, 0x6F5445);

    //EXPERIMENTAL
    public static final RegistryObject<? extends BowItem> ANCIENT_BOW = ITEM_FACTORY.createBow("ancient_bow", () -> new AncientBowItem(new Item.Properties().durability(427).rarity(Rarity.EPIC)));
    public static final RegistryObject<? extends ArrowItem> ANCIENT_ARROW = ITEM_FACTORY.createArrow("ancient_arrow", () -> new AncientArrowItem(new Item.Properties().rarity(Rarity.EPIC)));

    public static void register(IEventBus eventBus) {
        ITEM_FACTORY.register(eventBus);
    }
}
