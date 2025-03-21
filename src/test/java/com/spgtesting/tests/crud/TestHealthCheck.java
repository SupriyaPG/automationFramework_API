package com.spgtesting.tests.crud;

import com.spgtesting.base.BaseTest;
import com.spgtesting.endpoints.APIConstant;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

//import com.spgtesting.base.BaseTest;
//import com.spgtesting.endpoints.APIConstant;
//import io.qameta.allure.Description;
//import io.qameta.allure.Owner;
//import io.qameta.allure.TmsLink;
//import io.restassured.RestAssured;
//import org.testng.annotations.Test;

public class TestHealthCheck extends BaseTest {

    @Test(groups = "reg",priority = 1)
    @Owner("Supriya")
    @Description("TC#3 - verify Health")
     public void testHealth(){
    requestSpecification.basePath(APIConstant.PING_URL);
    response= RestAssured.given(requestSpecification)
            .when()
            .get();
        validatableResponse=response.then().log().all();
        validatableResponse.statusCode(201);


    }
}
