package net.venturer.cyber2000.core.util.log;

import net.venturer.cyber2000.Venturer;

public class InfoLoggable implements Loggable{
    private final String name;

    public InfoLoggable(String name) {
        this.name = name;
    }

    @Override
    public void log() {
        Venturer.logger.info("Loading {}!", name);
        Venturer.logger.info("Loading was successfully finished!");
    }
}
