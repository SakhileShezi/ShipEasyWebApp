<%-- 
    Document   : profile
    Created on : Apr 22, 2024, 2:46:45 PM
    Author     : Shezi
--%>

<%@page import="ac.za.tut.user.User"%>
<<<<<<< HEAD
<%@page import="ac.za.tut.address.Address"%>
=======
>>>>>>> dd3e0be14ccfb211898bb09058ab81dc8862e11c
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile Page</title>
        <link rel="stylesheet" href="css/profile.css"/>
    </head>
    <%
        User user = (User) session.getAttribute("LoggedInUser");
<<<<<<< HEAD
        Address address = user.getAddress();
=======
>>>>>>> dd3e0be14ccfb211898bb09058ab81dc8862e11c
    %>

    <body>
        <header>
            <a href="user_menu.jsp"><img src="images/back_icon.png" alt="shipeasy-logo"></a>
        </header>
        <div class="container">

            <h1><%=user.getName()%> <%=user.getSurname()%></h1>
<<<<<<< HEAD
            <h2>Personal Details</h2>
            <table border="1">
                <tr>
                    <th><b>Name</b></th>
                    <th><b>Surname</b></th>
                </tr>
                <tr>
                    <td><%=user.getName()%></td>
                    <td><%=user.getSurname()%></td>
                </tr>
            </table>
            <h2>Contact Information</h2>
            <table border="1">
                <tr>
                    <th><b>Email address</b></th>
                    <th><b>Contact number</b></th>
                </tr>
                <tr>
                    <td><%=user.getEmail()%></td>
                    <td><%=user.getPhoneNumber()%></td>
                </tr>
            </table>
            <h2>Address</h2>

            <%if (address != null) {%>

            <table border="1">
                <tr>
                    <td><b>Street Name:</b></td>
                    <td><%=user.getAddress().getStreetName()%></td>
                </tr>
                <tr>
                    <td><b>Address line 1:</b></td>
                    <td><%=user.getAddress().getAddressLine1()%></td>
                </tr>
                <tr>
                    <td><b>Postal Code:</b></td>
                    <td><%=user.getAddress().getPostalCode()%></td>
                </tr>
            </table>
            <%}%>
            <div class="submit_form">
                <form action="add_address.jsp">
                    <input type="submit" value="Add Address">
                </form>
                <form action="update_user.jsp" method="POST">
                    <input type="submit" value="Update Details">
                </form>
            </div>

=======
            <form>
                <h3>Personal details:</h3>
                <table border="1">
                    <tr>
                        <th><b>Name</b></th>
                        <th><b>Surname</b></th>
                        <th><b>Actions</b></th>
                    </tr>
                    <tr>
                        <td><%=user.getName()%></td>
                        <td><%=user.getSurname()%></td>
                        <td><input type="submit" value="Update"></td>
                    </tr>
                </table>
                <h3>Contact info:</h3>
                <table border="1">
                    <tr>
                        <th><b>Email address</b></th>
                        <th><b>Contact number</b></th>
                        <th><b>Actions</b></th>
                    </tr>
                    <tr>
                        <td><%=user.getEmail()%></td>
                        <td><%=user.getPhoneNumber()%></td>
                        <td><input type="submit" value="Update"></td>
                    </tr>
                </table>
                <h3>Address info:</h3>
                <table border="1">
                    <tr>
                        <th><b>Name</b></th>
                        <th><b>Surname</b></th>
                        <th><b>Actions</b></th>
                    </tr>
                    <tr>
                        <td><%=user.getName()%></td>
                        <td><%=user.getSurname()%></td>
                        <td><input type="submit" value="Update"></td>
                    </tr>
                </table>
                <input type="submit" value="Add Address">
            </form>
>>>>>>> dd3e0be14ccfb211898bb09058ab81dc8862e11c
        </div> 
    </body>
</html>
