package com.spgtesting.base;

import com.spgtesting.Modules.PayloadManager;
import com.spgtesting.asserts.AssertActions;
import com.spgtesting.endpoints.APIConstant;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;


public class BaseTest {

    // Common To All Test Cases
    // Base URL,Content Type,JSON

    public RequestSpecification requestSpecification;
    public AssertActions assertActions;
    //Base URL ,Content Type-JSON
    public PayloadManager  payloadManager= new PayloadManager();
    public JsonPath jsonPath;
    public Response response;
    public ValidatableResponse validatableResponse;

    @BeforeTest
    public void setUp(){
        assertActions=new AssertActions();

//        requestSpecification=RestAssured.given();
//        requestSpecification.baseUri(APIConstant.BASE_URL);
//        requestSpecification.contentType(ContentType.JSON).log().all();

//        requstSpecification= RestAssured
//                .given().baseUri(APIConstant.BASE_URL)
//                .contentType(ContentType.JSON).log().all();

                        //OR we can uese

        //RequestSpecification requestSpecification = new RequestSpecification();
        requestSpecification=new RequestSpecBuilder()
                .setBaseUri(APIConstant.BASE_URL)
                .addHeader("Content-Type","application/json")
                .build().log().all();

    }

}
