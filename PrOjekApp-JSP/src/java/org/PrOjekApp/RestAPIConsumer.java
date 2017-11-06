/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.PrOjekApp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author adyan
 */
public class RestAPIConsumer {
    private JSONObject output;
    private String API_URL;
    private String URLParameters;
    
    public RestAPIConsumer(String api_url, String url_parameters){
        API_URL = api_url;
        URLParameters = url_parameters.replace(" ", "%20");
        output = null;
    }
    
    public void executeGet() throws ParseException{
        try {
            String urlRequest = API_URL + URLParameters;
            URL url = new URL(urlRequest);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            StringBuilder sb = new StringBuilder();
            String temp;
            while((temp = br.readLine()) != null){
                sb.append(temp);
            }
            JSONParser parser = new JSONParser();
            output = (JSONObject) parser.parse(sb.toString());
        } catch (IOException | ParseException ex){
            ex.printStackTrace();
        }
    }
    
    public void executePost(){
        try {
            URL url = new URL(API_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            DataOutputStream dts = new DataOutputStream(conn.getOutputStream());
            dts.writeBytes(URLParameters);
            dts.flush();
            dts.close();
            conn.setReadTimeout(10000);
            conn.connect();
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            StringBuilder sb = new StringBuilder();
            String temp;
            while((temp = br.readLine()) != null){
                sb.append(temp);
            }
            JSONParser parser = new JSONParser();
            output = (JSONObject) parser.parse(sb.toString());
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
    }
    
    public JSONObject getOutput(){
        return output;
    }
}
