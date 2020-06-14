package GoogleAPIBDD.StepDefinitionPackage;

import GoogleAPIBDD.BaseClassPackage.BaseClass;
import GoogleAPIBDD.PageObjectPackage.DeleteInfo;
import GoogleAPIBDD.PageObjectPackage.GetInfo;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class DeleteInfoSteps extends BaseClass {
    GetInfo getInfo = new GetInfo();
    DeleteInfo deleteInfo = new DeleteInfo();

    @Given("^user is on the base uri rahul shattey API$")
    public void user_is_on_the_base_uri_rahul_shattey_API() throws Throwable {
        requestSpecification = given().baseUri(getInfo.GetBaseUri()).contentType(ContentType.JSON)
        .body(deleteInfo.DeletePayload());
    }

    @When("^user searches specific placeID and remove information$")
    public void user_searches_specific_placeID_and_remove_information() throws Throwable {
        response = requestSpecification.delete(deleteInfo.DeleteResource());
    }

    @Then("^user should be able to see successful message for deleting information$")
    public void user_should_be_able_to_see_successful_message_for_deleting_information() throws Throwable {
        response.then().log().all().assertThat().statusCode(200).and().contentType(ContentType.JSON)
        .and().body("status",equalTo("OK"));
    }

}
