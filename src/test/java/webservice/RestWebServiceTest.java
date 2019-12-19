package webservice;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import webservice.user.User;

public class RestWebServiceTest {
    String baseURI = "https://jsonplaceholder.typicode.com";
    String path = "/users";

    @BeforeTest
    public void setupRest() {
        RestAssured.baseURI = baseURI;
    }

    @Test(description = "Check that the response code is 200")
    public void checkStatusCode() {
        Response response = RestAssured.when()
                .get(path)
                .andReturn();
        int status = response.getStatusCode();
        Assert.assertEquals(status, 200);
    }

    @Test(description = "Check that the response 'Content-type' content application/json ")
    public void checkResponseHeader() {
        Response response = RestAssured.when()
                .get(path)
                .andReturn();
        String responseHeader = response.getContentType();
        Assert.assertEquals(responseHeader, "application/json; charset=utf-8");
    }

    @Test(description = "Check that count users equals 10")
    public void checkCountUsersInResponse() {
        Response response = RestAssured.when()
                .get(path)
                .andReturn();
        User[] users = response.getBody().as(User[].class);
        Assert.assertEquals(users.length, 10);
    }

}
