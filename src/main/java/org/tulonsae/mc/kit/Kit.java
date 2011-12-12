package org.tulonsae.mc.kit;

import org.tulonsae.mc.Constants;
import org.tulonsae.mc.TulSys;
import org.tulonsae.mc.util.Log;

/**
 * Base class for kit component.
 *
 * @author Tulonsae
 */
public class Kit {

    // Component information: name
    private String name = Constants.KIT_NAME;
    private String kitCmd = Constants.KIT_CMD;

    // Log file
    private Log log;

    // Plugin instance
    private TulSys plugin;

    /**
     * Constructor passes in the plugin itself.
     */
    public Kit(TulSys instance) {
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
        //plugin.getCommand(kitCmd).setExecutor(new KitCommands(plugin, log));
    }
}
