package Project;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class GitHubProject {
    RequestSpecification reqSpec;
    ResponseSpecification resSpec;
    String sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIOZIgVy1pmEl9TESal4fUGjVRAQ9LznvnaBQs0RxhCog";
    int sshKeyId;
    @BeforeClass
        public void setUp(){
        // Create a Request Specification
            reqSpec = new RequestSpecBuilder()
                    .setContentType(ContentType.JSON)
                    .addHeader("Authorization", "token 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")
                    .setBaseUri("https://api.github.com/user/keys")
                    .build();
    }
    @Test(priority = 1)
        public void postReq(){
            Map<String, Object> reqBody = new HashMap<>();
            reqBody.put("title","TestAPIKey");
            reqBody.put("key",sshKey);
            // Generate Response
            Response response = given().spec(reqSpec).body(reqBody).when().post();
            // Extract the id from the response
            sshKeyId = response.then().extract().path("id");
            System.out.println("sshKeyId is: " +sshKeyId);
            // Assertions
            response.then().statusCode(201);
    }
    @Test(priority = 2)
        public void getReq(){
            Response response = given().spec(reqSpec)
                    .pathParam("keyId", sshKeyId)
                    .get("/{keyId}");
            String body = response.getBody().asPrettyString();
            System.out.println(body);
            //Assertions
            response.then().statusCode(200);

    }
    @Test(priority = 3)
        public void deleteReq(){
            Response response = given().spec(reqSpec)
                    .pathParam("keyId", sshKeyId)
                    .when().delete("/{keyId}");
            String body = response.getBody().asPrettyString();
            System.out.println(body);
            //Assertions
            response.then().statusCode(204);
    }
}
