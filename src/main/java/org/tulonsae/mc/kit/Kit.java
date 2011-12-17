package org.tulonsae.mc.kit;

import java.util.List;
import java.util.Set;

import org.tulonsae.mc.TulSys;

/**
 * Class representing a kit.
 *
 * @author Tulonsae
 */
public class Kit {

    // Kit data structure.
    private String name;
    private Boolean repeatable;
    private Boolean conditional;
    private String description;
    private Integer frequency;		// in seconds
    private String freqDisplay;		// human readable form
    private List<KitItem> items;
    private String itemsDisplay;	// human readable form

    // Frequency values
    private Integer freqMin = 60;
    private Integer freqHour = 60 * freqMin;
    private Integer freqDay = 24 * freqHour;
    private Integer freqWeek = 7 * freqDay;

    /**
     * Create a kit with default values.
     */
    public Kit(String kitName) {
        name = kitName;
        repeatable = true;
        conditional = false;
        description = null;
        setFrequency(86400);		// default is 1 day
        setItems(null);
    }

    /**
     * Check if kit exists.
     */
    public static Boolean exists(TulSys plugin, String kitName) {
        String cfgSection = Constants.CFG_KITS_PATH;

        // gets just the kit names
        Set<String> keys = plugin.getConfig().getConfigurationSection(cfgSection).getKeys(false);

        // check for the kit
        if (keys.contains(kitName)) {
            return true;
        }

        // kit string path not found
        return false;
    }

    /**
     * Save kit info (into config).
     */
    public void save(TulSys plugin) {
        String cfgName = Constants.CFG_KITS_PATH + Constants.CFG_SEP + getName();
        String cfgRept = cfgName + Constants.CFG_SEP + Constants.CFG_KIT_REPT;
        String cfgCond = cfgName + Constants.CFG_SEP + Constants.CFG_KIT_COND;
        String cfgDesc = cfgName + Constants.CFG_SEP + Constants.CFG_KIT_DESC;
        String cfgFreq = cfgName + Constants.CFG_SEP + Constants.CFG_KIT_FREQ;

        plugin.getConfig().set(cfgDesc, getDescription());
        plugin.getConfig().set(cfgFreq, getFrequency());
        plugin.getConfig().set(cfgRept, isRepeatable());
        plugin.getConfig().set(cfgCond, isConditional());

        plugin.saveConfig();
    }

    /**
     * Load kit info (from config).
     * Kit name is handled by the constructor.
     */
    public void load(TulSys plugin) {
        String cfgName = Constants.CFG_KITS_PATH + Constants.CFG_SEP + getName();
        String cfgRept = cfgName + Constants.CFG_SEP + Constants.CFG_KIT_REPT;
        String cfgCond = cfgName + Constants.CFG_SEP + Constants.CFG_KIT_COND;
        String cfgDesc = cfgName + Constants.CFG_SEP + Constants.CFG_KIT_DESC;
        String cfgFreq = cfgName + Constants.CFG_SEP + Constants.CFG_KIT_FREQ;

        // load data
        // TBD - ? add defaults, if no value ?
        setDescription(plugin.getConfig().getString(cfgDesc));
        setRepeatable(plugin.getConfig().getBoolean(cfgRept));
        setConditional(plugin.getConfig().getBoolean(cfgCond));
        setFrequency(plugin.getConfig().getInt(cfgFreq));
    }

    /**
     * Get kit name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set kit name.
     */
    public void setName(String string) {
        name = string;
    }

    /**
     * Get kit description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set kit description.
     */
    public void setDescription(String string) {
        description = string;
    }

    /**
     * Get kit frequency (in secs).
     */
    public Integer getFrequency() {
        return frequency;
    }

    /**
     * Set kit frequency (in secs)
     * TBD - add one for string
     */
    public void setFrequency(Integer freq) {
        frequency = freq;

        // the human readable string
        StringBuilder buf = new StringBuilder();
        Integer week = (Integer)(freq / freqWeek);
        if (week != 0) {
            freq = freq % freqWeek;
            buf.append(week + "w ");
        }
        Integer day = (Integer)(freq / freqDay);
        if (day != 0) {
            freq = freq % freqDay;
            buf.append(day + "d ");
        }
        Integer hour = (Integer)(freq / freqHour);
        if (hour != 0) {
            freq = freq % freqDay;
            buf.append(hour + "h ");
        }
        Integer min = (Integer)(freq / freqMin);
        if (min!= 0) {
            freq = freq % freqMin;
            buf.append(min + "m ");
        }
        if (freq != 0) {
            buf.append(freq + "s ");
        }
        freqDisplay = buf.toString().trim();
    }

    /**
     * Get kit frequency (in readable format).
     */
    public String getFreqDisplay() {
        return freqDisplay;
    }

    /**
     * Get repeatable flag.
     */
    public Boolean isRepeatable() {
        return repeatable;
    }

    /**
     * Set repeatable flag.
     */
    public void setRepeatable(Boolean flag) {
        repeatable = flag;
    }

    /**
     * Get conditional flag.
     */
    public Boolean isConditional() {
        return conditional;
    }

    /**
     * Set conditional flag.
     */
    public void setConditional(Boolean flag) {
        conditional = flag;
    }

    /**
     * Get the kit's list of items.
     */
    public List<KitItem> getItems() {
        return items;
    }

    /**
     * Set the kit's list of items.
     */
    public void setItems(List<KitItem> itemsList) {
        items = itemsList;
    }
}
