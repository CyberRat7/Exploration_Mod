package net.explorationmod.cyber2000.core.util.log;

import net.explorationmod.cyber2000.ExplorationMod;

public class InfoLoggable implements Loggable{
    private final String name;

    public InfoLoggable(String name) {
        this.name = name;
    }

    @Override
    public void log() {
        ExplorationMod.logger.info("Loading {}!", name);
        ExplorationMod.logger.info("Loading was successfully finished!");
    }
}
