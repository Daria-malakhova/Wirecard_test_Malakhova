package Tests;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class User_Registration_Service {

    @Test
    public void positiveTest() throws UnirestException {
        HttpResponse<JsonNode> jsonResponse = Unirest.put("http://www.mocky.io/v2/5baba6133100000f00654498")
                .header("accept", "application/json")
                .asJson();
        assertNotNull(jsonResponse.getBody());
        assertEquals(200, jsonResponse.getStatus());
    }

    @Test
    public void missingMandatoryField() throws UnirestException {
        HttpResponse<JsonNode> jsonResponse = Unirest.put("http://www.mocky.io/v2/5baba8803100005e0065449e")
                .header("accept", "application/json")
                .asJson();
        assertNotNull(jsonResponse.getBody());
        assertEquals(400, jsonResponse.getStatus());
    }

    @Test
    public void userWithPhoneExist() throws UnirestException {
        HttpResponse<JsonNode> jsonResponse = Unirest.put("http://www.mocky.io/v2/5babab6b3100004c006544ac")
                .header("accept", "application/json")
                .asJson();
        assertNotNull(jsonResponse.getBody());
        assertEquals(403, jsonResponse.getStatus());
    }
}
