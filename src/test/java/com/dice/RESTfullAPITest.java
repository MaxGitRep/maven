package com.dice;

import org.testng.annotations.Test;


import static io.restassured.RestAssured.when;
import static org.hamcrest.core.IsEqual.equalTo;

//Used rest-assured.io
public class RESTfullAPITest {

    @Test
    public void shouldGetLuke() {
        when().
                get("http://swapi.co/api/people/1/").
        then().
                statusCode(200).log().all().
                assertThat().body("name", equalTo("Luke Skywalker"));
    }

}
