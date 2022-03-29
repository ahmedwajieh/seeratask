package models;

import java.util.ArrayList;

public class SearchHotel {

    private String checkIn;
    private String checkOut;
    private ArrayList<RoomsInfo> roomsInfo;
    private String placeId;


    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public ArrayList<RoomsInfo> getRoomsInfo() {
        return roomsInfo;
    }

    public void setRoomsInfo(ArrayList<RoomsInfo> roomsInfo) {
        this.roomsInfo = roomsInfo;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }
}
