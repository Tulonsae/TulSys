package org.tulonsae.mc.kit;

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
public class Commands implements CommandExecutor {

    // Log file
    private Log log;

    // Plugin instance
    private TulSys plugin;

    /**
     * Constructor passes in the plugin and component log.
     */
    public Commands(TulSys instance, Log componentLog) {
        plugin = instance;
        log = componentLog;
    }

    /**
     * Execute kit component commands.
     */
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // help command
        if (cmd.getName().equalsIgnoreCase(Constants.KIT_CMD_HELP)) {
            log.info("tbd - Execute kit help command");
            return true;
        }

        // get command
        if (cmd.getName().equalsIgnoreCase(Constants.KIT_CMD_GET)) {
            log.info("tbd - Execute kit get command");
            return true;
        }

        // give command
        if (cmd.getName().equalsIgnoreCase(Constants.KIT_CMD_GIVE)) {
            log.info("tbd - Execute kit give command");
            return true;
        }

        // list command
        if (cmd.getName().equalsIgnoreCase(Constants.KIT_CMD_LIST)) {
            log.info("tbd - Execute kit list command");
            return true;
        }

        // manager help command
        if (cmd.getName().equalsIgnoreCase(Constants.KIT_CMD_MGR_HELP)) {
            log.info("tbd - Execute kitmgr help command");
            return true;
        }

        // new kit command
        if (cmd.getName().equalsIgnoreCase(Constants.KIT_CMD_MGR_NEW)) {
            // 1 arg required
            if (args.length < 1) {
                return false;
            }

            return execNewKit(args[0].toLowerCase());
        }

        // new description command
        if (cmd.getName().equalsIgnoreCase(Constants.KIT_CMD_MGR_DESC)) {
            // 2 args required
            if (args.length < 2) {
                return false;
            }

            return execNewDesc(args);
        }

        // command not found
        return false;
    }

    /**
     * Execute command - create new kit.
     */
    private Boolean execNewKit(String kitName) {
        // check if kit name exists
        if (Kit.exists(plugin, kitName)) {
            log.info("Kit " + kitName + " already exists.");
            return true;
        }

        // create kit, with defaults
        Kit kit = new Kit(kitName);
        log.info("Created kit: " + kit.getName());

        // list kit summary
        listKitSummary(kit);

        // save kit
        kit.save(plugin);

        // command completed
        return true;
    }

    /**
     * Execute command - new description for existing kit.
     */
    private Boolean execNewDesc(String[] args) {
        String kitName = args[0].toLowerCase();
        String kitDescription = combineArgs(1, args);

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

        // list kit summary
        listKitSummary(kit);

        // save kit
        kit.save(plugin);

        // command completed
        return true;
    }

    /**
     * List kit summary on one line
     * Todo - see if this causes a problem with chat line limit
     * Todo - add items
     */
    private void listKitSummary(Kit kit) {
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
