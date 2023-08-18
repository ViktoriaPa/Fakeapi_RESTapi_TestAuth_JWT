package com.coherentsolutions.training.auto.API.pashkovskaya.base;

import com.coherentsolutions.training.auto.API.pashkovskaya.specs.Specs;
import com.coherentsolutions.training.auto.API.pashkovskaya.model.TokenRes;
import com.coherentsolutions.training.auto.API.pashkovskaya.model.User;
import com.coherentsolutions.training.auto.API.pashkovskaya.util.PropertiesFileReader;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeMethod;

import static io.restassured.RestAssured.given;

public class BaseTest {
    @BeforeMethod
    public void setUp() {
        Specs.instalSpec(Specs.requestSpec(PropertiesFileReader.getBaseURI()), Specs.responseSpecOK201());

        User user = new User(PropertiesFileReader.getEmail(), PropertiesFileReader.getPassword());

        String token = given()
                .contentType(ContentType.JSON)
                .when()
                .body(user)
                .post("auth/login")
                .then()
                .extract().body().jsonPath().getString("access_token");

        TokenRes.getInstance().setToken(token);
    }
}
