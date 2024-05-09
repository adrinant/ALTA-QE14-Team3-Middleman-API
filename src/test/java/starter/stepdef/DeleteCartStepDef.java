package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.middleman.MiddlemanAPI;

public class DeleteCartStepDef {
    @Steps
    MiddlemanAPI middlemanAPI;

    @Given("Set carts id with {int}")
    public void setCartsIdWith(int id) {
        middlemanAPI.deleteCartValidId(id);
    }

    @When("Send request to delete cart")
    public void sendRequestToDeleteCart() {
        SerenityRest.when().delete(MiddlemanAPI.CARTS_ID);
    }

    @Given("Set carts invalid id with {string}")
    public void setCartsInvalidIdWith(String id) {
        middlemanAPI.deleteCartInvalidId(id);
    }


}
