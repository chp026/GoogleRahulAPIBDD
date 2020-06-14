package GoogleAPIBDD.StepDefinitionPackage;

import GoogleAPIBDD.BaseClassPackage.BaseClass;
import GoogleAPIBDD.PageObjectPackage.GetInfo;
import GoogleAPIBDD.PageObjectPackage.PostInfo;
import GoogleAPIBDD.PageObjectPackage.PutInfo;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PutInfoSteps extends BaseClass {
    GetInfo getInfo = new GetInfo();
    PutInfo putInfo = new PutInfo();

    @Given("^user is base uri rahul shattey$")
    public void user_is_base_uri_rahul_shattey() throws Throwable {
        requestSpecification = given().baseUri(getInfo.GetBaseUri()).contentType(ContentType.JSON)
        .body(putInfo.PutPayload());
    }

    @When("^user puts the information to be added$")
    public void user_puts_the_information_to_be_added() throws Throwable {
        response = requestSpecification.put(putInfo.PutResource());
    }

    @Then("^user should be able to see all the updated information$")
    public void user_should_be_able_to_see_all_the_updated_information() throws Throwable {
        response.then().log().all().assertThat().statusCode(200).and().contentType(ContentType.JSON)
        .and().body("msg",equalTo("Address successfully updated"));
    }

}
