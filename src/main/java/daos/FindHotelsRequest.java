package daos;

import models.RoomsInfo;
import models.SearchHotel;

import java.util.ArrayList;

public class FindHotelsRequest {

    public SearchHotel buildSearchHotelsRequest(String checkin, String checkout, String adults, String ageOfchilds, String placeId){

        SearchHotel objSearchHotel = new SearchHotel();
        objSearchHotel.setCheckIn(checkin);
        objSearchHotel.setCheckOut(checkout);
        objSearchHotel.setPlaceId(placeId);


        ArrayList<RoomsInfo> roomsInformation = new ArrayList<RoomsInfo>();
        RoomsInfo objRooms = new RoomsInfo();
        objRooms.setAdultsCount(Integer.parseInt(adults));

        ArrayList<Integer> childsAges = toArraylist(ageOfchilds);
        if (childsAges.size() == 0){

            roomsInformation.add(objRooms);
            objSearchHotel.setRoomsInfo(roomsInformation);

            return objSearchHotel;

        }

        else
        objRooms.setKidsAges(childsAges);
        roomsInformation.add(objRooms);
        objSearchHotel.setRoomsInfo(roomsInformation);
        return objSearchHotel;
    }

    public ArrayList<Integer> toArraylist(String ages){

        ages.trim();
        String[] agesInString = ages.split("\\s*,\\s*");
        ArrayList<Integer> childAges = new ArrayList<Integer>();
        for(String age : agesInString){
            childAges.add(Integer.valueOf(age));
        }
        return childAges;


    }

}
