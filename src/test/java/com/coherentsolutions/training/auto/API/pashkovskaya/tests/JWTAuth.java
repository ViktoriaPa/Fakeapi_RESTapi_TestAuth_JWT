package com.coherentsolutions.training.auto.API.pashkovskaya.tests;

import com.coherentsolutions.training.auto.API.pashkovskaya.base.BaseTest;
import com.coherentsolutions.training.auto.API.pashkovskaya.model.TokenRes;
import com.coherentsolutions.training.auto.API.pashkovskaya.specs.Specs;
import com.coherentsolutions.training.auto.API.pashkovskaya.util.PropertiesFileReader;
import com.coherentsolutions.training.auto.API.pashkovskaya.util.TestAllureListener;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
@Listeners({ TestAllureListener.class })
public class JWTAuth extends BaseTest {
    @Test
    public void testGettingProfileAuthUserIsSuccessful(){
        Specs.instalSpec(Specs.requestSpec(PropertiesFileReader.getBaseURI()), Specs.responseSpecOK200());
        given()
                .filter(new AllureRestAssured())
                .header("Authorization", "Bearer " + TokenRes.getInstance().getToken())
                .contentType(ContentType.JSON)
                .when()
                .get("auth/profile")
                .then()
                .assertThat().body("email", equalTo(PropertiesFileReader.getEmail()));
    }
}
