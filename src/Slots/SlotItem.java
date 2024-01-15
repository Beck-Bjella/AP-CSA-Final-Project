package Slots;

// SlotItem class 
// This class is used to store slot item data
public class SlotItem {
    String slotName;
    String[] slotStringArray;

    // Constructor
    public SlotItem( String slotName, String[] slotStringArray) {
        this.slotStringArray = slotStringArray;
        this.slotName = slotName;
    }

    // Getters
    public String getName() {
        return slotName;
    }

    public String[] getArray() {
        return slotStringArray;
    }

}
