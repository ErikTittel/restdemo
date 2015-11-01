package de.et.restdemo.rest;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserResourceTestSteps {

    private String id;
    private String name;

    @Given("^the user '(.*)'$")
    public void the_user_John(String name) throws Throwable {
        this.name = name;
    }

    @When("^he is saved$")
    public void he_is_saved() throws Throwable {
        id = given()
                .contentType("application/json")
                .body("{\"name\":\"" + name + "\"}")
        .when()
                .post("/restdemo/rest/user")
        .then()
                .statusCode(201)
        .and()
                .body("message", is(notNullValue()))
        .and()
                .extract().body().jsonPath().get("message").toString();
    }

    @Then("^his name should be retrievable from the system$")
    public void his_name_should_be_retrievable_from_the_system() throws Throwable {
        when()
                .get("restdemo/rest/user/{id}", id)
        .then()
                .statusCode(200)
        .and()
                .body("name", is(name));
    }
}
