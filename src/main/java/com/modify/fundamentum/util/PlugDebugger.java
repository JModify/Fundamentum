package com.modify.fundamentum.util;

import com.modify.fundamentum.Fundamentum;
import lombok.Getter;
import lombok.Setter;

public class PlugDebugger {

    @Getter @Setter private boolean debugMode;

    public PlugDebugger() {
        this.debugMode = false;
    }

    public void sendDebugInfo(String s) {
        if (isDebugMode()) {
            Fundamentum.getPlugin().getLogger().info(s);
        }
    }

    public void sendDebugError(String s) {
        if (isDebugMode()) {
            Fundamentum.getPlugin().getLogger().severe(s);
        }
    }

    public void sendDebugWarning(String s) {
        if (isDebugMode()) {
            Fundamentum.getPlugin().getLogger().warning(s);
        }
    }

}
