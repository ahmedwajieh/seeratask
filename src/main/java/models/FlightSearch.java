package models;

import constants.ClassType;

import java.lang.reflect.Field;

public class FlightSearch {
    private String origin;
    private String destination;
    private String departDate;
    private String returnDate;
    private String classType;
    private int passengers;

    public FlightSearch(String origin, String destination, String departDate, String returnDate, String classType, String adults) {

        this.origin = origin;
        this.destination = destination;
        this.departDate = departDate;
        this.returnDate = returnDate;
        this.classType = classType;
        this.passengers = Integer.parseInt(adults);

    }


    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartDate() {
        return departDate;
    }

    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public String buildQuery(){

        //check if flight is one-way or round-trip
        if (returnDate.isEmpty())
            return origin+"-"+destination+"/"+departDate+"/"+classType+"/"+passengers+"Adult";

        else
            return origin+"-"+destination+"/"+departDate+"/"+returnDate+"/"+classType+"/"+passengers+"Adult";



    }
}
