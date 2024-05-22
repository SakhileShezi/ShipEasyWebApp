<%-- 
    Document   : tracting_parcel
    Created on : Apr 26, 2024, 11:22:27 PM
    Author     : Shezi
--%>

<%@page import="ac.za.tut.shipment.Shipment"%>
<%@page import="ac.za.tut.status.Status"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tracking parcel Page</title>
        <link rel="stylesheet" href="css/tracking_parcel.css"/>
    </head>
    <body>
    <%
         Status status = (Status)session.getAttribute("status");
         Shipment shipment = (Shipment)session.getAttribute("shipment");
         
    %>
    <header>
    <a href="track_parcel.jsp"><img src="images/back_icon.png" alt="shipeasy-logo"></a>
    <nav class="links">
        <ul>
            <li><a href="user_menu.jsp">Home</a></li>
            <li><a href="track_parcel.jsp">Track Parcel</a></li>
            <li><a href="#">Help Centre</a></li>
        </ul>
    </nav>
</header>
    <div class="export_btn">
            <a href="parcel_tracking_pdf.jsp"><button>Export To PDF</button></a>
        </div>
    <center><h1>Tracking your parcel</h1></center>
    <div class="track">
        <center><h3>TRACKING PARCEL : <%=shipment.getProduct().getTrackingCode()%> </h3></center>
        <div class="List-status">

            <ul>
                <li>Shipped Via: <%=status.getShippingMethod()%> </li>
                <li>Status: <%=status.getStatus()%> </li>
                <li>Expected Date: <%=status.getDeliveryDate()%> </li>
            </ul>
        </div>
        <div class="ship-icon-motor">
            <img  src="images/pngwing.com.png" id="car" alt="motor">
        </div>
        <div class="Ship-stages">
            <ul>
                <!-- shipment stages -->
                <li>Shipment Confirmed</li>
                <li>Processing Shipment</li>
                <li>On Collection</li>
                <li>Checking Quality</li>
                <li>On Delivery</li>
                <li>Parcel Delivered</li>
            </ul>
        </div>
    </div>
    <script>
        var car = document.getElementById("car");
        var initialLeft = 50;
        var distanceToMove = 150;
        var duration = 5000;
        var delayBeforeMove = 2000;
        var delayAfterStop = 3000;
        var speed = distanceToMove / duration;
        var startTime = null;
        var isMoving = true;

        animate();

        function animate() {
            if (!isMoving) {
                setTimeout(function () {

                    startTime = performance.now();
                    isMoving = true;
                    requestAnimationFrame(moveCar);
                }, delayAfterStop);
                return;
            }

            moveCar();
        }

        function moveCar(timestamp) {
            if (!startTime)
                startTime = timestamp || performance.now();
            var elapsedTime = timestamp ? timestamp - startTime : 0;
            var newPosition = initialLeft + speed * elapsedTime;

            if (elapsedTime < duration) {
                car.style.left = newPosition + "px";
                requestAnimationFrame(moveCar);
            } else {

                car.style.left = (initialLeft + distanceToMove) + "px";
                isMoving = false;
            }
        }
    </script>

</body>
</html>
