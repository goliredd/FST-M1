package Activities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Activity2 {
    final static String ROOT_URI = "https://petstore.swagger.io/v2/user";
    @Test(priority = 1)
    public void addNewUserFromFile() throws IOException {
        // Import JSON file
        FileInputStream inputJSON = new FileInputStream("src/test/Resources/Activity2.json");
        // Read JSON file as string
        String reqBody = new String(inputJSON.readAllBytes());
        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .body(reqBody).when().post(ROOT_URI); // Send POST request
        inputJSON.close();
        // Assertions
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("6273"));
    }
    @Test(priority = 2)
    public void getUser() {
        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .when().pathParam("username","jerry3").get(ROOT_URI+"/{username}"); // Send GET request
        String body = response.getBody().asPrettyString();
        System.out.println(body);
       // Assertions for id, name, and status items
        response.then().body("id", equalTo(6273));
        response.then().body("username", equalTo("jerry3"));
        response.then().body("firstName", equalTo("Justin"));
        response.then().body("lastName", equalTo("Case"));
        response.then().body("email", equalTo("justincase@mail.com"));
        response.then().body("password", equalTo("password123"));
        response.then().body("phone", equalTo("9812763450"));
    }
    @Test(priority = 3)
    public void deleteUser(){
        Response response =
                given().contentType(ContentType.JSON) //Ser headers
                        .when().pathParam("username", "jerry3").delete(ROOT_URI+"/{username}"); // Send DELETE request
        String body = response.getBody().asPrettyString();
        System.out.println(body);
        // Assertions for code and message
         response.then().body("code", equalTo(200));
         response.then().body("message", equalTo("jerry3"));
    }
}
