package GoogleAPIBDD.StepDefinitionPackage;

import GoogleAPIBDD.BaseClassPackage.BaseClass;
import GoogleAPIBDD.PageObjectPackage.GetInfo;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class GetAPIInfo extends BaseClass {
    GetInfo getInfo = new GetInfo();

    @Given("^user is on the base uri of Rahul Shattey$")
    public void user_is_on_the_base_uri_of_Rahul_Shattey() throws Throwable {
        requestSpecification = given().baseUri(getInfo.GetBaseUri());
    }

    @When("^user provides path and query param to get information$")
    public void user_provides_path_and_query_param_to_get_information() throws Throwable {
        response = requestSpecification.when().get(getInfo.GetResource());
    }

    @Then("^user should be able to see all the details from API Server$")
    public void user_should_be_able_to_see_all_the_details_from_API_Server() throws Throwable {
        response.then().log().all().assertThat().statusCode(200).and().contentType(ContentType.JSON)
        .and().body("types",equalTo("shoe park,shop"));
    }

}
