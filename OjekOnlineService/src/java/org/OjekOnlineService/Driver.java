/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.OjekOnlineService;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adyan
 */
@XmlRootElement(name = "Driver")
public class Driver {
    @XmlElement(name = "ID", required = true)
    private int id;
    
    @XmlElement(name = "name", required = true)
    private String name;
    
    @XmlElement(name = "total_rating", required = true)
    private int total_rating;

    @XmlElement(name = "total_passangers", required = true)
    private int total_passangers;

    @XmlElement(name = "location", required = true)
    private ArrayList<String> location;

    public Driver() {

    }

    public Driver(int id, String name, int total_rating, int total_passangers, ArrayList<String> location) {
            this.id = id;
            this.name = name;
            this.total_rating = total_rating;
            this.total_passangers = total_passangers;
            this.location = location;
    }
    
    public String getName(){
        return name;
    }

    public int getTotalRating() {
        return total_rating;
    }

    public int getTotalPassangers() {
        return total_passangers;
    }

    public ArrayList<String> getLocation() {
        return location;
    }
}
