<%-- 
    Document   : history-order
    Created on : Nov 5, 2017, 3:15:27 PM
    Author     : adyan
--%>

<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.PrOjekApp.RestAPIConsumer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        String token = request.getParameter("token");
        
        String API_URL = "http://localhost:8084/IdentityService/validate?";
        String URLParameters = "token="+ token;
        RestAPIConsumer rc = new RestAPIConsumer(API_URL, URLParameters);
        rc.executeGet();
        JSONObject jsonResponse = rc.getOutput();
//        out.print(jsonResponse.toString());

        if(!jsonResponse.get("status").toString().equals("valid")) {
            String Url = "login.jsp";
            response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", Url);
        };
    %>
<!--    <?php
        require('includes/config.php');

        $id_active = $_GET["id_active"];
        $sql = "SELECT * FROM users WHERE ID=$id_active LIMIT 1";

        $result = mysqli_query($conn, $sql);
        while($row = mysqli_fetch_assoc($result)) {
            $username = $row["username"];
        }
    ?>-->
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History</title>
        <link rel="stylesheet" type="text/css" href="css/history.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    </head>
    <style type="text/css">
        .menu a {
            text-decoration: none;
            color: inherit;
        }
        .submenu a {
            text-decoration: none;
            color: inherit;
        }
    </style>
    <body>
    	<div class="contentBox">
            <div class="mainHeader">
                    <div class="header1">
                            <div class="title"><span class="title green">PR</span>-<span class=" title red">OJEK</span></div>
                            <div class="subtitle">wush... wush... ngeeeeeenggg...</div>
                    </div>
                    <div class="header2">
                            <div class="username">Hi, <span class="username bold"><?php echo $username ?>!</span></div>
                            <div class="logout"><a href="login.jsp">Logout</a></div>
                    </div>
            </div>
            <div>
                    <div class="menu"><a href="orderojek.jsp?token=<%= token %>">ORDER</a></div>
                    <div class="menu active">HISTORY</div>
                    <div class="menu"><a href="profile.jsp?token=<%= token %>"  >MY PROFILE</a></div>
            </div>
            <h1>TRANSACTION HISTORY</h1>
            <div>
            	<div class="submenu active">MY PREVIOUS ORDERS</div>
            	<div class="submenu"><a href="history-driver.php?id_active=<?php echo $id_active ?>">DRIVER HISTORY</a></div>
            </div>

<!--            <?php
            $sql = "SELECT * FROM transaction JOIN users ON (transaction.id_driver=users.ID) WHERE transaction.id_user=". $id_active;
            $result = mysqli_query($conn,$sql);
            if (mysqli_num_rows($result) > 0) {
            // output data of each row
                $idx = 1;
                while($row = mysqli_fetch_assoc($result)) {
                    echo '<div class="listBox" id="' .$idx . '">';
                        $image = '<img src="' . $row['image'] . '" class="thumbnail">';
                        echo '<button class="buttonHide" onclick="hideElement(' .$idx . ')">HIDE</button>';
                        echo $image.'<div class="date">' . date('l', strtotime($row['time'])) . ', ' . date('F jS Y', strtotime($row['time'])) . '</div>';
                        echo '<div class="name"> ' . $row['name']. '</div>';
                        echo '<div class="route"> ' . $row['picking_point'] . '-' . $row['destination'] . '</div>';
                        echo '<div class="rating"> You rated: '; 
                                for ($x = 0; $x <= $row['rating']; $x++) {
                                echo '<i class="material-icons" style="font-size:12px; display:inline-block; color:yellow">star_border</i>';
                                } 
                            echo '</div>';
                        echo '<div class="comment"> You commented: </div>';
                        echo '<div class="comment">' . $row['comment'] . '</div>';
                    echo '</div>';
                    $idx++;
                }
            } else {
                echo "0 results";
            }
            $conn->close();
            ?>            -->
            
        </div>
        <script src="js/history.js" type="text/javascript"></script>
    </body>
</html>
