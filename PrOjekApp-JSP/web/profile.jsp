<%-- 
    Document   : profile
    Created on : Nov 5, 2017, 3:13:47 PM
    Author     : adyan
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.PrOjekApp.RestAPIConsumer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        String token = request.getParameter("token");
        
        if (request.getParameter("logout") != null){
            String API_URL = "http://localhost:8084/IdentityService/logout?";
            String URLParameters = "token="+ token;
            RestAPIConsumer rc = new RestAPIConsumer(API_URL, URLParameters);
            rc.executeGet();
            JSONObject jsonResponse = rc.getOutput();
            
            String status = (String)jsonResponse.get("status");
            String message = (String)jsonResponse.get("message");
            response.sendRedirect("http://localhost:8084/PrOjekApp-JSP/login.jsp?message="+ message);
        }

        org.ojekonlineservice.OjekOnlineService_Service service = new org.ojekonlineservice.OjekOnlineService_Service();
        org.ojekonlineservice.OjekOnlineService port = service.getOjekOnlineServicePort();
        String username = "";
        String name = "";
        String email = "";
        String phone_number = "";
        String image = "";
        int driver = 0;
        try {
             // TODO initialize WS operation arguments here
            org.ojekonlineservice.User result = port.getProfile(token);
            username = result.getUsername();
            name = result.getName();
            email = result.getEmail();
            phone_number = result.getPhoneNumber();
            image = result.getImage();
            driver = result.getDriver();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (driver == 1){
            ArrayList<String> location = null;
            int total_rating = 0;
            int total_passanger = 0;
            try {
                org.ojekonlineservice.Driver resultDriver = port.getDriverLocations(token);
                out.println("Result = "+resultDriver);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" href="css/history.css">
        <style>
        .my-profile{
            width: 100%;
            margin: 0 auto;
        }
        .my-profile a, .location a {
            color: orange;
            
        }
        .my-profile .heading {
            float: left;
        }
        .my-profile .edit {
            float: right;
            margin-top: 15px;
            margin-right: 50px;
        }
        .my-profile .edit i {
            font-size: 2.2em;
        }
        .location{
            width: 100%;
            margin: 0 auto;
        }
        .location .heading {
            float: left;
        }
        .location .edit {
            float: right;
            margin-top: 15px;
            margin-right: 50px;
        }
        .location .edit i {
            font-size: 2.2em;
        }
        .profile-image {
            clear: right;
            margin: 0 auto;
        }
        .profile-image .rounded-picture {
            width: 120px;
            height: 120px;
            border-radius: 60px;
            margin-top: 10px;
        }
        .description {
            margin: 0 auto;
            margin-right: 50px;
            text-align: center;
        }
        .description p {
            margin: 1px auto;
        }
        .description h3 {
            margin: 8px auto;
        }
        .location-list{
            clear: right;
        }
        .location-list ul{
            padding-left: 0px;
        }
        .location-list ul li{
            text-align: left;
            clear: both;
            list-style-type: none;
        }
        .location-list ul li i {
            font-size: 20px;
        }
        .location-list ul li span {
            font-size:20px;
        }
        .menu a {
            text-decoration: none;
            color: inherit;
        }
        
        </style>

    </head>
    <body>
    	<div class="contentBox">
            <div class="mainHeader">
                    <div class="header1">
                            <div class="title"><span class="title green">PR</span>-<span class=" title red">OJEK</span></div>
                            <div class="subtitle">wush... wush... ngeeeeeenggg...</div>
                    </div>
                    <div class="header2">
                            <div class="username">Hi, <span class="username bold"><%= username %>!</span></div>
                            <div class="logout"><a href="/PrOjekApp-JSP/profile.jsp?token=<%= token %>&logout=true">Logout</a></div>
                    </div>
            </div>
            <div>
                    <div class="menu"><a href="orderojek.jsp?token=<%= token %>">ORDER</a></div>
                    <div class="menu"><a href="history-order.jsp?token=<%= token %>">HISTORY</a></div>
                    <div class="menu active">MY PROFILE</div>
            </div>
            <div class="my-profile">
                <h1 class="heading">MY PROFILE</h1>
                <a href="editprofile.jsp?token=<%= token %>"><span class="edit"><i class='material-icons'>mode_edit</i></span></a>
            </div>
            <div class="profile-image">
                <img class="rounded-picture" src="<%= image %>" alt="profile image">
            </div>
            <div class="description">
                <h3>@<%= username %></h3>
                <p><%= name %></p>
                <%
                    if (driver == 1){
                        out.println("<p>Driver</p>");
                    }
                %>
                <!--                
<?php if ($driver == 1){
                    $rating = ($total_passangers == 0) ? 0 : $total_rating/$total_passangers; 
                    echo "<p>Driver | <span>". $rating . "</span> (". $total_passangers ." votes)</p>" ;
                } ?>-->
                <p><%= email %></p>
                <p><%= phone_number %></p>
            </div>
<!--            <?php if ($driver == 1){ ?>-->
                <div class="location">
                    <h2 class="heading">PREFERRED LOCATION</h2>
                    <a href="editpreferredlocations.jsp?token=<%= token %>"><span class="edit"><i class='material-icons'>mode_edit</i></span></a>
<!--                    
                </div>
<!--            <?php } ?>-->
        </div>
        <script src="js/history.js" type="text/javascript"></script>
    </body>
</html>

