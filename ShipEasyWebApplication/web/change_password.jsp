<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Update password page</title>
        <link rel="stylesheet" href="css/change_password.css"/>
    </head>
    <body>
        <%

            String userNotFound = (String) request.getAttribute("userNotFound");
            String passwordErr = (String) request.getAttribute("passwordErr");

            String email = (String) request.getAttribute("email");
            String newPassword = (String) request.getAttribute("newPassword");
            String confirmNewPassword = (String) request.getAttribute("confirmNewPassword");

            email = (email != null) ? email : "";
            newPassword = (newPassword != null) ? newPassword : "";
            confirmNewPassword = (confirmNewPassword != null) ? confirmNewPassword : "";

        %>
        <header>
            <a href="login.jsp"><img src="images/back_icon.png" alt="shipeasy-logo"></a>
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
            <h2>Change Password</h2>
            <form action="UpdatePasswordServlet.do" method="POST">

                <label ><b>Email Address</b></label>
                <input type="email" name="email" placeholder="user@gmail.com" required="" value="<%=email%>"><br>
                <div class="error_msg">
                    <%
                        if (userNotFound != null)
                        {%>
                    <p><%=userNotFound%></p>
                    <%}%>
                    
                </div>
                <label ><b>New Password</b></label>
                <input type="password" name="newPassword" placeholder="enter new password" required="" value="<%=newPassword%>"><br>

                <label><b>Confirm Password</b></label>
                <input type="password" name="confirmNewPassword" placeholder="confirm password" required="" value="<%=confirmNewPassword%>"<%if (passwordErr != null) {%> class="red_border"<%}%> ><br>
                <div class="error_msg">
                    <%if (passwordErr != null) {%>
                    <p><%=passwordErr%></p>
                    <%}%>
                </div>
                <input type="submit" value="Update Password">

            </form>
        </div>
    </center>
</body>
</html>
