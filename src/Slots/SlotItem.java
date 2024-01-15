package Slots;

public class SlotItem {
    String slotName;
    String[] slotStringArray;

    public SlotItem( String slotName, String[] slotStringArray) {
        this.slotStringArray = slotStringArray;
        this.slotName = slotName;
    }

    public String getName() {
        return slotName;
    }

    public String[] getArray() {
        return slotStringArray;
    }
}
