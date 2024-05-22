<%-- 
    Document   : enter_vehicle
    Created on : May 7, 2024, 5:19:16 PM
    Author     : Shezi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enter vehicle details Page</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                margin: 0;
                padding: 0;
            }
            header {
                color: #eee;
                width: 100%;
                display: flex;
                justify-content: space-between;
                background-color: lavender;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            }

            header img {
                height: 40px;
                width: auto;
                padding: 10px 10px;
                border-radius: 50px;
            }

            .links {
                display: flex;
                float: right;
                margin-right: 30px;
            }

            .links ul {
                display: flex;
                gap: 10px;
            }

            .links ul li {
                display: inline;
            }

            .links ul li a {
                text-decoration: none;
                color: black;
            }

            .links ul li a:hover {
                color: darkgray;
            }
            .container {
                max-width: 600px;
                margin: 20px auto;
                background-color: #fff;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            h1 {
                text-align: center;
            }

            .reg-container {
                margin-top: 20px;
            }

            label {
                font-weight: bold;
            }

            input[type="text"],
            select {
                width: 100%;
                padding: 10px;
                margin: 5px 0;
                box-sizing: border-box;
                border: 1px solid #ccc;
                border-radius: 5px;
            }

            input[type="file"] {
                margin-top: 5px;
            }

            input[type="submit"] {
                width: 100%;
                background-color: #4CAF50;
                color: white;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }

            input[type="submit"]:hover {
                background-color: #45a049;
            }
        </style>
    </head>
    <body>
        <header>
            <a href="driver_registration.jsp"><img src="images/back_icon.png" alt="shipeasy-logo"></a>
            <nav class="links">
                <ul>
                    <li><a href="index.html">HOME</a> </li>
                    <li><a href="#">ABOUT US</a></li>
                    <li><a href="#">CONTACT US</a></li>
                </ul>
            </nav>
        </header>
        <div class="container">
            <h1>Enter Vehicle Information below:</h1>
            <div class="reg-container">

                <form action="CreateDriverServlet.do" method="POST" enctype="multipart/form-data">

                    <label><b>Vehicle Identification Number (VIN)</b></label><br />
                    <input type="text" name="vin" placeholder="VIN" required=""><br />

                    <label><b>License Plate Number</b></label><br />
                    <input type="text" name="plate_number" placeholder="Plate Number" required=""><br />

                    <label><b>Model</b></label><br />
                    <input type="text" name="model" placeholder="Model/Make" required=""><br />

                    <label><b>Vehicle Type:</b></label>
                    <select name="vehicle_type">
                        <option value="Truck">Truck</option>
                        <option value="Van">Van</option>
                        <option value="Scooter">Scooter</option>
                        <option value="Ship">Ship</option>
                        <option value="Rail Car">Rail Car/Train</option>
                    </select><br><br>
                    <label>Driver license:</label><input type="file" name="license" accept="images/*" required=""><br>
                    <input type="submit" value="Complete Registration" ><br />
                </form>
            </div>
        </div>
    </body>
</html>
