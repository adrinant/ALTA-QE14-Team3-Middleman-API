package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.middleman.MiddlemanAPI;

public class UsersStepDef {
    @Steps
    MiddlemanAPI middlemanAPI;

    @Given("Get Single User profile")
    public void getSingleUserProfile() {
        middlemanAPI.getUserProfiles();
    }

    @When("Send request get user profile")
    public void sendRequestGetUserProfile() {
        SerenityRest.when()
                .get(MiddlemanAPI.USERS);
    }
}
