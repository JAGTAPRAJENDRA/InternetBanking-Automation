package services;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/*
 * This class calls OTP API and returns OTP value
 */
public class OtpService {

    /*
     * This method calls OTP API and fetches OTP
     */
    public String getOtp() {

        // Send POST request to OTP API
        Response response = RestAssured
                .given()
                .contentType("application/json")
                .body("{"
                        + "\"entityId\":\"RIB\","
                        + "\"deviceId\":\"9\","
                        + "\"prefered_Language\":\"en\","
                        + "\"sourceIp\":\"NA\","
                        + "\"map\":{"
                        + "\"entityId\":\"RIB\","
                        + "\"deviceId\":\"9\","
                        + "\"UserID\":\"rohit111\""
                        + "}"
                        + "}")
                .post("https://unicuat.punjabandsind.bank.in:7443/OMNI/rest/CUSTOTHERINFO/GETLASTOTP");

        // Print API status code in console
        System.out.println("OTP API Status Code: " + response.getStatusCode());

        // Get OTP from API response
        String otp = response.jsonPath()	
                .getString("responseParameter.OTP");

        // Print OTP in console
        System.out.println("Fetched OTP from API: " + otp);

        // Return OTP to step definition
        return otp;
    }
}
