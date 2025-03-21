package com.spgtesting.asserts;

import io.restassured.response.Response;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import  static org.testng.Assert.assertEquals;

public class AssertActions {

    public void verifyResponseBody(String actual,String expected,String description){
        assertEquals(actual,expected,description);
    }

    public void verifyResponseBody(int actual,int expected,int description){
        assertEquals(actual,expected,description);
    }

    public void verifyStatusCode(Response response,Integer expected){

        assertEquals(response.getStatusCode(),expected);

    }

    public  void verifyStringKey(String keyExpect,String keyActual){

        // AssertJ
        assertThat(keyExpect).isNotNull();
        assertThat(keyExpect).isNotNull().isNotBlank();
        assertThat(keyExpect).isEqualTo(keyActual);

    }
    public void verifyStringKeyNotNull(String keyExpect){
        // AssertJ
        assertThat(keyExpect).isNotNull();
    }

    public void verifyStringKeyNotNull(Integer keyExpect){
        // AssertJ
        assertThat(keyExpect).isNotNull();
    }

}
