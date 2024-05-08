package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.middleman.MiddlemanAPI;

public class UpdateOrderStepDef {
    @Steps
    MiddlemanAPI middlemanAPI;
    @Given("Set path to confirm order with {int}")
    public void setPathToConfirmOrderWith(int ValidId) {
        middlemanAPI.putConfirmOrderValidId(ValidId);
    }

    @When("Send request to confirm order")
    public void sendRequestToConfirmOrder() {
        SerenityRest.when().put(MiddlemanAPI.ORDERS_CONFIRM);
    }

    @Given("Set path to confirm order invalid id with {string}")
    public void setPathToConfirmOrderInvalidIdWith(String InvalidId) {
        middlemanAPI.putConfirmOrderInvalidId(InvalidId);
    }

    @Given("Set path to finish order with {}")
    public void setPathToFinishOrderWith(int ValidId) {
        middlemanAPI.putFinishOrderValidId(ValidId);
    }

    @When("Send request to finish order")
    public void sendRequestToFinishOrder() {
        SerenityRest.when().put(MiddlemanAPI.ORDERS_DONE);
    }

    @Given("Set path to finish order invalid id with {string}")
    public void setPathToFinishOrderInvalidIdWith(String InvalidId) {
        middlemanAPI.putFinishOrderInvalidId(InvalidId);
    }
}
