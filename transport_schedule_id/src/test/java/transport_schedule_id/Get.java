package transport_schedule_id;
import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get {

	 @Test
	    public void validateGetBusDetailsResponse() {
	        // Send GET request
	        Response res = given()
	                .log().all()
	            .when()
	                .get("http://localhost:3000/BusDetails")
	            .then()
	                .log().all()
	                .statusCode(200)
	                .extract().response();

	        // Log Response
	        System.out.println("Response:\n" + res.asPrettyString());

	        // Header Validation
	        String contentType = res.getHeader("Content-Type");
	        System.out.println("Content-Type: " + contentType);
	        assertEquals(contentType, "application/json", "Content-Type mismatch");

	        // Status Code Validation
	        int statusCode = res.getStatusCode();
	        if (statusCode == 200) {
	            assertEquals(statusCode, 200);
	            System.out.println("Request successful.");
	        } else if (statusCode == 404) {
	            System.out.println("Error 404: Resource Not Found");
	        }
	        else {
	            System.out.println("Unexpected Error Code: " + statusCode);
	        }
	        

	        // Response Time Validation
	        long responseTime = res.time();
	        System.out.println("Response Time: " + responseTime + " ms");
	        assertTrue(responseTime < 1000, "Response time exceeded 1000 ms");
	    }

}