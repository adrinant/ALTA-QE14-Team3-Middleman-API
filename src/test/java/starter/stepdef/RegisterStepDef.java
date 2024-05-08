package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.middleman.MiddlemanAPI;
import starter.utils.Constants;

import java.io.File;

public class RegisterStepDef {
    @Steps
    MiddlemanAPI middlemanAPI;
    @Given("Set request body with valid data enetered with json {string}")
    public void setRequestBodyWithValidDataEneteredWithJson(String json) {
        File jsonfile = new File(Constants.REQ_BODY+json);
        middlemanAPI.postRegister(jsonfile);
    }

    @When("Send request to register")
    public void sendRequestToRegister() {
        SerenityRest.when().post(MiddlemanAPI.REGISTER);

    }

    @Given("Set request body with invalid data enetered with json {string}")
    public void setRequestBodyWithInvalidDataEneteredWithJson(String json) {
        File jsonfile = new File(Constants.REQ_BODY+json);
        middlemanAPI.postRegister(jsonfile);
    }
}
