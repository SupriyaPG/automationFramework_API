package com.spgtesting.Modules;

import com.google.gson.Gson;
import com.spgtesting.pojos.Booking;
import com.spgtesting.pojos.BookingDates;
import com.spgtesting.pojos.BookingResponse;

public class PayloadManager {

    //Convert Java objects to JSON
    // GSON - ser and deSer.

    Gson gson;
    public String createPayloadBookingAsString(){
        Booking booking=new Booking();
        booking.setFirstname("John");
        booking.setLastname("Peter");
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



}
