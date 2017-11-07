/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.OjekOnlineService;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.sql.Connection;
import org.json.simple.JSONObject;

/**
 *
 * @author adyan
 */
@WebService(serviceName = "OjekOnlineService")
public class OjekOnlineService {
    Connection conDB = ConnectDBOjekOnline.getConnection();
    /**
     * Web service operation
     */
    @WebMethod(operationName = "get_profile")
    public User get_profile(@WebParam(name = "token") String token) {
        String API_URL = "http://localhost:8084/IdentityService/userprofile?";
        String URLParameters = "token="+ token;
        RestAPIConsumer rc = new RestAPIConsumer(API_URL, URLParameters);
        rc.executePost();
        JSONObject jsonResponse = rc.getOutput();
        
        int user_id = Integer.parseInt((String)jsonResponse.get("user_id"));
        String username = (String)jsonResponse.get("username");
        String name = (String)jsonResponse.get("name");
        String email = (String)jsonResponse.get("email");
        String password = (String)jsonResponse.get("password");
        String phone_number = (String)jsonResponse.get("phone_number");
        int driver = Integer.parseInt((String)jsonResponse.get("driver"));
        String image = (String)jsonResponse.get("image");
        
        User output = new User(user_id, name, username, email, password, phone_number, driver, image);
        //TODO write your implementation code here:
        return output;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "get_driver_locations")
    public Driver get_driver_locations(@WebParam(name = "token") String token) {
        String API_URL = "http://localhost:8084/IdentityService/validate?";
        String URLParameters = "token="+ token;
        RestAPIConsumer rc = new RestAPIConsumer(API_URL, URLParameters);
        rc.executePost();
        JSONObject jsonResponse = rc.getOutput();
        
        int user_id = Integer.parseInt((String)jsonResponse.get("user_id"));
        
        String name = (String)jsonResponse.get("name");
        
        //Driver  output = new Driver(user_id);
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "update_profile")
    public String update_profile(@WebParam(name = "token") String token, @WebParam(name = "name") String name, @WebParam(name = "phone") String phone, @WebParam(name = "image") String image, @WebParam(name = "driver") int driver) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "add_driver_location")
    public String add_driver_location(@WebParam(name = "token") String token, @WebParam(name = "location") String location) {
        
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "update_driver_location")
    public String update_driver_location(@WebParam(name = "token") String token, @WebParam(name = "oldLocation") String oldLocation, @WebParam(name = "newLocation") String newLocation) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "get_order_hstory")
    public ArrayList<Transaction> get_order_hstory(@WebParam(name = "token") String token) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "get_driver_history")
    public ArrayList<Transaction> get_driver_history(@WebParam(name = "token") String token) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "get_preferred_driver")
    public ArrayList<Driver> get_preferred_driver(@WebParam(name = "token") String token, @WebParam(name = "query") String query) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "get_not_preferred_driver")
    public ArrayList<Driver> get_not_preferred_driver(@WebParam(name = "token") String token, @WebParam(name = "query") String query) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "get_all_driver")
    public ArrayList<Driver> get_all_driver(@WebParam(name = "token") String token) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "add_order")
    public String add_order(@WebParam(name = "token") String token, @WebParam(name = "idDriver") int idDriver, @WebParam(name = "comment") String comment, @WebParam(name = "rating") int rating) {
        //TODO write your implementation code here:
        return null;
    }
}
