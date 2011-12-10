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
//    private FileConfiguration config;

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
        getConfig().options().copyDefaults();
//        loadConfig();
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

    /**
     * Loads the plugin configuration file.
     * Creates a new one if it doesn't exist. TODO
     * Creates new default entries if they don't exist. TODO
     */
//    private void loadConfig() {
//        config = getConfig();
//    }
}
