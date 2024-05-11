package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.middleman.MiddlemanAPI;
import starter.utils.Constants;

import java.io.File;

public class OrderStepDef {
    @Steps
    MiddlemanAPI middlemanAPI;

    @Given("Set request body to create order with {string}")
    public void setRequestBodyToCreateOrderWith(String json) {
        File jsonfile = new File(Constants.REQ_BODY + json);
        middlemanAPI.postCreateOrder(jsonfile);
    }

    @When("Send request to create order")
    public void sendRequestToCreateOrder() {
        SerenityRest.when().post(MiddlemanAPI.ORDERS);
    }

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
