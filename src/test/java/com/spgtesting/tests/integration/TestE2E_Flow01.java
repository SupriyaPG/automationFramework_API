package com.spgtesting.tests.integration;

import com.spgtesting.base.BaseTest;
import com.spgtesting.endpoints.APIConstant;
import com.spgtesting.pojos.Booking;
import com.spgtesting.pojos.BookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.ITestContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestE2E_Flow01 extends BaseTest {
        // Test E2E Scenario  1
        //Create a booking -> bookingId
        // Create token -> token
        // Verify that the Create booking is working - GET request to BookingId
        // Update the booking (bookingId,token) Need to take token ,bookingId
        // Delete the booking - Need to get the token, bookingId from above requests


    @Test(groups="qa",priority=1)//
    @Owner("Supriya")
    @Description("TC#INT1 - Step 1. Verify the Booking is created")
    public  void testCreateBooking(ITestContext iTestContext){

        System.out.println("Verify the Booking is created");
        requestSpecification.basePath(APIConstant.Create_UPDATE_BOOKING_URL);

        response= RestAssured.given(requestSpecification)
                .when().body(payloadManager.createPayloadBookingAsString())
                .post();
        System.out.println("Post created");
        validatableResponse=response.then().log().all();
        validatableResponse.statusCode(200);
        BookingResponse bookingResponse= payloadManager.bookingResponseJava(response.asString());
        assertActions.verifyStringKey(bookingResponse.getBooking().getFirstname(),"John");
        System.out.println("bookingd="+bookingResponse.getBooking());
        iTestContext.setAttribute("bookingid",bookingResponse.getBooking() );  //Global value we can access in all testcases

    }

    //@Test(groups="qa",priority=2)//
    @Owner("Supriya")
    @Description("TC#INT2 - Step 2. Verify the Booking by Id")
     public  void testVerifyBookingBId(ITestContext iTestContext){

        System.out.println("Verify the Booking by Id");
        Integer bookingid=(Integer)iTestContext.getAttribute("bookingid");

        String basePathGET=APIConstant.Create_UPDATE_BOOKING_URL+"/"+bookingid;
        System.out.println(basePathGET);

            requestSpecification.basePath(basePathGET);
            response= RestAssured.given(requestSpecification)
                    .when()
                    .get();
            validatableResponse=response.then().log().all();
            validatableResponse.statusCode(200);
        Booking booking= payloadManager.getResponseFromJSON(response.asString());
        assertThat(booking.getFirstname()).isNotNull().isNotBlank();
        assertThat(booking.getFirstname()).isEqualTo("John");

    }

   // @Test(groups="qa",priority=3)//
    @Owner("Supriya")
    @Description("TC#INT3 - Step 3. Verify the Booking updation")
    public  void testUpdateBookingById(ITestContext iTestContext){

        System.out.println("Verify the Booking updation");
        Integer bookingid=(Integer)iTestContext.getAttribute("bookingid");
        String token=getToken();
        iTestContext.setAttribute("token",token);

        String basePathPutPatch=APIConstant.Create_UPDATE_BOOKING_URL+"/"+bookingid;
        System.out.println(basePathPutPatch);

        requestSpecification.basePath(basePathPutPatch);
        response= RestAssured.given(requestSpecification).cookie("token",token)
                .when().body(payloadManager.fullUpdatePayloadAsString())
                .put();
        validatableResponse=response.then().log().all();
        validatableResponse.statusCode(200);
        Booking booking= payloadManager.getResponseFromJSON(response.asString());
        assertThat(booking.getFirstname()).isEqualTo("Kuku");
        assertThat(booking.getLastname()).isEqualTo("Micky");

    }

    //@Test(groups="qa",priority=4)//
    @Owner("Supriya")
    @Description("TC#INT4 - Step 4. Verify the Booking deleted")
    public  void testDeleteBookingById(ITestContext iTestContext){

        System.out.println("Verify the Booking deleted");
        Integer bookingid=(Integer)iTestContext.getAttribute("bookingid");
        String token=getToken();
        iTestContext.setAttribute("token",token);

        String basePathDelete=APIConstant.Create_UPDATE_BOOKING_URL+"/"+bookingid;
        System.out.println(basePathDelete);

        requestSpecification.basePath(basePathDelete).cookie("token",token);
        validatableResponse= RestAssured.given().spec(requestSpecification)
                .when()
                .delete()
                .then().log().all();
        validatableResponse.statusCode(201);

    }
}
