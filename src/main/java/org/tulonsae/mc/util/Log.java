package org.tulonsae.mc.util;

import java.util.logging.Logger;

/**
 * Logger utility class for TulSys.
 *
 * @author Tulonsae
 */
public class Log {

    private String prefix;

    /**
     * Bukkit server logger
     */
    private static final Logger log = Logger.getLogger("Minecraft");

    /**
     * Main plugin
     */
    public Log(String pluginName) {
        this.prefix = "[" + pluginName + "]";
    }

    /**
     * Plugin component
     */
    public Log(String pluginName, String componentName) {
        this.prefix = "[" + pluginName + "]" + ":" + componentName;
    }

    /**
     * Send an info level log to the console.
     */
    public void info(String msg) {
        log.info(prefix + " " + msg);
    }

    /**
     * Send a warning level log to the console.
     */
    public void warning(String msg) {
        log.warning(prefix + " " + msg);
    }

    /**
     * Send a severe level log to the console.
     */
    public void severe(String msg) {
        log.severe(prefix + " " + msg);
    }
}
