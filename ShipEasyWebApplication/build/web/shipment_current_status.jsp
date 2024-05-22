<%-- 
    Document   : driver_shipments
    Created on : May 13, 2024, 3:55:38 AM
    Author     : Shezi
--%>

<%@page import="ac.za.tut.shipment.Shipment"%>
<%@page import="ac.za.tut.status.Status"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Current Status Page</title>
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
        </style>
    </head>
    <body>
        <%
            Status status = (Status)session.getAttribute("status");
            Shipment shipment =(Shipment)session.getAttribute("shipment");
        %>
        <header>
            <a href="driver_shipments.jsp"><img src="images/back_icon.png" alt="shipeasy-logo"></a>
        </header>
        <div class="ship-container">
            <center><h1>Current Status</h1></center>
            <table>
                <tr>
                    <th><b>Transportation</b></th>
                    <th><b>Shipping Type</b></th>
                    <th><b>State/Stage</b></th>
                    <th><b>Next State</b></th>
                    <th><b>Estimated Delivery Date</b></th>
                    <th><b>Update Status</b></th>
                </tr>
                <tr>
                    <td><%=status.getTransportationMode()%></td> 
                    <td><%=status.getShippingMethod()%></td> 
                    <td><%=status.getStatus()%></td> 
                    <td><%=status.getFutureStatus()%></td> 
                    <td><%=status.getDeliveryDate()%></td> 
                    <td>
                            <div class="btn_take_actions">
                        <form action="GetShipmentServlet.do" method="POST">
                                <button type="submit" name="update_status" value="<%=shipment.getId()%>" >Update Status</button>
                        </form>
                            </div>
                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>
