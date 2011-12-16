package org.tulonsae.mc.kit;

import org.tulonsae.mc.Constants;
import org.tulonsae.mc.TulSys;
import org.tulonsae.mc.util.Log;

/**
 * Base class for kit component.
 *
 * @author Tulonsae
 */
public class KitComponent {

    // Component information: name, commands
    private String name = Constants.KIT_NAME;
    private String kitCmd = Constants.KIT_CMD_HELP;
    private String kitCmdGet = Constants.KIT_CMD_GET;
    private String kitCmdGive = Constants.KIT_CMD_GIVE;
    private String kitCmdList = Constants.KIT_CMD_LIST;
    private String kitCmdAdmin = Constants.KIT_CMD_ADMIN;

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
     * Initialize kit component.
     */
    public void init() {
        // setup component logger
        log = new Log(plugin.getDescription().getName(), name);

        // register commands
        log.info("registering commands");
        plugin.getCommand(kitCmd).setExecutor(new Commands(plugin, log));
        plugin.getCommand(kitCmdGet).setExecutor(new Commands(plugin, log));
        plugin.getCommand(kitCmdGive).setExecutor(new Commands(plugin, log));
        plugin.getCommand(kitCmdList).setExecutor(new Commands(plugin, log));
        plugin.getCommand(kitCmdAdmin).setExecutor(new Commands(plugin, log));
    }
}
