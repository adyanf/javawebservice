<%-- 
    Document   : login
    Created on : Nov 5, 2017, 3:13:19 PM
    Author     : adyan
--%>

<%@page import="org.json.simple.parser.JSONParser"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.URLConnection"%>
<%@page import="java.net.URL"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Halaman Login</title>
        <link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet">
        <link rel="stylesheet" href="css/auth.css">
        <script src="js/validation.js"></script>
    </head>
    <body>
        <div class="apps">
            <div class="form-heading">
                <div class="heading-left">
                    <hr>
                </div>
                <div class="heading-title">
                    LOGIN  
                </div>
                <div class="heading-right">
                    <hr>
                </div>
            </div>
            <div class="form-login">
                <form action="http://localhost:8084/IdentityService/login" method="POST" autocomplete="off" onsubmit="return validateLogin()" name="login">
                    <div class="form-group">
                        <label for="username">Username </label>                            
                        <input id="username" type="text" name="username" placeholder="your username">
                    </div>
                    <div class="form-group">
                        <label for="password">Password </label>                            
                        <input id="password" type="password" name="password" placeholder="your password" pattern=".{5,10}" title="5 to 10 characters">                        
                    </div>
                    <div class="action">
                        <div class="register">
                            <a href="signup.php">Don't have an account ?</a>
                        </div>
                        <div class="submit">
                            <input type="submit" name="submit" value="GO!">                            
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
