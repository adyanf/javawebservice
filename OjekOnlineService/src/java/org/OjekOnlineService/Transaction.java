/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.OjekOnlineService;

import java.sql.Timestamp;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adyan
 */
@XmlRootElement(name = "Transaction")
public class Transaction {
    @XmlElement(name = "ID", required = true)
    private int id;

    @XmlElement(name = "id_user", required = true)
    private int id_user;

    @XmlElement(name = "id_driver", required = true)
    private int id_driver;

    @XmlElement(name = "rating", required = true)
    private int rating;

    @XmlElement(name = "comment", required = true)
    private String comment;

    @XmlElement(name = "date", required = true)
    private TimeStamp date;

    @XmlElement(name = "picking_point", required = true)
    private String picking_point;

    @XmlElement(name = "destination", required = true)
    private String destination;

    public Transaction() {

    }

    public Transaction(int id, int id_user, int id_driver, int rating, String comment, Timestamp date, String picking_point, String destination) {
            this.id = id;
            this.id_user = id_user;
            this.id_driver = id_driver;
            this.rating = rating;
            this.comment = comment;
            this.date = new TimeStamp(date);
            this.picking_point = picking_point;
            this.destination = destination;
    }

    public int getId() {
            return id;
    }

    public int getIdUser() {
            return id_user;
    }

    public int getIdDriver() {
            return id_driver;
    }

    public int getRating() {
            return rating;
    }

    public String getComment() {
            return comment;
    }

    public TimeStamp getDate() {
            return date;
    }

    public String getPickingPoint() {
            return picking_point;
    }

    public String getDestination() {
            return destination;
    }
}
