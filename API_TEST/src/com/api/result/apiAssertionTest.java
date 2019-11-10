package com.api.result;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import org.json.JSONObject; 

/**
 * apiAssertionTest - sends a GET request to requested url
 * @returns - JSONObject (response)
 * 
 * @author Akash
 *
 */
public class apiAssertionTest {

	public JSONObject testAPI() throws Exception{
		
		String url = "https://api.tmsandbox.co.nz/v1/Categories/6328/Details.json?catalogue=false";
        HttpURLConnection httpClient =(HttpURLConnection) new URL(url).openConnection();
        httpClient.setRequestMethod("GET");
        httpClient.setRequestProperty("Content-Type", "application/json");
        
        int responseCode = httpClient.getResponseCode();
        System.out.println("Response Code : " + responseCode);
        
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(httpClient.getInputStream()))) {

            StringBuilder response = new StringBuilder();
            String line;

            while ((line = in.readLine()) != null) {
                response.append(line);
            }

            return new JSONObject(response.toString());

        }
		
	}
		
}
