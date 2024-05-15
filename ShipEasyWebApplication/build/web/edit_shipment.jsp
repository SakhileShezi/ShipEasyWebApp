<%@page import="ac.za.tut.shipment.Shipment"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Create Shipment Page</title>
    <link rel="stylesheet" href="css/create_shipment.css"/>
</head>
<body>
    <%
        Shipment shipment = (Shipment)session.getAttribute("shipment");
    %>
<header>
    <a href="user_menu.jsp"><img src="images/back_icon.png" alt="shipeasy-logo"></a>
    <nav class="links">
        <ul>
            <li><a href="user_menu.jsp">Home</a></li>
            <li><a href="track_parcel.jsp">Track Parcel</a></li>
            <li><a href="#">Help Centre</a></li>
        </ul>
</header>
<center>
    <div class="container">
        <h1>Enter new shipment details here</h1>
        <form action="UpdateShipmentServlet.do" method="GET">
           
            <label>Pick up location:</label>
            <input type="text" name="pick_up_location" placeholder="<%=shipment.getPickLocation()%>" required><br>
           
            <label>Destination location:</label>
            <input type="text" name="destination" placeholder="<%=shipment.getDestination()%>" required><br>
            
            <label>Weight (kg):</label>
            <input type="number" name="weight" placeholder="<%=shipment.getProduct().getWeight()%>" required><br>
           
            <label>Type:</label>
            <select name="shipmentType">
                <option value="Package">Package</option>
                <option value="Pallet">Pallet</option>
                <option value="Container">Container</option>
            </select><br>
         
            <input type="submit" value="Submit Request">
       
        </form>
        
    </div>
</center>
</body>
</html>