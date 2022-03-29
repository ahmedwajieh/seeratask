package utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

public class Helper {

    public static ArrayList<LocalDate> generateCheckInAndCheckOutDate() {

        ArrayList<LocalDate> reservationDate = new ArrayList<>();
        Random randomDays = new Random();
        LocalDate checkInDate = LocalDate.now().plusDays(randomDays.nextInt(15) + 1);

        reservationDate.add(checkInDate);

        LocalDate checkOutDate = checkInDate.plusDays(randomDays.nextInt(15) + 1);

        reservationDate.add(checkOutDate);

        return reservationDate;
    }


    public static JsonPath getJsonPath(String response){

        return new JsonPath(response);
    }

    public static boolean verifyPropertyInResponse(String property, Response response){
        if (!(response.getBody().jsonPath().get(property) == null))
            return true;

        else return false;
    }

    public static String setUpEnvironment(String apiVersion) throws IOException {


        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("src/test/java/resources/environment.properties");
        prop.load(file);

        if(apiVersion.equals("v3"))
            return prop.getProperty("baseUrlV3");
        else
            return prop.getProperty("baseUrl");

    }

}
