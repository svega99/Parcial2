/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.AirportsTest.cache.impl;


import edu.eci.arsw.AirportsTest.cache.AirportsFinderCache;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author 2133832
 */

@Service("AFCacheImpl")
public class AirpotsFinderCacheImpl implements AirportsFinderCache{

    HashMap<String,String> airpotsbyname = new  HashMap<String,String>();
    HashMap<String,Long> airpotstime = new  HashMap<String,Long>();
    
    @Override
    public void save(String name, String json) {
        airpotsbyname.put(name, json);
        airpotstime.put(name,System.currentTimeMillis());
    }

    @Override
    public boolean isSave(String name) {
        return airpotsbyname.containsKey(name);
    }

    @Override
    
    public String load(String name) {
        String airpots = airpotsbyname.get(name);
        
        long timeLoad =( System.currentTimeMillis()-airpotstime.get(name))/1000;
        
        if (timeLoad>300){
            airpotsbyname.remove(name);
            airpotstime.remove(name);
        }
        
        return airpots;
         
    }
    
}
