package org.tulonsae.mc.kit;

import java.util.List;

import org.tulonsae.mc.Constants;
import org.tulonsae.mc.TulSys;

/**
 * Class representing a kit.
 *
 * @author Tulonsae
 */
public class Kit {
    // Kit config strings
    private String cfgSep = Constants.CFG_SEP;
    private String kitCfg = Constants.KIT_CFG_SECT;
    private String kitCfgList = Constants.KIT_CFG_LIST;
    private String kitCfgRept = Constants.KIT_CFG_REPT;
    private String kitCfgCond = Constants.KIT_CFG_COND;
    private String kitCfgDesc = Constants.KIT_CFG_DESC;
    private String kitCfgFreq = Constants.KIT_CFG_FREQ;

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
     * Create a new kit with default values.
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
     * Store kit info into config.
     */
    public void setConfig(TulSys plugin) {
        String cfgName = kitCfg + cfgSep + kitCfgList + cfgSep + getName();
        String cfgRept = cfgName + cfgSep + kitCfgRept;
        String cfgCond = cfgName + cfgSep + kitCfgCond;
        String cfgDesc = cfgName + cfgSep + kitCfgDesc;
        String cfgFreq = cfgName + cfgSep + kitCfgFreq;

        plugin.getConfig().set(cfgDesc, getDescription());
        plugin.getConfig().set(cfgFreq, getFrequency());
        plugin.getConfig().set(cfgRept, isRepeatable());
        plugin.getConfig().set(cfgCond, isConditional());
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
