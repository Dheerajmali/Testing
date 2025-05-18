package transport_schedule_id;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
public class Post {

	public static void main(String[] args) {
		given().contentType(ContentType.JSON).body("[\r\n"
				+ "    {\r\n"
				+ "        \"id\": \"2\",\r\n"
				+ "        \"routeId\": \"R006\",\r\n"
				+ "        \"busNumber\": \"Bus111\",\r\n"
				+ "        \"origin\": \"busStation2\",\r\n"
				+ "        \"destination\": \"busStation3\",\r\n"
				+ "        \"arrivalTime\": \"13:30\",\r\n"
				+ "        \"status\": \"on Time\"\r\n"
				+ "    }\r\n"
				+ "]\r\n"
				+ "").post("http://localhost:3000/BusDetails").prettyPrint();
		

	}

}
