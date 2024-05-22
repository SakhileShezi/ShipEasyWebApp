<%-- 
    Document   : driver_registration
    Created on : May 7, 2024, 12:23:17 AM
    Author     : Shezi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ShipEasy Driver's Registration Page</title>
        <style>
          body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
}

header {
    color: #eee;
    width: 100%;
    display: flex;
    justify-content: space-between;
    background-color: lavender;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

header img {
    height: 40px;
    width: auto;
    padding: 10px 10px;
    border-radius: 50px;
}

.links {
    display: flex;
    float: right;
    margin-right: 30px;
}

.links ul {
    display: flex;
    gap: 10px;
}

.links ul li {
    display: inline;
}

.links ul li a {
    text-decoration: none;
    color: black;
}

.links ul li a:hover {
    color: darkgray;
}

.image-container {
    background-size: cover;
    display: flex;
    justify-content: center;
    align-items: center;
    background: transparent;
}

.image-container img {
    border-radius: 100%;
    height: 150px;
    width: 150px;
    margin-left: 50px;
}

.reg_form_container {
    float: right;
    background-color: #fff;
    padding: 20px;
    border-radius: 5px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.4);
    background: transparent;
}

.reg_form_container input {
    width: 80%;
    margin-bottom: 5px;
}
.reg_form_container form {
    max-width: 400px;
    margin: auto;
}

.reg_form_container table {
    width: 100%;
}

.reg_form_container td {
    padding: 10px 0;
}

.reg_form_container input[type="text"],
.reg_form_container input[type="password"] {
  
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 3px;
    box-sizing: border-box;
}

.reg_form_container input[type="submit"] {
    width: 100%;
    padding: 10px;
    background-color: #4CAF50;
    color: white;
    border: none;
    border-radius: 3px;
    cursor: pointer;
}

.reg_form_container input[type="submit"]:hover {
    background-color: #45a049;
}
.error-msg p{
    color: red;
    font-size: 0.7em;
}
.error_border{
    border: 1px solid red;    
}
        </style>
    </head>
    <body>
        <%
            String errMsg = (String) request.getAttribute("errMsg");
            String passwordCriteriaErr = (String) request.getAttribute("passwordCriteriaErr");
            String userExist = (String) request.getAttribute("userExist");
            
            String name = (String) request.getAttribute("name");
            String surname = (String) request.getAttribute("surname");
            String email = (String) request.getAttribute("email");
            String contactNumber = (String) request.getAttribute("contactNumber");
            String password = (String) request.getAttribute("password");
            
           name = (name != null) ? name : "";
           surname = (surname != null) ? surname : "";
           email = (email != null) ? email : "";
           contactNumber = (contactNumber != null) ? contactNumber : "";
           password = (password != null) ? password : "";

        %>
        <header>
            <a href="register.jsp"><img src="images/back_icon.png" alt="shipeasy-logo"></a>
            <nav class="links">
                <ul>
                    <li><a href="index.html">HOME</a> </li>
                    <li><a href="#">ABOUT US</a></li>
                    <li><a href="#">CONTACT US</a></li>
                </ul>
            </nav>
        </header>
    <center>
        <h1>Welcome to ShipEasy's Driver Registration Page!</h1>
        <p style="color: #333">
            Are you ready to be part of our dedicated team of drivers?</p>
        <p style="color: #4CAF50">
           have a Copy/Clear image of your drivers license!</p>
        <p style="color: black">
            Fill in the form bellow and begin your journey towards becoming a ShipEasy driver.
        </p>
    </center>
    <div class="image-container">
        <img src="images/images.png" alt="image" height="350" width="250">
        <center>
            <div class="reg_form_container">
                <form action="GetDriverServlet.do" method="POST">
                    <table>
                        <tr>
                            <td><b>Full Names :</b></td>
                            <td><input type="text" name="full_names" placeholder="Full names" required="" value="<%=name%>"></td>
                        </tr>
                        <tr>
                            <td><b>Surname :</b></td>
                            <td><input type="text" name="surname" placeholder="Surname" required="" value="<%=surname%>"></td>
                        </tr>
                        <tr>
                            <td><b>Email :</b></td>
                            <td><input type="text" name="email" placeholder="smith@gmail.com" required="" value="<%=email%>"></td>
                            <div class="error-msg">
                        <%
                            if (errMsg != null) {
                        %>
                        <p><%=errMsg%></p>
                        <%}%>
                        <%
                            if (userExist != null) {
                        %>
                        <p><%=userExist%></p>
                        <%}%>

                    </div>
                        </tr>
                        <tr>
                            <td><b>Contact Number :</b></td>
                            <td><input type="text" name="cell_nr" placeholder="Phone number" required="" value="<%=contactNumber%>"></td>
                        </tr>
                        <tr>
                            <td><b>Password :</b></td>
                            <td><input type="password" name="password" placeholder="Password" value="<%=password%>" <%if (passwordCriteriaErr != null) {%> class="error_border" <%}%>></td>
                            <div class="error-msg">
                        <%
                            if (passwordCriteriaErr != null) {
                        %>
                        <p><%=passwordCriteriaErr%></p>
                        <%}%>
                    </div>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input type="submit" value="Continue"></td>
                        </tr>
                    </table>
                </form>
        </center>
    </div>
</div>
</body>
</html>
