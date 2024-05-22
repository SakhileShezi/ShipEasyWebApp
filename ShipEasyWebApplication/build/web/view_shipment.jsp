<%@page import="ac.za.tut.shipment.Shipment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Shipment Page</title>
        <link rel="stylesheet" href="css/view_shipment.css"/>

    </head>
    <body>
        <%
            List<Shipment> shipments = (List<Shipment>) session.getAttribute("shipments");
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
        <div class="export_btn">
            <a href="export_to_pdf.jsp"><button>Export To PDF</button></a>
        </div>
        <div class="ship-container">
            <center><h1>Shipment Details</h1></center>
            <table>
                <tr>
                    <th><b>Pick up point</b></th>
                    <th><b>Type</b></th>
                    <th><b>Weight</b></th>
                    <th><b>Destination</b></th>
                    <th><b>Requested On</b></th>
                    <th><b>Price</b></th>
                    <th><b>Tracking Key</b></th>
                    <th><b>Edit Details</b></th>
                    <th><b>Actions</b></th>
                </tr>
                <%
                        for (int i = 0; i < shipments.size(); i++) {%>
                <tr>

                    <td><%=shipments.get(i).getPickLocation()%></td>
                    <td><%=shipments.get(i).getProduct().getType()%></td>
                    <td><%=shipments.get(i).getProduct().getWeight()%></td>
                    <td><%=shipments.get(i).getDestination()%></td>
                    <td><%=shipments.get(i).getCreationDate()%></td>
                    <td><%=shipments.get(i).getProduct().getPrice()%></td>
                    <td><%=shipments.get(i).getProduct().getTrackingCode()%></td>

                    <td>
                        <form action="EditShipmentServlet.do" method="POST">
                            <button name="edit" value="<%=shipments.get(i).getId()%>" >Edit</button>
                        </form>
                    </td>
                    <td>
                        <form action="DeleteShipmentServlet.do" method="GET">
                            <div class="btn-delete">
                                <button type="submit" name="delete" value="<%=shipments.get(i).getId()%>" >Delete</button>
                            </div> 
                        </form>
                    </td>
                    <%}%>
                </tr>
            </table>
        </div>
    </body>
</html>
