package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.middleman.MiddlemanAPI;
import starter.utils.Constants;

import java.io.File;

public class UpdateUserProductStepDef {
    @Steps
    MiddlemanAPI middlemanAPI;

    @Given("Set parameter to valid id {} and valid data product_name {string}, unit {string}, stock {string}, price {string}")
    public void setParameterToValidIdAndValidDataProduct_nameUnitStockPrice(int id, String product_name, String unit, String stock, String price) {
        middlemanAPI.putUpdateUserProductValidId(id, product_name, unit, stock, price);
    }

    @Given("Set parameter to invalid id {string} and valid data product_name {string}, unit {string}, stock {string}, price {string}")
    public void setParameterToInvalidIdAndValidDataProduct_nameUnitStockPrice(String id, String product_name, String unit, String stock, String price) {
        middlemanAPI.putUpdateUserProductInvalidId(id, product_name, unit, stock, price);
    }

    @Given("Set parameter to valid id {} and invalid data product_name {string}, unit {string}, stock {string}, price {string}")
    public void setParameterToValidIdAndInvalidDataProduct_nameUnitStockPrice(int id, String product_name, String unit, String stock, String price) {
        middlemanAPI.putUpdateUserProductValidId(id, product_name, unit, stock, price);
    }

    @When("Send request to update user product")
    public void sendRequestToUpdateUserProduct() {
        SerenityRest.when().put(MiddlemanAPI.USERS_PRODUCTS_ID);
    }


}
