package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.middleman.MiddlemanAPI;

public class GetOrderStepDef {
    @Steps
    MiddlemanAPI middlemanAPI;

    @Given("Set path for order by user")
    public void setPathForOrderByUser() {
        middlemanAPI.getHistoryOrderByUser();
    }

    @When("Send request to get order")
    public void sendRequestToGetOrder() {
        SerenityRest.when().get(MiddlemanAPI.ORDERS);
    }

    @Given("Set path for detail order with {int}")
    public void setPathForDetailOrderWith(int ValidId) {
        middlemanAPI.getDetailOrderValidId(ValidId);
    }

    @When("Send request to get detail order")
    public void sendRequestToGetDetailOrder() {
        SerenityRest.when().get(MiddlemanAPI.ORDERS_ID);
    }

    @Given("Set path for detail order invalid id with {string}")
    public void setPathForDetailOrderInvalidIdWith(String InvalidId) {
        middlemanAPI.getDetailOrderInvalidId(InvalidId);
    }

    @Given("Set path for all history order by admin")
    public void setPathForAllHistoryOrderByAdmin() {
        middlemanAPI.getHistoryOrderByAdmin();
    }

    @When("Send request to get all history order")
    public void sendRequestToGetAllHistoryOrder() {
        SerenityRest.when().get(MiddlemanAPI.ORDERS_ADMINS);
    }

    @Given("Set path for incoming order")
    public void setPathForIncomingOrder() {
        middlemanAPI.getIncomingOrderByAdmin();
    }

    @When("Send request to get incoming order")
    public void sendRequestToGetIncomingOrder() {
        SerenityRest.when().get(MiddlemanAPI.ORDERS_ADMINS_INCOMING);
    }
}
