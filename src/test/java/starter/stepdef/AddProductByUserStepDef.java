package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.middleman.MiddlemanAPI;
import starter.utils.Constants;

import java.io.File;

public class AddProductByUserStepDef {
    @Steps
    MiddlemanAPI middlemanAPI;


    @Given("Post add product by user with valid data product_name {string}, unit {string}, stock {string}, price {string}, product_image {string}")
    public void postAddProductByUserWithValidDataProduct_nameUnitStockPriceProduct_image(String product_name, String unit, String stock, String price, String product_image) {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/form/" + product_image;
        File image = new File(filePath);
        middlemanAPI.postAddProductByUser(product_name, unit, stock, price, image);
    }

    @Given("Post add product by user with invalid data product_name {string}, unit {string}, stock {string}, price {string}, product_image {string}")
    public void postAddProductByUserWithInvalidDataProduct_nameUnitStockPriceProduct_image(String product_name, String unit, String stock, String price, String product_image) {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/form/" + product_image;
        File image = new File(filePath);
        middlemanAPI.postAddProductByUser(product_name, unit, stock, price, image);
    }
    @When("Send request to add product")
    public void sendRequestToAddProduct() {
        SerenityRest.when().post(MiddlemanAPI.USERS_PRODUCTS);
    }
}
