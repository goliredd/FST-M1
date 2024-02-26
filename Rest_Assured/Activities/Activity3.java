package Activities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Activity3 {

    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;

    @BeforeClass
    public void setUp(){
        requestSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON).setBaseUri("https://petstore.swagger.io/v2/pet")
                .build();
        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200).expectContentType("application/json")
                .expectBody("status", equalTo("alive")).build();
    }

    @Test(priority = 1)
    public void addTwoNewPets() {
        // Request body
        String reqBody = "{\"id\": 72008,\"name\": \"Riley\",\"status\": \"alive\"}";
        Response response =
                given().spec(requestSpec).body(reqBody).when().post(); // Send POST request
        reqBody = "{\"id\": 74233,\"name\": \"Hansel\",\"status\": \"alive\"}";
        response =
                given().spec(requestSpec).body(reqBody).when().post(); // Send POST request
        // Assertions
        response.then().spec(responseSpec);
    }

    @DataProvider
    public Object[][] petDetailsProvider(){
        Object[][] testData = new Object[][] {
                { 72008, "Riley", "alive" },
                { 74233, "Hansel", "alive" }
        };
        return testData;
    }

    @Test(dataProvider = "petDetailsProvider", priority = 2)
    public void getPets(int id, String name, String status) {
        Response response =
                given().spec(requestSpec).pathParam("petId", id).when().get("/{petId}"); // Send GET request
        // Print response
        System.out.println(response.asPrettyString());
       // Assertion
        response.then().spec(responseSpec).body("name", equalTo(name));
    }
    @Test(dataProvider = "petDetailsProvider" ,priority = 3)
    public void deletePets(int id, String name, String status){
        Response response =
                given().spec(requestSpec).pathParam("petId", id)
                        .when().delete("/{petId}"); // Send DELETE request
        // Assertions
         response.then().body("code", equalTo(200));
    }
}
