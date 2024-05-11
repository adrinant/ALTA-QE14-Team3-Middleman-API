package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.middleman.MiddlemanAPI;

import java.io.File;

public class UserProductStepDef {
    @Steps
    MiddlemanAPI middlemanAPI;
    @Given("Set path and token")
    public void setPathAndToken() {
        middlemanAPI.getUserProducts();
    }

    @When("Send request to get user products")
    public void sendRequestToGetUserProducts() {
        SerenityRest.when().get(MiddlemanAPI.USERS_PRODUCTS);
    }

    @Given("Post add product by user with valid data product_name {string}, unit {string}, stock {string}, price {string}, product_image {string}")
    public void postAddProductByUserWithValidDataProduct_nameUnitStockPriceProduct_image(String product_name, String unit, String stock, String price, String product_image) {
        String filePath = System.getProperty("user.dir") + "/src/main/resources/" + product_image;
        File image = new File(filePath);
        middlemanAPI.postAddProductByUser(product_name, unit, stock, price, image);
    }

    @When("Send request to add product")
    public void sendRequestToAddProduct() {
        SerenityRest.when().post(MiddlemanAPI.USERS_PRODUCTS);
    }

    @Given("Post add product by user with invalid data product_name {string}, unit {string}, stock {string}, price {string}, product_image {string}")
    public void postAddProductByUserWithInvalidDataProduct_nameUnitStockPriceProduct_image(String product_name, String unit, String stock, String price, String product_image) {
        String filePath = System.getProperty("user.dir") + "/src/main/resources/" + product_image;
        File image = new File(filePath);
        middlemanAPI.postAddProductByUser(product_name, unit, stock, price, image);
    }

    @Given("Set parameter to {string}")
    public void setParameterTo(String Parameter) {
        middlemanAPI.getSearchUserProduct(Parameter);
    }

    @When("Send request to search")
    public void sendRequestToSearch() {
        SerenityRest.when().get(MiddlemanAPI.USERS_PRODUCTS_SEARCH);
    }

    @Given("Set parameter to valid id {} and valid data product_name {string}, unit {string}, stock {string}, price {string}, image {string}")
    public void setParameterToValidIdAndValidDataProduct_nameUnitStockPrice(int id, String product_name, String unit, String stock, String price, String imageName) {
        File imageFile = new File(System.getProperty("user.dir") + "/src/main/resources/" + imageName);
        middlemanAPI.putUpdateUserProductValidId(id, product_name, unit, stock, price, imageFile);
    }

    @Given("Set parameter to invalid id {} and valid data product_name {string}, unit {string}, stock {string}, price {string}, image {string}")
    public void setParameterToInvalidIdAndValidDataProduct_nameUnitStockPrice(int id, String product_name, String unit, String stock, String price, String imageName) {
        File imageFile = new File(System.getProperty("user.dir") + "/src/main/resources/" + imageName);
        middlemanAPI.putUpdateUserProductValidId(id, product_name, unit, stock, price, imageFile);
    }

    @Given("Set parameter to valid id {} and invalid data product_name {string}, unit {string}, stock {string}, price {string}, image {string}")
    public void setParameterToValidIdAndInvalidDataProduct_nameUnitStockPrice(int id, String product_name, String unit, String stock, String price, String imageName) {
        File imageFile = new File(System.getProperty("user.dir") + "/src/main/resources/" + imageName);
        middlemanAPI.putUpdateUserProductValidId(id, product_name, unit, stock, price, imageFile);
    }

    @When("Send request to update user product")
    public void sendRequestToUpdateUserProduct() {
        SerenityRest.when().put(MiddlemanAPI.USERS_PRODUCTS_ID);
    }

    @Given("Set id with {int}")
    public void setIdWith(int id) {
        middlemanAPI.deleteUserProduct(id);
    }

    @When("Send request to delete")
    public void sendRequestToDelete() {
        SerenityRest.when().delete(MiddlemanAPI.USERS_PRODUCTS_ID);
    }

    @Given("Set invalid id with {string}")
    public void setInvalidIdWith(String id) {
        middlemanAPI.deleteUserProductinvalid(id);
    }

}
