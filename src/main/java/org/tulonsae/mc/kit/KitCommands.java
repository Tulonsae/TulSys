package org.tulonsae.mc.kit;

import org.tulonsae.mc.Constants;
import org.tulonsae.mc.TulSys;
import org.tulonsae.mc.util.Log;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Commands for kit component.
 *
 * @author Tulonsae
 */
public class KitCommands implements CommandExecutor {

    // Component information: name
    private String name = Constants.KIT_NAME;

    // Log file
    private Log log;

    // Plugin instance
    private TulSys plugin;

    /**
     * Constructor passes in the plugin itself.
     */
    public KitCommands(TulSys instance, Log componentLog) {
        plugin = instance;
        log = componentLog;
    }

    /**
     * Execute kit component commands.
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        log.info("Got here");

        return true;
    }
}
