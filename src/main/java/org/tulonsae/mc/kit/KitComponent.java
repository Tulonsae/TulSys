package org.tulonsae.mc.kit;

import org.tulonsae.mc.TulSys;
import org.tulonsae.mc.util.Log;

/**
 * Base class for kit component.
 *
 * @author Tulonsae
 */
public class KitComponent {

    // Log file
    private Log log;

    // Plugin instance
    private TulSys plugin;

    /**
     * Constructor passes in the plugin itself.
     */
    public KitComponent(TulSys instance) {
        plugin = instance;
    }

    /**
     * Get component name.
     */
    public static final String getName() {
        return Constants.NAME;
    }

    /**
     * Initialize kit component.
     */
    public void init() {
        // setup component logger
        log = new Log(plugin.getDescription().getName(), getName());

        // register commands
        log.info("registering commands");
        plugin.getCommand(Constants.KIT_CMD_HELP).setExecutor(new Commands(plugin, log));
        plugin.getCommand(Constants.KIT_CMD_GET).setExecutor(new Commands(plugin, log));
        plugin.getCommand(Constants.KIT_CMD_GIVE).setExecutor(new Commands(plugin, log));
        plugin.getCommand(Constants.KIT_CMD_LIST).setExecutor(new Commands(plugin, log));
        plugin.getCommand(Constants.KIT_CMD_MGR_HELP).setExecutor(new Commands(plugin, log));
        plugin.getCommand(Constants.KIT_CMD_MGR_NEW).setExecutor(new Commands(plugin, log));
        plugin.getCommand(Constants.KIT_CMD_MGR_DESC).setExecutor(new Commands(plugin, log));
    }
}
