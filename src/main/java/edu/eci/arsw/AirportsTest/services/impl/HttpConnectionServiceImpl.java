/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.AirportsTest.services.impl;

import edu.eci.arsw.AirportsTest.services.HttpConnectionService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.springframework.stereotype.Service;

/**
 *
 * @author 2133832
 */
@Service("HCServicesImpl")
public class HttpConnectionServiceImpl implements HttpConnectionService{

    @Override
    public String airpotsByName(String name) throws IOException{
        
        String USER_AGENT = "Mozilla/5.0";
        String GET_URL = "https://cometari-airportsfinder-v1.p.rapidapi.com/api/airports/by-text?text="+name;
        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("x-rapidapi-host", "cometari-airportsfinder-v1.p.rapidapi.com");
        con.setRequestProperty("x-rapidapi-key", "44e05e8a84msh20cfe27fb6ce493p1e0dcdjsnb2c38f63528b");
        
        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
            return response.toString();
        } else {
            System.out.println("GET request not worked");
            return "GET request not worked";
        }

    

    }
    
}
