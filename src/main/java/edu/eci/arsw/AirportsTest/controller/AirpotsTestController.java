/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.AirportsTest.controller;

import edu.eci.arsw.AirportsTest.services.AirpotsFinderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.springframework.http.converter.json.Jackson2ObjectMapperBuilder.json;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 2133832
 */

@RestController
@RequestMapping(value = "/airpotsfinder")
public class AirpotsTestController {
    @Autowired
    @Qualifier("AFServicesImpl")
    AirpotsFinderServices afs;
    
    @RequestMapping(path = "/{name}", method = RequestMethod.GET)
    public ResponseEntity<?> getAirpotsByName(@PathVariable(name = "name") String nombre) {
        try {
           
            return new ResponseEntity<>(afs.getAirpotsByName(nombre),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            return new ResponseEntity<>("400 bad request", HttpStatus.NOT_FOUND);
        }
    }
    
}
