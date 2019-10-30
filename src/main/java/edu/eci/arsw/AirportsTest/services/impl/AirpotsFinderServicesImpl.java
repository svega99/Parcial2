/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.AirportsTest.services.impl;


import edu.eci.arsw.AirportsTest.cache.AirportsFinderCache;
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
    
    @Autowired
    @Qualifier("AFCacheImpl")
    AirportsFinderCache afc;
    
    @Override
    public String getAirpotsByName(String name) throws IOException{
        if(!afc.isSave(name)){
            afc.save(name, hcs.airpotsByName(name));
        }
        
        return afc.load(name);
        
    }
    
}
