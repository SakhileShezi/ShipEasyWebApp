<%-- 
    Document   : menu
    Created on : Apr 21, 2024, 4:27:22 PM
    Author     : Shezi
--%>

<%@page import="ac.za.tut.user.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User menu Page</title>
        <link rel="stylesheet" href="css/user_menu.css"/>
    </head>
    <body>
        <%
           User user = (User)session.getAttribute("LoggedInUser");
        %>
        <header>
            <h1>ShipEasy</h1>
            <nav class="links">
                <ul>
                    <li><a href="login.jsp">Logout</a></li>
                    <li><a href="#">Shipment</a></li>
                    <li><a href="profile.jsp">Profile</a></li>
                    <li><a href="#">Join us</a></li>
                </ul> 
            </nav>
        </header>
        <div class="welcome">
            <center><h1>Welcome to ShipEasy!!</h1></center>
            <a href="profile.jsp"><img src="images/user-profile.jpg" alt="imag"/></a>
            <h3><%=user.getName()%> <%=user.getSurname()%></h3>
            <p><%=user.getEmail()%></p>
        </div>
        <div class="user-profile">
            <h1>Request shipment</h1>
            <div class="inner-profile-container">
                
            <a href="create_shipment.jsp"><input type="submit" value="Request shipment"></a>
            <form action="ViewShipmentServlet.do" method="GET">
               <input type="submit" value="View shipment">
            </form>
            <a href="track_parcel.jsp"><input type="submit" value="Track Parcel"></a>
            </div>
        </div>
        <footer>
    <div class="logistic-courier-phrases">
        <p>Speedy Deliveries, Every Time</p>
        <p>Efficiency in Motion</p>
        <p>On Time, Every Time</p>
        <p>Reliable Logistics Solutions</p>
        <p>Global Reach, Local Touch</p>
        <p>Streamlined Shipping Services</p>
    </div>
</footer>
    </body>
</html>
