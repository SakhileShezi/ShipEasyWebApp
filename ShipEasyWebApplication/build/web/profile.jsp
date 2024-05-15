<%-- 
    Document   : profile
    Created on : Apr 22, 2024, 2:46:45 PM
    Author     : Shezi
--%>

<%@page import="ac.za.tut.user.User"%>
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
    %>

    <body>
        <header>
            <a href="user_menu.jsp"><img src="images/back_icon.png" alt="shipeasy-logo"></a>
        </header>
        <div class="container">

            <h1><%=user.getName()%> <%=user.getSurname()%></h1>
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
        </div> 
    </body>
</html>
