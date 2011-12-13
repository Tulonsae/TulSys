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
     * Constructor passes in the plugin and component log.
     */
    public KitCommands(TulSys instance, Log componentLog) {
        plugin = instance;
        log = componentLog;
    }

    /**
     * Execute kit component commands.
     */
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // help command
        if (cmd.getName().equalsIgnoreCase(kitCmd)) {
            log.info("tbd - Execute kit help command");
            return true;
        }

        // get command
        if (cmd.getName().equalsIgnoreCase(kitCmdGet)) {
            log.info("tbd - Execute kit get command");
            return true;
        }

        // give command
        if (cmd.getName().equalsIgnoreCase(kitCmdGive)) {
            log.info("tbd - Execute kit give command");
            return true;
        }

        // list command
        if (cmd.getName().equalsIgnoreCase(kitCmdList)) {
            log.info("tbd - Execute kit list command");
            return true;
        }

        // admin command
        if (cmd.getName().equalsIgnoreCase(kitCmdAdmin)) {
            log.info("tbd - Execute kit admin command");
            return true;
        }

        // command not found
        return false;
    }
}
