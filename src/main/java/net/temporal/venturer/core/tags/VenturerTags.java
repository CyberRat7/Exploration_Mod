package net.temporal.venturer.core.tags;

import com.temporal.api.core.util.tag.factory.ItemTagFactory;
import com.temporal.api.core.util.tag.factory.TagFactory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class VenturerTags {
	public static final TagFactory ITEM_TAG_FACTORY = ItemTagFactory.getInstance();
	
	public static class Items {
		public static final TagKey<Item> MEATS = ItemTags.create(new ResourceLocation("forge", "meats")); // (TagKey<Item>) ITEM_TAG_FACTORY.createTag("meats");

		public static final TagKey<Item> JUNIPER_LOGS = (TagKey<Item>) ITEM_TAG_FACTORY.createTag("juniper_logs");
		public static final TagKey<Item> EDIBLE = (TagKey<Item>) ITEM_TAG_FACTORY.createTag("edible");
	}
}
