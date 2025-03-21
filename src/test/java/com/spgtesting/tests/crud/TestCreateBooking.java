package com.spgtesting.tests.crud;

import com.spgtesting.base.BaseTest;
import com.spgtesting.endpoints.APIConstant;
import com.spgtesting.pojos.BookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestCreateBooking  extends BaseTest {

    @Test(groups = "reg",priority = 1)
    @TmsLink("https://bugz.atanssian.net/browse/BUG-1")
    @Owner("Supriya")
    @Description("TC#INT1 - Step 1.Verify create booking.")
    public void TestCreateBooking(){


        requestSpecification.basePath(APIConstant.Create_UPDATE_BOOKING_URL);

        response= RestAssured.given(requestSpecification)
                .when().body(payloadManager.createPayloadBookingAsString())
                .post();

        validatableResponse=response.then().log().all();
        validatableResponse.statusCode(200);
        BookingResponse bookingResponse= payloadManager.bookingResponseJava(response.asString());
        assertActions.verifyStringKey(bookingResponse.getBooking().getFirstname(),"John");
    }


}
