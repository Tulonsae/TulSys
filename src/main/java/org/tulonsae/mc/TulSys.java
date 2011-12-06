package org.tulonsae.mc;

import org.tulonsae.mc.util.Log;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Base Bukkit plugin class for TulSys.
 *
 * @author Tulonsae
 */
public class TulSys extends JavaPlugin {

    private String name;
    private String version;
    private Log log;

    /**
     * Called when this plugin is enabled.
     * Loads the configuration and registers for Bukkit events.
     */
    public void onEnable() {

        // get plugin info
        name = this.getDescription().getName();
        version = this.getDescription().getVersion();

        // setup main logger
        log = new Log(name);
        
        // log enable message
        log.info("version " + version + " enabled.");
    }

    /**
     * Called when this plugin is disabled.
     */
    public void onDisable() {
        
        // log disable message
        log.info("version " + version + " disabled.");
    }
}
