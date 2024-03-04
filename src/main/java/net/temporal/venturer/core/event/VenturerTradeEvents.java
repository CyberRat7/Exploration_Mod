package net.temporal.venturer.core.event;

import com.temporal.api.core.event.trade.SimpleTradeCustomizer;
import com.temporal.api.core.event.trade.TradeCustomizer;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.temporal.venturer.Venturer;

@Mod.EventBusSubscriber(modid = Venturer.MOD_ID)
public class VenturerTradeEvents {
    private static final TradeCustomizer tradeCustomizer = new SimpleTradeCustomizer();

    @SubscribeEvent
    public static void addCustomWandererTrade(WandererTradesEvent event) {
//        tradeCustomizer.customize(event, new WandererTrade(
//                new TradingItemHolder(Items.EMERALD, 25),
//                new TradingItemHolder(VenturerItems.ANCIENT_BOW.get(), 1),
//                new WandererTradeDescription(WandererTradeDescription.TradeRarity.RARE, 2, 13, 0.5f)
//        ));
    }
}
