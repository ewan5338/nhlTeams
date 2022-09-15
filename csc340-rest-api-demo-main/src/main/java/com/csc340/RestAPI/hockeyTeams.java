/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csc340.RestAPI;

/**
 *
 * @author sentini
 */
public class hockeyTeams {
    private String name;
    private String city;

    public hockeyTeams(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getcity() {
        return city;
    }

    public void setCity (String city) {
        this.city = city;
    }
}
