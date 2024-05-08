package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.middleman.MiddlemanAPI;

public class GetCartsStepDef {
    @Steps
    MiddlemanAPI middlemanAPI;
    @Given("Set path for carts")
    public void setPathForCarts() {
        middlemanAPI.getCarts();
    }

    @When("Send request to get carts")
    public void sendRequestToGetCarts() {
        SerenityRest.when().get(MiddlemanAPI.CARTS);
    }
}
