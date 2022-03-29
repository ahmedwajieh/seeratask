package models;

import java.util.ArrayList;

public class RoomsInfo {


    private int adultsCount;
    private ArrayList<Integer> kidsAges;

    public int getAdultsCount() {
        return adultsCount;
    }

    public void setAdultsCount(int adultsCount) {
        this.adultsCount = adultsCount;
    }

    public ArrayList<Integer> getKidsAges() {
        return kidsAges;
    }

    public void setKidsAges(ArrayList<Integer> kidsAges) {
        this.kidsAges = kidsAges;
    }


}
