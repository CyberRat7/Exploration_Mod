package net.venturer.temporal.core.registry.facade;

import com.temporal.api.core.registry.factory.common.ItemFactory;
import com.temporal.api.core.registry.factory.extension.item.*;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;
import net.venturer.temporal.core.registry.object.VenturerItems;

import java.util.function.Supplier;

public class VenturerItemFactoryFacade extends ItemFactory implements ArrowExtension, BowExtension, BowlExtension, MusicDiscExtension, SmithingTemplateExtension {
    private static volatile VenturerItemFactoryFacade instance;

    private VenturerItemFactoryFacade() {
        super(VenturerItems.ITEMS);
    }
    
    public RegistryObject<ArrowItem> createArrow(String name, Object... args) {
        return ArrowExtension.super.createArrow(name, this, args);
    }
    
    public RegistryObject<? extends ArrowItem> createArrow(String name, Supplier<? extends ArrowItem> tTypedSupplier) {
        return ArrowExtension.super.createArrow(name, this, tTypedSupplier);
    }

    public RegistryObject<BowItem> createBow(String name, Object... args) {
        return BowExtension.super.createBow(name, this, args);
    }

    public RegistryObject<? extends BowItem> createBow(String name, Supplier<? extends BowItem> tTypedSupplier) {
        return BowExtension.super.createBow(name, this, tTypedSupplier);
    }

    public RegistryObject<BowlFoodItem> createBowl(String name, Object... args) {
        return BowlExtension.super.createBowl(name, this, args);
    }

    public RegistryObject<? extends BowlFoodItem> createBowl(String name, Supplier<? extends BowlFoodItem> tTypedSupplier) {
        return BowlExtension.super.createBowl(name, this, tTypedSupplier);
    }
    
    public RegistryObject<RecordItem> createMusicDisc(String name, Object... args) {
        return MusicDiscExtension.super.createMusicDisc(name, this, args);
    }
    
    public RegistryObject<? extends RecordItem> createMusicDisc(String name, Supplier<? extends RecordItem> tTypedSupplier) {
        return MusicDiscExtension.super.createMusicDisc(name, this, tTypedSupplier);
    }
    
    public RegistryObject<SmithingTemplateItem> createSmithingTemplate(String name, Object... args) {
        return SmithingTemplateExtension.super.createSmithingTemplate(name, this, args);
    }
    
    public RegistryObject<? extends SmithingTemplateItem> createSmithingTemplate(String name, Supplier<? extends SmithingTemplateItem> tTypedSupplier) {
        return SmithingTemplateExtension.super.createSmithingTemplate(name, this, tTypedSupplier);
    }

    public static VenturerItemFactoryFacade getInstance() {
        if (instance == null) {
            synchronized (VenturerItemFactoryFacade.class) {
                if (instance == null) {
                    instance = new VenturerItemFactoryFacade();
                }
            }
        }

        return instance;
    }
}
