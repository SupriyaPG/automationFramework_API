package com.spgtesting.base;

import com.spgtesting.Modules.PayloadManager;
import com.spgtesting.asserts.AssertActions;
import com.spgtesting.endpoints.APIConstant;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.json.config.JsonPathConfig;
import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.config.XmlPathConfig;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.checkerframework.checker.units.qual.C;
import org.testng.annotations.BeforeTest;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static io.restassured.http.ContentType.*;


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

    public  String getToken(){
        requestSpecification=RestAssured
                .given()
                .baseUri(APIConstant.BASE_URL)
                .basePath(APIConstant.AUTH_URL);

        //Setting the payload
        String  payload=payloadManager.setAuthPayload();
        //Get the Token
        response=requestSpecification.contentType(JSON).body(payload).when().post();
        //String Extraction
        String token=payloadManager.getTokenFromJSON(response.asString());
        return token;

    }

}
