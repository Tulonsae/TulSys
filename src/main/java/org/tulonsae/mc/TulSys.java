package org.tulonsae.mc;

import java.io.File;

import org.tulonsae.mc.kit.KitComponent;
import org.tulonsae.mc.util.Log;

import org.bukkit.configuration.file.FileConfiguration;
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
    @Override
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

        // load kit component
        String kit_flag = Constants.KIT_SECTION + Constants.CFG_SEP + Constants.CFG_FLAG;
        checkBooleanConfigValue(kit_flag);
        if (getConfig().getBoolean(kit_flag)) {
            log.info(Constants.KIT_NAME + " component on.");

            // initialize kit component
            KitComponent kitComponent = new KitComponent(this);
            kitComponent.init();
        } else {
            log.info(Constants.KIT_NAME + " component off.");
        }

        // log enabled message
        log.info("version " + version + " enabled.");
    }

    /**
     * Called when this plugin is disabled.
     */
    @Override
    public void onDisable() {

        // log disabling message
        log.info("disabling version " + version + ".");

        // save configuration
        saveConfig();
        
        // log disabled message
        log.info("version " + version + " disabled.");
    }

    /**
     * Checks if a configuration value is boolean.
     * If not, sets it to false.
     */
    private void checkBooleanConfigValue(String path) {
        if (!getConfig().isBoolean(path)) {
            getConfig().set(path, false);
        }
    }
}
