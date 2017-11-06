/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.OjekOnlineService;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author adyan
 */
@WebService(serviceName = "OjekOnlineService")
public class OjekOnlineService {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "get_profile")
    public String get_profile(@WebParam(name = "token") String token) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "get_driver_locations")
    public String get_driver_locations(@WebParam(name = "token") String token) {
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
        //TODO write your implementation code here:
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
    public String get_order_hstory(@WebParam(name = "token") String token) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "get_driver_history")
    public String get_driver_history(@WebParam(name = "token") String token) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "get_preferred_driver")
    public String get_preferred_driver(@WebParam(name = "token") String token, @WebParam(name = "query") String query) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "get_not_preferred_driver")
    public String get_not_preferred_driver(@WebParam(name = "token") String token, @WebParam(name = "query") String query) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "get_all_driver")
    public String get_all_driver(@WebParam(name = "token") String token) {
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
