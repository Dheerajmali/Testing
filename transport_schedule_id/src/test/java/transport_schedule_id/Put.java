package transport_schedule_id;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
public class Put {

	public static void main(String[] args) {
		given().contentType(ContentType.JSON).body("{\r\n"
				+ "            \"id\": \"3\",\r\n"
				+ "        \"routeId\": \"R003\",\r\n"
				+ "        \"busNumber\": \"Bus789\",\r\n"
				+ "        \"origin\": \"busStation3\",\r\n"
				+ "        \"destination\": \"busStation4\",\r\n"
				+ "        \"arrivalTime\": \"17:00\",\r\n"
				+ "        \"status\": \"on Time\", \r\n"
				+ "  }").put("http://localhost:3000/BusDetails").prettyPrint();

	}

}
