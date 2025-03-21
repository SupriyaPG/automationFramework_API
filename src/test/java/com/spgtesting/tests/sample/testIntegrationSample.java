package com.spgtesting.tests.sample;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testIntegrationSample {

    // Create a Booking
    // Verify the Booking
    // Update the Booking
    // Delete the Booking


    @Test(groups="qa",priority=1)//
    @Owner("Supriya")
    @Description("TC#INT1 - Step 1. Verify the Booking is created")
    public  void testCreateBooking(){
        Assert.assertTrue(true);
    }

    @Test(groups="qa",priority=2)//
    @Owner("Supriya")
    @Description("TC#INT2 - Step 2. Verify the Booking by Id")
    public  void testVerifyBookingBId(){
        Assert.assertTrue(true);
    }

    @Test(groups="qa",priority=3)//
    @Owner("Supriya")
    @Description("TC#INT3 - Step 3. Verify the Booking updation")
    public  void testUpdateBookingById(){
        Assert.assertTrue(true);
    }

    @Test(groups="qa",priority=4)//
    @Owner("Supriya")
    @Description("TC#INT4 - Step 4. Verify the Booking deleted")
    public  void testDeleteBookingById(){
        Assert.assertTrue(true);
    }
}
