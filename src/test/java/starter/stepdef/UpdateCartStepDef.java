package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.middleman.MiddlemanAPI;
import starter.utils.Constants;

import java.io.File;

public class UpdateCartStepDef {
    @Steps
    MiddlemanAPI middlemanAPI;

    @Given("Set parameter to update cart valid id {} and request data qty {string}")
    public void setParameterToUpdateCartValidIdAndRequestDataQty(int id, String qty) {
        middlemanAPI.putUpdateCartValidId(id, qty);
    }

    @Given("Set parameter to update cart invalid id {string} and request data qty {string}")
    public void setParameterToUpdateCartInvalidIdAndRequestDataQty(String id, String qty) {
        middlemanAPI.putUpdateCartInvalidId(id, qty);
    }

    @Given("Set parameter to update cart valid id {} and request invalid data qty {string}")
    public void setParameterToUpdateCartValidIdAndRequestInvalidDataQty(int id, String qty) {
        middlemanAPI.putUpdateCartValidId(id, qty);
    }

    @When("Send request to update cart")
    public void sendRequestToUpdateCart() {
        SerenityRest.when().put(MiddlemanAPI.CARTS_ID);
    }
}
