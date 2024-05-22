<%@page import="java.util.List"%>
<%@page import="ac.za.tut.shipment.Shipment"%>
<%@page import="ac.za.tut.driver.Driver"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Driver Home Page</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
            }
            header {
                background-color: #333;
                color: #fff;
                padding: 20px;
                text-align: center;
                display: flex;
                justify-content: space-between;
            }
            header img{
                width: 60px;
                height: 60px;
            }
            .header-links{
                display: flex;
                float: right;
                margin-right: 30px;
            }
            .header-links ul li {
                display: inline;
                gap: 10px;
            }
            .header-links ul
            {
                display: flex;
                gap: 10px;
            }

            .header-links ul li a{
                text-decoration: none;
                color: black;
                opacity: 1;
            }
            .header-links ul li a:hover{
                text-decoration: none;
                color: darkgray;
            }
            .nav-links{
                display: flex;
                float: left;
                margin-right: 30px;
                width: 100%;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.3);
            }
            .nav-links img {
                height: 40px;
                width: 40px;
            }
            .nav-links li:nth-child(2) img{
                border-radius: 100%;
            }
            .nav-links ul{
                display: flex;
                margin-left: 30px;
                gap: 30px;
            }
            .nav-links ul li{
                display: inline;
                gap: 30px;
            }
            main {
                padding: 20px;
                display: flex;
            }
            main{
                padding: 20px;
                display: flex;
                gap: 50px;
                flex-direction: row;
            }
            .Chat-box {
                padding: 5px;
                display: flex;
                box-shadow: 0 2px 5px rgba(0,0,0,1.3);
                height: 450px;
                width: 400px;
                border-radius: 10px;
                flex-direction: column;
            }
            .messages {
                box-shadow: 0 2px 5px rgba(0,0,0,0.3);
                width: 100%;
                height: 10%;
                float: top;
                border-radius: 5px;
                display: flex;
                justify-content: space-between;
            }
            .messages img{
                 height: 20px;
                 width: 20px;
                 padding: 0 5px;
                 margin-left: auto;
            }
            .messages ul {
                display: flex;
                gap: 2px;
            }
            .messages ul li{
                display: inline;
                gap: 2px;
            }
            section {
                margin-bottom: 20px;
            }
            .selection-container button{
                background-color: black;
                color: white;
                padding: 10px 15px;
                cursor: pointer;
                border-radius: 10px;
                border: 2px solid black;
                font-size: 16px;
                transition: background-color 0.3s ease;
            }
            .selection-container button:hover{
                background-color: #333;
            }

            footer {
                background-color: #333;
                color: #fff;
                text-align: center;
                padding: 10px 0;
                position: fixed;
                bottom: 0;
                width: 100%;
            }
        </style>
    </head>
    <body>
        <%
              Driver driver = (Driver)session.getAttribute("LoggedInDriver");
              List<Shipment> shipments = driver.getShipments();
              
        %>
        <header>
            <img src="images/pngwing.com.png" alt="">
            <h1>Welcome,ShipEasy Driver!</h1>
            <!-- Add any header content or navigation links here -->
            <nav class="header-links">
                <ul>
                    <li><a href="login.jsp">Logout</a></li>
                    <li><a href="#">Shipment</a></li>
                    <li><a href="profile.jsp">Profile</a></li>
                </ul> 
            </nav>
        </header>
        <nav class="nav-links">
            <ul>
                <li><a href="#"><img src="images/settings-icon2.jpg" alt=""></a></li>
                <li><a href="#"><img src="images/user-profile.jpg" alt=""></a></li>
                <li><a href="#"><img src="images/chats.jpg" alt=""></a></li>
                <li><a href="#"><img src="images/noti-icon_2.jpg" alt=""></a></li>
            </ul>
        </nav>

        <main>
            <div class="selection-container">

                <section>
                    <h2>Assigned Shipments</h2>
                    <a href="DriverAssinedShipmentServlet.do"><button>View Shipments</button></a>
                </section>
<<<<<<< HEAD
                <%if(!shipments.isEmpty()){%>
=======

>>>>>>> dd3e0be14ccfb211898bb09058ab81dc8862e11c
                <section>
                    <h2>Upcoming Deliveries</h2>
                    <!-- Display a list of upcoming deliveries -->
                    <ul>
                        <%
                            for (int i = 0; i < shipments.size(); i++) {
                        %>
                        <li>
                            <b>Delivery <%=i+1%></b> - <%=shipments.get(i).getStatus().getDeliveryDate()%>
                        </li>
                        <%}%>
                    </ul>
                </section>

                <section>
                    <h2>Routes</h2>
                    <!-- Display information about assigned routes -->
                    <ul>
                        
                     <%
                            for (int i = 0; i < shipments.size(); i++) {
                        %>
                        <li>
                            <b>Route <%=i+1%></b> - From <b><%=shipments.get(i).getPickLocation()%></b> to <b><%=shipments.get(i).getDestination()%></b>
                        </li>
                        <%}%>
                    </ul>
                    <!-- Add more routes as needed -->
                </section>
<<<<<<< HEAD
              <%}%>
=======
              
>>>>>>> dd3e0be14ccfb211898bb09058ab81dc8862e11c
            </div>
            <div class="Chat-box">
                <div class="messages">
                    <p><b>Messages</b></p>
                       <ul>
                          <li><a href="#"><img src="images/settings-icon2.jpg" alt=""></a></li>
                          <li><a href="#"><img src="images/search-icon.jpg" alt=""></a></li>
                       </ul>
                  </div>
                <p></p>
            </div>
        </main>
        <footer>
            <!-- Add any footer content or links here -->
            <p>&copy; 2024 ShipEasy</p>
            <hr />
        </footer>
    </body>
</html>
