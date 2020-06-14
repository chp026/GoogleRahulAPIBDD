package GoogleAPIBDD.StepDefinitionPackage;

import GoogleAPIBDD.BaseClassPackage.BaseClass;
import GoogleAPIBDD.PageObjectPackage.GetInfo;
import GoogleAPIBDD.PageObjectPackage.PostInfo;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class PostUserSteps extends BaseClass {
    GetInfo getInfo = new GetInfo();
    PostInfo postInfo = new PostInfo();

    @Given("^user is on base uri$")
    public void user_is_on_base_uri() throws Throwable {
        requestSpecification = given().baseUri(getInfo.GetBaseUri()).contentType(ContentType.JSON)
        .body(postInfo.PostPayload());
    }

    @When("^user posts all new information$")
    public void user_posts_all_new_information() throws Throwable {
        response = requestSpecification.post(postInfo.PostResource());
    }

    @Then("^user should be able to see all the newley added information$")
    public void user_should_be_able_to_see_all_the_newley_added_information() throws Throwable {
        response.then().log().all().assertThat().statusCode(200).and().contentType(ContentType.JSON);
    }

}
