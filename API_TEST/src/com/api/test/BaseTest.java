package com.api.test;
import com.api.result.apiAssertionTest;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 
 * This file has the solutions to the question
 * 
 * Junit tests  
 * 
 * *Name = "Badges"

 * *CanListClassifieds = false

 * *(Assert boolean) The Charities element with Description = "Plunket" 
 *  has a Tagline that contains the text "well child health services"
 *  
 * @author Akash Aswal
 *
 */

public class BaseTest {

	apiAssertionTest obj = new apiAssertionTest();
	JSONObject json;
	
	public BaseTest() throws Exception{
		this.json = obj.testAPI();
	}

	@Test
    public void testName() throws Exception {
    	
		Object input = json.get("Name");
    	String expected = "Badges";
    	
        assertEquals(input, expected);

    }
	
	@Test
    public void testCanListClassifields() throws Exception {
    	
		Object input = json.get("CanListClassifieds");
    	boolean expected = false;
    	
        assertEquals(input, expected);

    }
	
	
	@Test
    public void testCharities() throws Exception {
    	
		JSONArray jsonarr= json.getJSONArray("Charities");
		for(int i = 0; i <jsonarr.length(); i++){
			
		String test1 = jsonarr.getJSONObject(i).getString("Description");
		String test2 = jsonarr.getJSONObject(i).getString("Tagline");
			
			if(test1.equals("Plunket")  && test2.contains("well child health services")){
				assertTrue(true);
			}
	
		}
		assertFalse(false);

	}
	
}
