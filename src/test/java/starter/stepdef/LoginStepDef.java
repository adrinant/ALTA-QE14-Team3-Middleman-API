package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.middleman.MiddlemanAPI;
import starter.utils.Constants;

import java.io.File;

public class LoginStepDef {
    @Steps
    MiddlemanAPI middlemanAPI;
    @Given("Set request body with valid email and password entered with json {string}")
    public void setRequestBodyWithValidEmailAndPasswordEnteredWithJson(String json) {
        File jsonfile = new File(Constants.REQ_BODY+json);
        middlemanAPI.postUserLogin(jsonfile);
    }

    @When("Send request to login")
    public void sendRequestToLogin() {
        SerenityRest.when().post(MiddlemanAPI.LOGIN);
    }

    @Given("Set request body with invalid email and password entered with json {string}")
    public void setRequestBodyWithInvalidEmailAndPasswordEnteredWithJson(String json) {
        File jsonfile = new File(Constants.REQ_BODY+json);
        middlemanAPI.postUserLogin(jsonfile);
    }
}
