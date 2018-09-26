package Tests;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class Card_Lock_Service {

    @Test
    public void positiveTest() throws UnirestException {
        HttpResponse<JsonNode> jsonResponse = Unirest.put("http://www.mocky.io/v2/5babaf4131000057006544c1")
                .header("accept", "application/json")
                .asJson();
        assertNotNull(jsonResponse.getBody());
        assertEquals(200, jsonResponse.getStatus());
    }

    @Test
    public void missingParameter() throws UnirestException {
        HttpResponse<JsonNode> jsonResponse = Unirest.put("http://www.mocky.io/v2/5babaf5031000029006544c2")
                .header("accept", "application/json")
                .asJson();
        assertNotNull(jsonResponse.getBody());
        assertEquals(400, jsonResponse.getStatus());
    }

    @Test
    public void cardAlreadyLocked() throws UnirestException {
        HttpResponse<JsonNode> jsonResponse = Unirest.put("http://www.mocky.io/v2/5babaf6431000029006544c4")
                .header("accept", "application/json")
                .asJson();
        assertNotNull(jsonResponse.getBody());
        assertEquals(403, jsonResponse.getStatus());
    }

    @Test
    public void noCardFound() throws UnirestException {
        HttpResponse<JsonNode> jsonResponse = Unirest.put("http://www.mocky.io/v2/5babaf7231000010006544c5")
                .header("accept", "application/json")
                .asJson();
        assertNotNull(jsonResponse.getBody());
        assertEquals(404, jsonResponse.getStatus());
    }

}
