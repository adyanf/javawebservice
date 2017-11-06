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

@XmlRootElement(name = "User")
public class User {
    @XmlElement(name = "ID", required = true)
    private int id;

    @XmlElement(name = "name", required = true)
    private String name;

    @XmlElement(name = "username", required = true)
    private String username;

    @XmlElement(name = "email", required = true)
    private String email;

    @XmlElement(name = "password", required = true)
    private String password;

    @XmlElement(name = "phone_number", required = true)
    private String phone_number;

    @XmlElement(name = "driver", required = true)
    private int driver;

    @XmlElement(name = "image", required = true)
    private String image;

    public User() {

    }

    public User(int id, String name, String username, String email, String password, String phone_number, int driver, String image) {
            this.id = id;
            this.name = name;
            this.username = username;
            this.email = email;
            this.password = password;
            this.phone_number = phone_number;
            this.driver = driver;
            this.image = image;
    }

    public int getId() {
            return id;
    }

    public String getName() {
            return name;
    }

    public String getUserName() {
            return username;
    }

    public String getEmail() {
            return email;
    }

    public String getPassword() {
            return password;
    }

    public String getPhoneNumber() {
            return phone_number;
    }

    public int getDriver() {
            return driver;
    }

    public String getImage() {
            return image;
    }
}
