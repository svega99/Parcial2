/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.AirportsTest.services.impl;

import edu.eci.arsw.AirportsTest.services.AirpotsFinderServices;
import edu.eci.arsw.AirportsTest.services.HttpConnectionService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
    public String getAirpotsByName(String name) throws IOException{
        return hcs.airpotsByName(name);
    }
    
}
