<%-- 
    Document   : register
    Created on : Apr 12, 2024, 7:42:03 PM
    Author     : Shezi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
        <link rel="stylesheet" href="css/registration.css"/>
    </head>
    <body>
        
        <%

            String errMsg = (String) request.getAttribute("errMsg");
            String passErrMsg = (String) request.getAttribute("passErrMsg");
            String passwordCriteriaErr = (String) request.getAttribute("passwordCriteriaErr");
            String userExist = (String) request.getAttribute("userExist");

            String name = (String) request.getAttribute("name");
            String surname = (String) request.getAttribute("surname");
            String email = (String) request.getAttribute("email");
            String phoneNumber = (String) request.getAttribute("phoneNumber");
            String dob = (String) request.getAttribute("dob");
            String password = (String) request.getAttribute("password");
            String confirmPassword = (String) request.getAttribute("confirmPassword");

            name = (name != null) ? name : "";
            surname = (surname != null) ? surname : "";
            email = (email != null) ? email : "";
            phoneNumber = (phoneNumber != null) ? phoneNumber : "";
            dob = (dob != null) ? dob : "";
            password = (password != null) ? password : "";
            confirmPassword = (confirmPassword != null) ? confirmPassword : "";


        %>
        <header>
            <a href="index.html"><img src="images/back_icon.png" alt="shipeasy-logo"></a>
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
            <h1>Register</h1> 
            <div class="reg-container">
                <form action="RegistrationServlet.do" method="POST">

                    <label><b>Name</b></label><br />
                    <input type="text" name="name" placeholder="First name.." required="" value="<%=name%>"><br />

                    <label><b>Surname</b></label><br />
                    <input type="text" name="surname" placeholder="Last name.." required="" value="<%=surname%>"><br />

                    <label><b>Birth date :</b></label>
                    <input type="date" name="dob" placeholder="Date of Birth" required="" value="<%=dob%>" ><br />

                    <label><b>Gender :</b></label>
                    <input type="radio" name="gender" value="Male" required="">Male<input type="radio" name="gender" value="Female" required="">Female<br />

                    <label><b>Email Address</b></label><br />
                    <input type="text" name="email" placeholder="user@gmail.com" required="" value="<%=email%>"><br />
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
                    <label><b>Contact number</b></label><br />
                    <input type="text" name="phone_number" placeholder="Phone number" required="" value="<%=phoneNumber%>"><br />

                    <label><b>Password</b></label><br />
                    <input type="password" name="password" placeholder="Password" required="" value="<%=password%>"><br />
                    <div class="error-msg">
                        <%
                        if (passwordCriteriaErr != null)
                        {%>
                        <p><%=passwordCriteriaErr%></p>
                        <%}%>
                    </div>
                    <div class="password_creteria">
                        <p>NB:Password must be at least 7 characters long, with 4 lowercase, 1 uppercase, a digit, and a special character.</p>
                    </div>
                    <label><b>Re-enter password</b></label><br />
                    <input type="password" name="confirmPassword" placeholder="Confirm password" required="" value="<%=confirmPassword%>" <%if (passErrMsg != null) {%> class="error-border" <%}%>><br />
                    <div class="error-msg">
                        <%
                            if (passErrMsg != null) {
                        %>
                        <p><%=passErrMsg%></p>
                        <%}%>
                    </div>
                    <input type="submit" value="Register">
                </form>
                <div class="sign-in">
                    <p>Already have an account?<a href="login.jsp">Sign in</a></p>
                    <hr />
                    <p>Ready to hit the road? Become a driver today! Click <a href="driver_registration.jsp">Here</a> to Sign up now.</p>
                </div>
            </div>
        </div>
    </center>
</body>
</html>
