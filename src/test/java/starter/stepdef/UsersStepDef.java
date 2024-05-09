package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.middleman.MiddlemanAPI;
import starter.utils.Constants;

import java.io.File;

public class UsersStepDef {
    @Steps
    MiddlemanAPI middlemanAPI;

    //GET USER
    @Given("Get Single User profile")
    public void getSingleUserProfile() {
        middlemanAPI.getUserProfiles();
    }

    @When("Send request get user profile")
    public void sendRequestGetUserProfile() {
        SerenityRest.when()
                .get(MiddlemanAPI.USERS);
    }

    // putUPDATE USER
    @Given("Put update a user profile with valid json {string}")
    public void putUpdateAUserProfileWithValidJsonAndParameterId(String json) {
        File jsonFile = new File(Constants.REQ_BODY + json);
        middlemanAPI.putUpdateUser(jsonFile);
    }

    @When("Send request to put update cart")
    public void sendRequestToPutUpdateCart() {
        SerenityRest.when()
                .put(MiddlemanAPI.USERS);
    }

    //Delete User
    @Given("delete user profile")
    public void deleteUserProfile() {
        middlemanAPI.deleteUser();
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when()
                .delete(MiddlemanAPI.USERS);
    }
}
