package tests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class LeaveApplyAPITest {

    @BeforeClass
    public void setup() {
        // Read base URI from pom.xml (system property)
        String baseUri = System.getProperty("base.uri");
        if (baseUri == null || baseUri.isEmpty()) {
            baseUri = "https://glbg.servergi.com:8072/SIMWEBGLB/Employee/Leave%20Apply"; // fallback
        }
        RestAssured.baseURI = baseUri;
    }

    @Test
    public void testLeaveApplyEndpoint() {
        given()
            .relaxedHTTPSValidation()   // ✅ ignores SSL issues if self-signed cert
        .when()
            .get()
        .then()
            .statusCode(200)   // ✅ Validate HTTP 200 OK
            .body("size()", greaterThan(0)); // ✅ Validate response is not empty
    }
}
