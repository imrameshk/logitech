package utilities;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;

import org.hamcrest.Matchers;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestApi {
	protected static final String BASE_ENDPOINT = "https://restful-booker.herokuapp.com/";
	protected static final String AUTH_ENDPOINT = BASE_ENDPOINT + "auth/";
	protected static final String BOOKING_ENDPOINT = BASE_ENDPOINT + "booking/";

	public int bookingId;
	String path = System.getProperty("user.dir");
	Utility fileUtil = new Utility();

	/**
	 * Creates a new auth token to use for access to the PUT and DELETE /booking
	 * 
	 * @return
	 * @throws IOException
	 * 
	 */
	public Response getToken() throws IOException {

		// Creating a File instance
		File jsonDataInFile = new File(path + fileUtil.getProperty("authjsonfilepath"));

		Response response =
				// GIVEN
				RestAssured.given().baseUri(AUTH_ENDPOINT).contentType(ContentType.JSON).body(jsonDataInFile)
						// WHEN
						.when().post()
						// THEN
						.then().assertThat().statusCode(200).body("token", Matchers.notNullValue())
						.body("token.length()", Matchers.is(15)).body("token", Matchers.matchesRegex("^[a-z0-9]+$"))
						.extract().response();
		return response;
	}

	/**
	 * TO create new booking
	 * 
	 * @return
	 * @throws IOException
	 * 
	 */
	public Response createBooking() throws IOException {

		// Creating a File instance
		File jsonDataInFile = new File(path + fileUtil.getProperty("createBookingjsonfilepath"));

		Response response =
				// GIVEN
				RestAssured.given().baseUri(BOOKING_ENDPOINT).contentType(ContentType.JSON).body(jsonDataInFile)
						// WHEN
						.when().post()
						// THEN
						.then().assertThat().statusCode(200).extract().response();
		return response;
	}

	/**
	 * To get booking
	 * 
	 * @return
	 * @throws IOException
	 * 
	 */
	public Response getBooking() throws IOException {

		Response response =
				// GIVEN
				RestAssured.given().baseUri(BOOKING_ENDPOINT + bookingId)
						// WHEN
						.when().get()
						// THEN
						.then().assertThat().statusCode(200).extract().response();
		return response;
	}

	/**
	 * TO update new booking
	 * 
	 * @return
	 * @throws IOException
	 * 
	 */
	public Response updateBooking(String token) throws IOException {

		// Creating a File instance
		File jsonDataInFile = new File(path + fileUtil.getProperty("updateBookingjsonfilepath"));

		Response response =
				// GIVEN
				RestAssured.given().baseUri(BOOKING_ENDPOINT + bookingId).contentType(ContentType.JSON)
						.cookie("token", token).body(jsonDataInFile)
						// WHEN
						.when().put()
						// THEN
						.then().assertThat().statusCode(200).extract().response();
		return response;
	}

	/**
	 * TO delete booking
	 * 
	 * @return
	 * @throws IOException
	 * 
	 */
	public Response deleteBooking(String token) throws IOException {

		Response response =
				// GIVEN
				RestAssured.given().baseUri(BOOKING_ENDPOINT + bookingId).contentType("application/json").cookie("token", token)
						// WHEN
						.when().delete()
						// THEN
						.then().assertThat().extract().response();
		return response;
	}

}
