package Activities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Activity1 {
    final static String ROOT_URI = "https://petstore.swagger.io/v2/pet";
    @Test(priority = 1)
    public void addNewPet() {
        // Request body
        String reqBody = "{\"id\": 77202,\"name\": \"Riley\",\"status\": \"alive\"}";
        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .body(reqBody).when().post(ROOT_URI); // Send POST request
        // Assertions for id, name, and status items
        response.then().body("id", equalTo(77202));
        response.then().body("name", equalTo("Riley"));
        response.then().body("status", equalTo("alive"));
    }
    @Test(priority = 2)
    public void getPet() {
        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .when().pathParam("petId","77202").get(ROOT_URI+"/{petId}"); // Send GET request
       // Assertions for id, name, and status items
        response.then().body("id", equalTo(77202));
        response.then().body("name", equalTo("Riley"));
        response.then().body("status", equalTo("alive"));
    }
    @Test(priority = 3)
    public void deletePet(){
        Response response =
                given().contentType(ContentType.JSON) //Ser headers
                        .when().pathParam("petId", "77202").delete(ROOT_URI+"/{petId}"); // Send DELETE request
        // Assertions for code and message
         response.then().body("code", equalTo(200));
         response.then().body("message", equalTo("77202"));
    }
}
