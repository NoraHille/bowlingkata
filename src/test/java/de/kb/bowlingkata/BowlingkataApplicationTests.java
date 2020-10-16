package de.kb.bowlingkata;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BowlingkataApplicationTests {

    @LocalServerPort
    int server_port;

    @BeforeEach
    void setUp() {
        port = server_port;
    }

    @Test
    void bowlingRequestReturnsRightScore() {

        BowlingData bowlingData = new BowlingData("5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5");

        given().contentType(ContentType.JSON)
                .body(bowlingData)
                .log().all()
                .when()
                .post("/bowling")
                .then().log().body()
                .body("score", equalTo(150));

    }


}
