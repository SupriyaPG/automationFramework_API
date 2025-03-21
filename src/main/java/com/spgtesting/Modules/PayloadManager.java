package com.spgtesting.Modules;

import com.google.gson.Gson;
import com.spgtesting.pojos.*;

public class PayloadManager {

    //Convert Java objects to JSON
    // GSON - ser and deSer.

    Gson gson;
    public String createPayloadBookingAsString(){
        Booking booking=new Booking();
        booking.setFirstname("sunny");
        booking.setLastname("Hog");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);

        BookingDates bookingDates=new BookingDates();
        bookingDates.setCheckin("2004-02-01");
        bookingDates.setCheckout("2004-02-01");
        gson=new Gson();

        System.out.println(booking);

        //java Object -> Json
        String jsonStringBooking=gson.toJson(booking);
        System.out.println(jsonStringBooking);
        return jsonStringBooking;
    }

    public  BookingResponse bookingResponseJava(String responseString){

        BookingResponse bookingResponse=gson.fromJson(responseString,BookingResponse.class );
        return  bookingResponse;

    }

    public  String setAuthPayload(){
        Auth auth=new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");
        gson=new Gson();
        String jsonPayloadString=gson.toJson(auth);

        System.out.println("Payload set to the -> "+jsonPayloadString);
        return jsonPayloadString;
    }

    public String getTokenFromJSON(String tokenResponse){
        gson=new Gson();
       TokenResponse tokenResponse1=gson.fromJson(tokenResponse,TokenResponse.class);
        return tokenResponse1.toString();
    }

    public Booking  getResponseFromJSON(String getResponse){
        gson=new Gson();
        Booking booking=gson.fromJson(getResponse ,Booking.class);
        return booking;
    }

    public String fullUpdatePayloadAsString(){
        Booking booking=new Booking();
        booking.setFirstname("Kuku");
        booking.setLastname("Micky");
        booking.setTotalprice(546);
        booking.setDepositpaid(true);
        BookingDates bookingDates=new BookingDates();
        bookingDates.setCheckin("2025-03-02");
        bookingDates.setCheckout("2025-03-04");
        return gson.toJson(booking);


    }



}
