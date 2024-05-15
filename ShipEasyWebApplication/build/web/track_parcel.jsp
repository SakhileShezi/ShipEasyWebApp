<%-- 
    Document   : track_parcel
    Created on : Apr 23, 2024, 8:54:40 PM
    Author     : Shezi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Track parcel Page</title>
        <link rel="stylesheet" href="css/track_parcel.css"/>
    </head>
    <body>
        <%
            String errMsg = (String) request.getAttribute("errMsg");
            String trackingKey = (String) request.getAttribute("trackingKey");

            trackingKey = (trackingKey != null) ? trackingKey : "";

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
        <div class="tracking-box">

            <img src="images/track_parcel.jpg" alt="bg-image"/>
            <form action="TrackingServlet.do" method="POST">

                <input type="text" name="tracking_code" placeholder="Enter tracking code" required="" value="<%=trackingKey%>" <%if (errMsg != null) {%>class="red_border"<%}%>>
                <input type="submit" value="Submit">
                <div class="error_container">
                    <%if (errMsg != null) {%>
                       <p><b><%=errMsg%></b></p> 
                    <%}%>
                </div>
            </form>
        </div>
    </body>
</html>
