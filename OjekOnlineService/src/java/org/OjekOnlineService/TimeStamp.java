/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.OjekOnlineService;

import static com.oracle.jrockit.jfr.ContentType.Timestamp;
import java.sql.Timestamp;
import java.util.Calendar;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adyan
 */
@XmlRootElement(name="TimeStamp")
public class TimeStamp {
    @XmlElement(name="date", required=true)
    private String date;
    
    public TimeStamp(){
        
    }
    public TimeStamp(Timestamp t){
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(t.getTime());
        date = "" + c.getTime().toString();
    }
    
    public String getDate(){
        return date;
    }
}
