/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.OjekOnlineService;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adyan
 */
@XmlRootElement(name = "Driver")
public class Driver extends User {
    @XmlElement(name = "total_rating", required = true)
    private int total_rating;

    @XmlElement(name = "total_passangers", required = true)
    private int total_passangers;

    @XmlElement(name = "location", required = true)
    private String location;

    public Driver() {

    }

    public Driver(int id, String name, String username, String email, String password, String phone_number, int driver, String image, int total_rating, int total_passangers, String location) {
            super(id, name, username, email, password, phone_number, driver, image);
            this.total_rating = total_rating;
            this.total_passangers = total_passangers;
            this.location = location;
    }

    public int getTotalRating() {
            return total_rating;
    }

    public int getTotalPassangers() {
            return total_passangers;
    }

    public String getLocation() {
            return location;
    }
}
