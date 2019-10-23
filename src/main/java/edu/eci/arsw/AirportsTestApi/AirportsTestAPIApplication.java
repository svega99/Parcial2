/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.AirportsTestApi;

/**
 *
 * @author 2133832
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.eci.arsw.AirportsTest"})
public class AirportsTestAPIApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirportsTestAPIApplication.class, args);
	}

}