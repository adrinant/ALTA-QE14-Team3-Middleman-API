package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.middleman.MiddlemanAPI;
import starter.utils.Constants;

import java.io.File;

public class AuthStepDef {

    public static String token;
    public static String tokenAdmin;
    public static String tokenDelete = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6NTEsIlJvbGUiOiJ1c2VyIiwiZXhwIjoxNzE1NTA5OTM5fQ.xc8pA80dvg2SWooMisa2FSueLmCpiBzOPUVdQCUfC1o";

    @Steps
    MiddlemanAPI middlemanAPI;

    @Given("Login with valid JSON {string}")
    public void userValidAuthBodyJson(String JSON) {
        File jsonFile = new File(Constants.REQ_BODY + JSON);
        middlemanAPI.postUserLogin(jsonFile);
    }

    @When("User send request post login")
    public void userSendRequestPostLogin() {
        Response response = SerenityRest.when().post(MiddlemanAPI.LOGIN);
        JsonPath jsonPathEvaluator = response.jsonPath();
        token = jsonPathEvaluator.get("data.token");
        //System.out.println(token);
    }

    @When("User send request post login admin")
    public void userSendRequestPostLoginAdmin() {
        Response response = SerenityRest.when().post(MiddlemanAPI.LOGIN);
        JsonPath jsonPathEvaluator = response.jsonPath();
        tokenAdmin = jsonPathEvaluator.get("data.token");
    }

    @Given("Set request body with invalid email and password entered with json {string}")
    public void setRequestBodyWithInvalidEmailAndPasswordEnteredWithJson(String json) {
        File jsonfile = new File(Constants.REQ_BODY + json);
        middlemanAPI.postUserLogin(jsonfile);
    }

    @When("Send request to login")
    public void sendRequestToLogin() {
        SerenityRest.when().post(MiddlemanAPI.LOGIN);
    }

    @Given("Set request body with valid data entered with json {string}")
    public void setRequestBodyWithValidDataEnteredWithJson(String json) {
        File jsonfile = new File(Constants.REQ_BODY + json);
        middlemanAPI.postUserRegister(jsonfile);
    }

    @When("Send request to register")
    public void sendRequestToRegister() {
        SerenityRest.when().post(MiddlemanAPI.REGISTER);
    }

    @Given("Set request body with invalid data entered with json {string}")
    public void setRequestBodyWithInvalidDataEnteredWithJson(String json) {
        File jsonfile = new File(Constants.REQ_BODY + json);
        middlemanAPI.postUserRegister(jsonfile);
    }

}