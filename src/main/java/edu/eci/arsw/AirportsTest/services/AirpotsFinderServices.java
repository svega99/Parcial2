/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.AirportsTest.services;

import edu.eci.arsw.AirportsTest.model.Airport;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author 2133832
 */
public interface AirpotsFinderServices {
    public List<Airport> getAirpotsByName(String name) throws IOException;
}
