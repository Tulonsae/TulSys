package org.tulonsae.mc;

import java.io.File;

import org.tulonsae.mc.util.Log;

import org.bukkit.configuration.file.FileConfiguration;
//import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Base Bukkit plugin class for TulSys.
 *
 * @author Tulonsae
 */
public class TulSys extends JavaPlugin {

    // Plugin information: name, version, config
    private String name;
    private String version;

    // Log file
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

        // log enabling message
        log.info("enabling version " + version + ".");

        // load configuration
        getConfig().options().copyDefaults(true);
        saveConfig();
        
        // log enabled message
        log.info("version " + version + " enabled.");
    }

    /**
     * Called when this plugin is disabled.
     */
    public void onDisable() {

        // log disabling message
        log.info("disabling version " + version + ".");

        // save configuration
        saveConfig();
        
        // log disabled message
        log.info("version " + version + " disabled.");
    }
}
