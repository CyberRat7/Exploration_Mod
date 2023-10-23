package net.venture.cyber2000.core.util.log;

import net.venture.cyber2000.Venture;

public class InfoLoggable implements Loggable{
    private final String name;

    public InfoLoggable(String name) {
        this.name = name;
    }

    @Override
    public void log() {
        Venture.logger.info("Loading {}!", name);
        Venture.logger.info("Loading was successfully finished!");
    }
}
