<%-- 
    Document   : login
    Created on : Apr 13, 2024, 2:40:45 PM
    Author     : Shezi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" href="css/loginPage.css"/>

    </head>
    <body>
        <%
            String incorrectPasswordErr = (String) request.getAttribute("incorrectPasswordErr");
            String userNotFoud = (String) request.getAttribute("userNotFoud");
            
            String username = (String) request.getAttribute("username");
            String password = (String) request.getAttribute("password");
            
            username = (username != null) ? username : "";
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
        <div class="container">
            <fieldset>
                <legend><b>User login</b></legend>  
                <h1>Login</h1> 
                <div class="login-container">
                    <form action="LoginServlet.do" method="POST">
                        <label><b>Username</b></label><br />
                        <input type="text" name="username" placeholder="Username" required="" value="<%=username%>"><br />
                        <div class="error-msg">
                            <%
                                 if (userNotFoud != null) {
                            %>
                            <p><%=userNotFoud%></p>

                            <% } %>
                        </div>
                        <label><b>Password</b></label><br />
                        <input type="password" name="password" placeholder="Password" required="" value="<%=password%>"><br />
                        <div class="error-msg">
                            <%
                                 if (incorrectPasswordErr != null) {
                            %>
                            <p><%=incorrectPasswordErr%></p>

                            <% } %>
                        </div>
                        <input type="submit" value="Login">
                    </form>
                    <hr />
                    <div class="sign-up-option">
                        <p>sign-in with</p>
                        <ul>
                            <li>
                                <a href="#"><img src="images/social/facebook.png" alt="facebook-sign-up"></a>
                            </li>
                            <li>
                                <a href="#"><img src="images/social/google.jpg" alt="facebook-sign-up"></a>
                            </li>
                        </ul>

                    </div>
                    <hr />
                    <div class="sign-up">
                        <p>New to ShipEasy? <a href="register.jsp">Sign up</a></p>
                    </div>
                    <div class="forgot-password">
                        <a href="change_password.jsp">Forgot Password?</a>
                    </div>

                </div>
            </fieldset>
        </div>
    </center>
</body>
</html>
