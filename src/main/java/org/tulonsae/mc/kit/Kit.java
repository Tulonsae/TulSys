package org.tulonsae.mc.kit;

import java.util.List;

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
