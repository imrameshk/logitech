package stepDefinitions;

import java.io.IOException;

import org.json.JSONException;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.cucumber.java.en.Given;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import utilities.RestApi;
import utilities.Utility;

public class ApiStepDefinitions {

@BeforeClass
public void Start() {
	System.out.println("Starting Test");
}
	public static String token;
	private static Response response;

	RestApi restAPI = new RestApi();
	Utility fileUtil = new Utility();

	@Given("I am an authorized user")
	public void iAmAnAuthorizedUser() throws IOException {

		response = restAPI.getToken();
		System.out.println("Token : "+response.getBody().asString());

		String jsonString = response.asString();
	       //We will deserialize the Response body into Token Response
	        token = JsonPath.from(jsonString).get("token");

	}

	@Given("Create Booking")
	public void createBooking() throws IOException, JSONException, ParseException {

		response = restAPI.createBooking();
		System.out.println("Create Booking : "+response.getBody().asString());
		
		 String jsonString = response.asString();
	       //We will deserialize the Response body into Token Response
	        int bookingId = JsonPath.from(jsonString).get("bookingid");
	       // String finalbookingId =Integer.toString(bookingId);
	        //System.out.println("finalBooking : "+finalbookingId);
	       restAPI.bookingId = bookingId;


	}
	
	@Given("Get Booking")
	public void getBooking() throws IOException {

		response = restAPI.getBooking();
		System.out.println("Get Booking : "+response.getBody().asString());

	}

	@Given("Update Booking")
	public void updateBooking() throws IOException {

		response = restAPI.updateBooking(token);
		System.out.println("Update Booking : "+response.getBody().asString());
		

	}
	

	@Given("Delete Booking")
	public void deleteBooking() throws IOException {

		response = restAPI.deleteBooking(token);
		System.out.println("Delete Booking : "+response.getBody().asString());

	}

	@AfterClass
	public void Stop() {
		System.out.println("Ending Test");
	}
}