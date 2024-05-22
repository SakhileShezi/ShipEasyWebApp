<%@page import="java.util.Base64"%>
<%@page import="ac.za.tut.vehicle.Vehicle"%>
<%@page import="ac.za.tut.driver.Driver"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm Driver Details</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f5f5f5;
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
                padding: 10px 0;
            }

            header img {
                height: 40px;
                width: auto;
                padding: 0 10px;
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
                font-weight: bold;
            }

            .links ul li a:hover {
                color: darkgray;
            }
            h1 {
                text-align: center;
                margin-top: 20px;
                color: #333;
            }
            p {
                text-align: center;
                margin: 10px 0;
                color: #666;
            }
            div {
                text-align: center;
                margin-top: 20px;
            }
            table {
                margin: 0 auto;
                border-collapse: collapse;
                width: 60%;
                border-radius: 20px;
                background-color: #fff;
                box-shadow: 0 2px 5px rgba(0,0,0,0.7);
            }
            th, td {
                padding: 15px;
                text-align: left;
                border-bottom: 1px solid #ddd;
                font-size: 16px;
            }
            th {
                background-color: #f2f2f2;
            }
            td img {
                max-width: 250px;
                height: 150px;
                display: block;
                margin-right: 30%;
            }
            input[type="submit"][value="Confirm"] {
                background-color: darkgreen;
                color: #fff;
                padding: 5px 10px;
                border: 2px solid black;
                border-radius: 5px;
                cursor: pointer;
                font-size: 16px;
                margin-top: 8px;
            }

            input[type="submit"][value="Confirm"]:hover{
                background-color: green;
            }

            input[type="submit"][value="Restart Process"] {
                background-color: lightslategray;
                color: #fff;
                padding: 5px 10px;
                border: 2px solid black;
                border-radius: 5px;
                cursor: pointer;
                font-size: 16px;
                margin-top: 8px;
            }

            input[type="submit"][value="Restart Process"]:hover {
                background-color: darkgray;
            }
            .bttns{
                justify-content: center;
                align-items: center;
                display: flex;
                flex-direction: row;
                gap: 10px;
            }


        </style>
    </head>
    <body>
        <%
            Driver driver = (Driver) session.getAttribute("driver");

            String image_source = "data:image/png;base64," + Base64.getEncoder().encodeToString(driver.getVehicle().getLicense());
        %>
        <header>
            <a href="enter_vehicle.jsp"><img src="images/back_icon.png" alt="shipeasy-logo"></a>
            <nav class="links">
                <ul>
                    <li><a href="index.html">HOME</a> </li>
                    <li><a href="#">ABOUT US</a></li>
                    <li><a href="#">CONTACT US</a></li>
                </ul>
            </nav>
        </header>
        <h1>Confirm Your Details</h1>
        <p>Below are your personal details. Please confirm if they are captured correctly.</p>
        <div >
            <table>
                <tr>
                    <th>Field</th>
                    <th>Details</th>
                </tr>
                <tr>
                    <td><b>Full Names:</b></td>
                    <td><%=driver.getFullNames()%></td>
                </tr>
                <tr>
                    <td><b>Surname:</b></td>
                    <td><%=driver.getSurname()%></td>
                </tr>
                <tr>
                    <td><b>Email Address:</b></td>
                    <td><%=driver.getEmail()%></td>
                </tr>
                <tr>
                    <td><b>Contact Number:</b></td>
                    <td><%=driver.getCellNumber()%></td>
                </tr>
                <tr>
                    <td><b>License:</b></td>
                    <td><img src="<%=image_source%>" alt="License"></td>
                </tr>

            </table>
                <div class="bttns">
                    
            <form action="login.jsp">
                <input type="submit" value="Confirm">
            </form>
            <form action="RestartRegistrationServlet.do" method="POST">
                <input type="submit" value="Restart Process">
            </form>
          </div>
        </div>

    </body>
</html>
