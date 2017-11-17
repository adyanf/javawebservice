<%-- 
    Document   : editpreferredlocations
    Created on : Nov 5, 2017, 3:14:17 PM
    Author     : adyan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Profile</title>
        <link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">        
        <link rel="stylesheet" href="css/profile.css">
    </head>
    <body>
        <div class="apps">
            <div class="heading">
                <h2>EDIT PREFERRED LOCATIONS</h2>
            </div>
            <table border="1" class="data-location">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Location</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
<!--                    <?php 
                    $i = 1;
                    while($row = mysqli_fetch_assoc($result)) {
                        $location = $row["location"];
                        echo "
                        <tr>
                            <td>". $i ."</td>
                            <td><input type='text' value='". $location ."' disabled></td>
                            <td><span class='edit'><i class='material-icons' onclick='editLocation(this)'>mode_edit</i></span><span class='delete'><i class='material-icons' onclick='deleteLocation(this)'>delete</i></span></td>
                        </tr>
                        ";
                        $i += 1;
                    } ?>-->
                </tbody>
            </table>
            <div class="add-location">
                <h3>ADD NEW LOCATION</h3>
                <form action="" method="post">
                    <input type="text" name="location" required>
                    <input type="submit" name="submit" value="ADD">
                </form>
            </div>
            <div class="back">
                <a href="<?php echo 'profile.php?id_active=' . $id_active ?>">BACK</a>
            </div>
        </div>
        <script src="js/editlocation.js"></script>
    </body>
</html>
