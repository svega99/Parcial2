/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.AirportsTest.cache;

/**
 *
 * @author 2133832
 */
public interface AirportsFinderCache {
    public void save (String name, String json);
    public boolean isSave(String name);
    public String load(String name);
}
