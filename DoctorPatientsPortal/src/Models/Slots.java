package Models;

import commons.Constants;

public class Slots {
    int sMin;
    int sHours;

    int slotIndex;

    public int getSlotIndex() {
        return slotIndex;
    }

    public void setSlotIndex(int slotIndex) {
        this.slotIndex = slotIndex;
    }

    public int getsMin() {
        return sMin;
    }

    public void setsMin(int sMin) {
        this.sMin = sMin;
    }

    String pName;
    String docName;

    public Slots(int sHours, int sMin, String pName, String docName) {
        this.sHours = sHours;
        this.sMin = sMin;
        this.pName = pName;
        this.docName = docName;
        this.isEmpty = true;
        this.slotIndex = Constants.slotIndex;
        Constants.slotIndex = Constants.slotIndex+1;
    }

    public int getsHours() {
        return sHours;
    }

    public void setsHours(int sHours) {
        this.sHours = sHours;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public Boolean getEmpty() {
        return isEmpty;
    }

    public void setEmpty(Boolean empty) {
        isEmpty = empty;
    }

    Boolean isEmpty;
}
