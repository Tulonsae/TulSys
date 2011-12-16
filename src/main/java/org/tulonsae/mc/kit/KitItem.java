package org.tulonsae.mc.kit;

/**
 * Class representing a kit item.
 *
 * @author Tulonsae
 */
public class KitItem {

    // Kit Item data structure.
    private String name;
    private Integer id;
    private String type;	// damage modifier
    private Integer typeId;
    private Integer quantity;
    // add aliases ?

    /**
     * Make sure a new kit item is intialized.
     */
    public KitItem() {
        init();
    }

    /**
     * Initialize default class data for this instance.
     */ 
    private void init() {
        name = null;
        id = -1;
        type = null;
        typeId = -1;
        quantity = 0;
    }

    /**
     * Get kit item name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set kit item name.
     */
    public void setName(String string) {
        name = string;
    }

    /**
     * Get kit item id.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set kit item id.
     */
    public void setId(Integer itemId) {
        id = itemId;
    }

    /**
     * Get kit item name (color, style, etc).
     */
    public String getType() {
        return type;
    }

    /**
     * Set kit item type (color, style, etc).
     */
    public void setType(String itemType) {
        type = itemType;
    }

    /**
     * Get kit item type (color, style, etc).
     */
    public Integer getTypeId() {
        return typeId;
    }

    /**
     * Set kit item type (color, style, etc).
     */
    public void setTypeId(Integer itemTypeId) {
        typeId = itemTypeId;
    }

    /**
     * Get kit item quantity.
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Set kit item quantity.
     */
    public void setQuantity(Integer amount) {
        quantity = amount;
    }
}
