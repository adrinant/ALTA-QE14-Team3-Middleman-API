package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.middleman.MiddlemanAPI;
import starter.utils.Constants;

import java.io.File;

public class AdminProdStepDef {

    @Steps
    MiddlemanAPI middlemanAPI;

    //Add Product Positive
    @Given("Post add product by admin with valid data product_name {string}, unit {string}, stock {string}, price {string}, product_image {string}")
    public void postUpdateProductByUserWithValidDataProductNameUnitStockPriceProduct_image(String product_name, String unit, String stock, String price, String product_image) {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/form/" + product_image;
        File image = new File(filePath);
        middlemanAPI.postAddProductByAdmin(product_name, unit, stock, price, image);
    }

    @When("Send request post update product")
    public void sendRequestPostUpdateProduct() {
        SerenityRest.when()
                .post(MiddlemanAPI.ADMIN_PRODUCTS);
    }

    //Add Product Negative

    @Given("Post add product by admin with valid data unit {string}, stock {string}, price {string}, product_image {string}")
    public void postAddProductByAdminWithValidDataUnitStockPriceProduct_image(String unit, String stock, String price, String product_image) {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/form/" + product_image;
        File image = new File(filePath);
        middlemanAPI.postAddProductByAdmin(unit, stock, price, image);
    }

    //Get All Admin Products
    @Given("get all admin products")
    public void getAllAdminProducts() {
        middlemanAPI.getAdminProducts();
    }

    @When("Send request get admin products")
    public void sendRequestGetAdminProducts() {
        SerenityRest.when()
                .get(MiddlemanAPI.ADMIN_PRODUCTS);
    }

    // Get search Product Data
    @Given("Get search product data by admin")
    public void getSearchProductDataByAdmin() {
        middlemanAPI.getSearchProductData();
    }

    @When("Send request to get product data")
    public void sendRequestToGetProductData() {
        SerenityRest.when()
                .get(MiddlemanAPI.ADMIN_PRODUCTS_SEARCH);
    }

    //Put Update Product By Admin
    @Given("Put update product by admin with valid data product_name {string}, unit {string}, stock {string}, price {string}, product_image {string} and set parameter to {int}")
    public void putUpdateProductByAdminWithValidDataProduct_nameUnitStockPriceProduct_image(String product_name, String unit, String stock, String price, String product_image, int id) {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/form/" + product_image;
        File image = new File(filePath);
        middlemanAPI.putUpdateProductByAdmin(product_name, unit, stock, price, image, id);
    }

    @When("Send request put update product")
    public void sendRequestPutUpdateProduct() {
        SerenityRest.when()
                .put(MiddlemanAPI.ADMIN_PRODUCTS_ID);
    }

    // Put Update Product By Admin Invalid
    @Given("Put update product by admin with invalid data product_name {string}, unit {string}, stock {string}, price {string}, product_image {string} and set parameter to {int}")
    public void putUpdateProductByAdminWithInvalidDataProduct_nameUnitStockPriceProduct_image(String product_name, String unit, String stock, String price, String product_image, int id) {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/form/" + product_image;
        File image = new File(filePath);
        middlemanAPI.putUpdateProductInvalidByAdmin(product_name, unit, stock, price, image, id);
    }

    //Delete Product
    @Given("Delete product by id {int}")
    public void deleteProductById(int id) {
        middlemanAPI.deleteProductById(id);
    }

    @When("Send request delete product")
    public void sendRequestDeleteProduct() {
        SerenityRest.when()
                .delete(MiddlemanAPI.ADMIN_PRODUCTS_ID);
    }
}


