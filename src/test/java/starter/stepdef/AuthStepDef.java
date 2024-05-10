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

    @Steps
    MiddlemanAPI middlemanAPI;

    @Given("Login with valid JSON {string}")
    public void userValidAuthBodyJson(String JSON) {
        File jsonFile = new File(Constants.REQ_BODY + JSON);
        middlemanAPI.loginMiddlemanAPI(jsonFile);
    }

    @When("User Send request post login")
    public void userSendRequestPostLogin() {
        Response response = SerenityRest.when().post(MiddlemanAPI.LOGIN);
        JsonPath jsonPathEvaluator = response.jsonPath();
        token = jsonPathEvaluator.get("data.token");
        //System.out.println(token);
    }

    @When("User Send request post login admin")
    public void userSendRequestPostLoginAdmin() {
        Response response = SerenityRest.when().post(MiddlemanAPI.LOGIN);
        JsonPath jsonPathEvaluator = response.jsonPath();
        tokenAdmin = jsonPathEvaluator.get("data.token");
    }

}