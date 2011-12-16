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

    // Component information: commands
    private static String kitCmd = Constants.KIT_CMD_HELP;
    private static String kitCmdGet = Constants.KIT_CMD_GET;
    private static String kitCmdGive = Constants.KIT_CMD_GIVE;
    private static String kitCmdList = Constants.KIT_CMD_LIST;
    private static String kitCmdAdmin = Constants.KIT_CMD_ADMIN;

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

        // admin commands
        if (cmd.getName().equalsIgnoreCase(kitCmdAdmin)) {
            log.info("Executing kit admin command");

            // new command
            if (args[0].equalsIgnoreCase("new")) {
                // 2 args required
                if (args.length < 2) {
                    return false;
                }

                return execKitadmNew(args[1].toLowerCase());
            }

            // newdesc command
            if (args[0].equalsIgnoreCase("newdesc")) {
                // 3 args required
                if (args.length < 3) {
                    return false;
                }

                return execKitadmNewdesc(args);
            }

            // command not recognized
            return false;
        }

        // command not found
        return false;
    }

    /**
     * Execute kit admin new command.
     */
    private Boolean execKitadmNew(String kitName) {
        // check if kit name exists
        if (Kit.exists(plugin, kitName)) {
            log.info("Kit " + kitName + " already exists.");
            return true;
        }

        // create kit, with defaults
        Kit kit = new Kit(kitName);
        log.info("Created kit: " + kit.getName());

        // list kit info
        listKitInfo(kit);

        // save kit
        kit.save(plugin);

        // command completed
        return true;
    }

    /**
     * Execute kit admin new description command.
     */
    private Boolean execKitadmNewdesc(String[] args) {
        String kitName = args[1].toLowerCase();
        String kitDescription = combineArgs(2, args);

        // make sure kit exists
        if (!Kit.exists(plugin, kitName)) {
            log.info("Kit " + kitName + " doesn't exist.");
            return true;
        }

        // load kit data
        Kit kit = new Kit(kitName);
        kit.load(plugin);

        // make sure description doesn't exist
        if (kit.getDescription() != null) {
            log.info("Kit " + kitName + ": description already exists.");
            return true;
        }

        // add new description
        kit.setDescription(kitDescription);
        log.info("Created description for kit" + kit.getName());

        // list kit info
        listKitInfo(kit);

        // save kit
        kit.save(plugin);

        // command completed
        return true;
    }

    /**
     * List kit info on one line
     * Todo - see if this causes a problem with chat line limit
     * Todo - add items
     */
    private void listKitInfo(Kit kit) {
        log.info(kit.getName() + ": "
                    + "frequency[" + kit.getFreqDisplay() + "], "
                    + "repeatable[" + kit.isRepeatable() + "], "
                    + "conditional[" + kit.isConditional() + "], "
                    + "description[" + kit.getDescription() +"].");
    }

    /**
     * Combine args into a string.
     */
    String combineArgs(Integer index, String[] args) {
        StringBuilder buf = new StringBuilder();

        // combine args into a string
        for (int i = index; i < args.length; i++) {
             buf.append(" " + args[i]);
        }

        // return string
        return buf.toString().trim();
    }
}
