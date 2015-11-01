package de.et.restdemo.rest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserResourceTestSteps {

    @Given("^the user '(.*)'$")
    public void the_user_John(String name) throws Throwable {
        System.out.println("Name: " + name);
    }

    @When("^he is saved$")
    public void he_is_saved() throws Throwable {
        System.out.println("user saved");
    }

    @Then("^his name should be retrievable from the system$")
    public void his_name_should_be_retrievable_from_the_system() throws Throwable {
        System.out.println("user retrieved");
    }
}
