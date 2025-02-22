package stepDefinitions;

import io.cucumber.java.en.Given;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;

public class APITestDefs {

    @Given("User is able to get response from the API")
    public void user_is_able_to_get_response_from_the_api() {
        String url = "http://demo.guru99.com/V4/sinkministatement.php";
        Response response = given().
                queryParam("CUSTOMER_ID","68195").
                queryParam("PASSWORD","1234!").
                queryParam("Account_No","1").
                when().get(url);
        System.out.println("Status Code\n" + response.getStatusCode() + "\n");
//        System.out.println("Headers\n" + response.then().extract().headers() + "\n");
        ArrayList<String> arrayList = response.then().extract().path("result.statements.AMOUNT");
        for (String a:arrayList){
            System.out.println("AMOUNT\n" + a + "\n");
        }
        System.out.println("Time Taken(ms)\n: " + response.timeIn(TimeUnit.MILLISECONDS) + "\n");
        given().when().get(url).then().assertThat().statusCode(200);
    }
}
