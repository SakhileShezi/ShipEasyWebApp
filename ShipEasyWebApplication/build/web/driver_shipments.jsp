<%-- 
    Document   : driver_shipments
    Created on : May 13, 2024, 3:55:38 AM
    Author     : Shezi
--%>

<%@page import="java.util.List"%>
<%@page import="ac.za.tut.shipment.Shipment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Driver assigned shipment Page</title>
        <style>
            body {
                font-family: sans-serif;
                margin: 0;
                padding: 0;
            }
            header {
                background-color: #333;
                color: #fff;
                padding: 10px 20px;
            }

            header img {
                height: 40px;
                width: 40px;
                border-radius: 50px;
                margin-left: 10px;
                border-radius: 100%;
            }

            table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
            }

            th, td {
                border: 1px solid #ddd;
                padding: 8px;
                text-align: left;
            }

            th {
                background-color: #333;
            }
            .btn_take_actions{
                display: flex;
                gap: 5px;
            }
            .btn_take_actions button{
                background-color: navy;
                color: white;
                padding: 4px 8px;
                cursor: pointer;
                border-radius: 5px;
                border: 2px solid black;
                font-size: 16px;
                transition: background-color 0.3s ease;
            }
            .btn_take_actions button:hover {
                background-color: blue;
            }
            button{
                background-color: #333;
                color: white;
                padding: 4px 8px;
                cursor: pointer;
                border-radius: 5px;
                border: 2px solid black;
                font-size: 16px;
                transition: background-color 0.3s ease;
            }

            button:hover {
                background-color: #666;
            }

            a {
                text-decoration: none;
                color: #333;
            }

            a:hover {
                color: #cc4125;
            }
            .ship-container table tr:nth-child(even) {
                background-color: darkgray;
            }

            .ship-container table tr:nth-child(odd) {
                background-color: #ffffff;
            }
            .ship-container table img{
                border-radius: 100%;
            }
        </style>
    </head>
    <body>
        <%
            List<Shipment> shipments = (List<Shipment>) session.getAttribute("driversSipments");
        %>
        <header>
            <a href="driver_home.jsp"><img src="images/back_icon.png" alt="shipeasy-logo"></a>
        </header>
        <div class="ship-container">
            <center><h1>Assigned Shipment Details</h1></center>
            <table>
                <tr>
                    <th><b>Pick up point</b></th>
                    <th><b>Type</b></th>
                    <th><b>Weight(kg)</b></th>
                    <th><b>Destination</b></th>
                    <th><b>Shipper</b></th>
                    <th><b>Status</b></th>
                    <th><b>Collection Report</b></th>
                    <th><b>Delivery Report</b></th>
                </tr>
                <%
                        for (int i = 0; i < shipments.size(); i++) {%>
                <tr>

                    <td><%=shipments.get(i).getPickLocation()%></td>
                    <td><%=shipments.get(i).getProduct().getType()%></td>
                    <td><%=shipments.get(i).getProduct().getWeight()%></td>
                    <td><%=shipments.get(i).getDestination()%></td>

                    <td>
                        <a href="#"><img src="images/user-profile.jpg" height="25px" width="25px" alt=""></a>
                    </td>
                    <td>
                            <div class="btn_take_actions">
                        <form action="ViewCurrentStatusServlet.do" method="POST">
                                <button type="submit" name="current_status" value="<%=shipments.get(i).getId()%>" >View Status</button>
                        </form>
                        <form action="GetShipmentServlet.do" method="POST">
                                <button type="submit" name="update_status" value="<%=shipments.get(i).getId()%>" >Update Status</button>
                        </form>
                            </div>
                        
                    </td>
                    <td>
                        <form action="CollectionReportServlet.do" method="POST">
                                <button type="submit" name="collection_report" value="<%=shipments.get(i).getId()%>" >Download</button>
                        </form>
                    </td>
                    <td>
                        <form action="DeliveryReportServlet.do" method="POST">
                                <button type="submit" name="delivery_report" value="<%=shipments.get(i).getId()%>" >Download</button>
                        </form>
                    </td>
                    <%}%>
                </tr>
            </table>
        </div>
    </body>
</html>
