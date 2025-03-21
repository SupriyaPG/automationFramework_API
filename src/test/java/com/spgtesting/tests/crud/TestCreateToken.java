package com.spgtesting.tests.crud;

import com.spgtesting.base.BaseTest;
import com.spgtesting.endpoints.APIConstant;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestCreateToken extends BaseTest {

    @Test(groups = "reg",priority = 1)
    @TmsLink("https://bugz.atanssian.net/browse/BUG-1")
    @Owner("Supriya")
    @Description("TC#2 Create Token and Verify.")
    public void TestToken(){


        requestSpecification.basePath(APIConstant.AUTH_URL);

        response= RestAssured.given(requestSpecification)
                .when().body(payloadManager.setAuthPayload())
                .post();

        validatableResponse=response.then().log().all();
        validatableResponse.statusCode(200);
        String token=payloadManager.getTokenFromJSON(response.asString());
        assertActions.verifyStringKeyNotNull(token);

    }
}
