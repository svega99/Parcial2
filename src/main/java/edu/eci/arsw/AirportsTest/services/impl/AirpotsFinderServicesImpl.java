/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.AirportsTest.services.impl;

import edu.eci.arsw.AirportsTest.model.Airport;
import edu.eci.arsw.AirportsTest.services.AirpotsFinderServices;
import edu.eci.arsw.AirportsTest.services.HttpConnectionService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import static org.springframework.http.converter.json.Jackson2ObjectMapperBuilder.json;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 *
 * @author 2133832
 */
@Service("AFServicesImpl")
public class AirpotsFinderServicesImpl implements AirpotsFinderServices{
    
    @Autowired
    @Qualifier("HCServicesImpl")
    HttpConnectionService hcs;
    
    @Override
    public List<Airport> getAirpotsByName(String name) throws IOException{
        List<Airport> airpots=new ArrayList<>();
        
        String response=hcs.airpotsByName(name);
        response=response.replace("\"", "");
        response=response.replace("[", "");
        response=response.replace("]", "");
        response=response.replace("{", "");
        response=response.replace("}", "");
        String [] responsesplit=response.split(",");
        String code=null;
        String nombre=null;
        String city=null;
        String countryCode=null;
        
        for (int i=0;i<responsesplit.length;i++){
            if(responsesplit[i].contains("code")){
                code=responsesplit[i].replace("code:", "");
            }
            if(responsesplit[i].contains("name:")){
                nombre=responsesplit[i].replace("name:", "");
            }
            if(responsesplit[i].contains("city:")){
                city=responsesplit[i].replace("city:", "");
            }
            if(responsesplit[i].contains("countryCode:")){
                countryCode=responsesplit[i].replace("countryCode:", "");
                Airport a = new Airport();
                a.setName(nombre);
                a.setciudad(city);
                a.setcodigo(code);
                a.setcodigoPais(countryCode);
                airpots.add(a);
            }
        }
        
        System.out.println(Arrays.toString(responsesplit));
        return airpots;
    }
    
}
