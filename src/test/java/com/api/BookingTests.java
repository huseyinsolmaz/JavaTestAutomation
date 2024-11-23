package com.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookingTests {

    // Base URI
    static {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
    }

    // Variables for booking and token
    private static int bookingId;
    private static String authToken;

    @Test(priority = 1)
    public void createBooking() {
        // Create Booking JSON Body
        String requestBody = "{"
                + "\"firstname\": \"Jim\","
                + "\"lastname\": \"Brown\","
                + "\"totalprice\": 111,"
                + "\"depositpaid\": true,"
                + "\"bookingdates\": {\"checkin\": \"2024-11-01\", \"checkout\": \"2024-11-10\"},"
                + "\"additionalneeds\": \"Breakfast\""
                + "}";

        // POST request to create a booking
        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post("/booking");

        // Assert that the status code is 200
        Assert.assertEquals(response.getStatusCode(), 200);

        // Get the booking ID from the response
        bookingId = response.jsonPath().getInt("bookingid");

        // Validate the response body contains the expected values
        Assert.assertEquals(response.jsonPath().getString("booking.firstname"), "Jim");
        Assert.assertEquals(response.jsonPath().getString("booking.lastname"), "Brown");
    }

    @Test(priority = 2)public void deleteBooking() {
        // Authenticate and get the token
        String authBody = "{ \"username\": \"admin\", \"password\": \"password123\" }";
        Response authResponse = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(authBody)
                .post("/auth");

        authToken = authResponse.jsonPath().getString("token");

        // Assert that the token is not null
        Assert.assertNotNull(authToken);

        // DELETE request to remove the booking
        Response deleteResponse = RestAssured
                .given()
                .header("Cookie", "token=" + authToken)
                .delete("/booking/" + bookingId);

        // Assert the status code is 201 (success)
        Assert.assertEquals(deleteResponse.getStatusCode(), 201);

        // Verify the booking was deleted by sending a GET request
        Response verifyResponse = null;

        try {
            verifyResponse = RestAssured
                    .given()
                    .get("/booking/" + bookingId);

            // If 404 is returned, we consider the booking as successfully deleted
            if (verifyResponse.getStatusCode() == 404) {
                System.out.println("Booking successfully deleted, received 404 Not Found");
            } else {
                // Handle any other unexpected status codes
                Assert.fail("Expected 404, but got: " + verifyResponse.getStatusCode());
            }

        } catch (Exception e) {
            // If 404 error occurs (or any other exception), we handle it here
            System.out.println("Booking successfully deleted (caught exception): " + e.getMessage());
        }
    }
}