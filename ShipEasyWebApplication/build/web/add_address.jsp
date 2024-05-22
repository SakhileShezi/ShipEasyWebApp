<%-- 
    Document   : add_address
    Created on : May 20, 2024, 3:24:24 AM
    Author     : Shezi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Add Address Page</title>
        <style>
            body {
                padding: 0;
                margin: 0;
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                flex-direction: column;
            }
            .container {
                position: relative;
                width: 100%;
                height: 100%;
                display: flex;
                justify-content: center;
                align-items: center;
            }
            img {
                position: absolute;
                width: 100%;
                height: 100%;
                object-fit: cover;
                z-index: -1;
            }
            header {
                color: #eee;
                width: 100%;
                height: 40px;
                display: flex;
                justify-content: space-evenly;
                align-items: center;
                box-shadow: 0 2px 5px rgba(0,0,0,0.5);
                padding: 15px 15px;
                background-color: rgba(0, 0, 0, 0.7);
                position: fixed;
                top: 0;
                left: 0;
                z-index: 2;
            }
            header img {
                height: 30px;
                width: auto;
                border-radius: 50px;
            }
            .links ul {
                display: flex;
                gap: 15px;
                list-style: none;
                padding: 0;
                margin: 0;
            }
            .links ul li a {
                text-decoration: none;
                color: #fff;
                opacity: 1;
            }
            .links ul li a:hover {
                color: darkgray;
            }
            .address_container {
                position: relative;
                border-radius: 10px;
                background-color: rgba(255, 255, 255, 0.9);
                background: transparent;
                box-shadow: 0 4px 8px rgba(0,0,0,1.3);
                padding: 20px;
                width: 500px;
                z-index: 1;
                margin-top: 70px;
            }
            form {
                padding: 30px;
                border-radius: 10px;
                background-color: white;
            }
            form h1 {
                margin-bottom: 20px;
                font-size: 24px;
                color: #333;
            }
            form label {
                font-weight: bold;
                color: #555;
                display: block;
                margin: 10px 0 5px;
            }
            form input[type="text"] {
                width: 100%;
                padding: 10px;
                margin: 5px 0 20px;
                border-radius: 5px;
                border: 1px solid #ccc;
                box-sizing: border-box;
            }
            form input[type="submit"] {
                padding: 10px 20px;
                background-color: #5cb85c;
                color: white;
                border-radius: 5px;
                border: none;
                cursor: pointer;
                transition: background-color 0.3s;
            }
            form input[type="submit"]:hover {
                background-color: #4cae4c;
            }
            .error_msg{
                padding: 0;
                margin: 0;
                color: red;
            }
            .error_msg p{
                color: red;
                font-size: 0.7em;
            }
            .error_msg a{
                color: green;
                text-decoration: none;
                font-size: 1em;
            }
            .error_msg a:hover{
                color: lawngreen;
            }
        </style>
    </head>
    <body>
        <%
            String errMsg = (String)request.getAttribute("errMsg");
        %>
        <header>
            <nav class="links">
                <ul>
                    <li><a href="profile.jsp">Back</a></li>
                    <li><a href="user_menu.jsp">Home</a></li>
                    <li><a href="#">Help</a></li>
                </ul>
            </nav>
        </header>
        <div class="container">
            <img src="images/address.png" alt="Shipping Routes">
            <div class="address_container">
                <form action="AddAddressServlet.do" method="POST">
                    <h1>Add Address</h1>
                    <label for="street_name">Street Name</label>
                    <input type="text" id="street_name" name="street_name" required>
                    <label for="address">Address Line 1</label>
                    <input type="text" id="address" name="address" required>
                    <label for="postal_code">Postal Code</label>
                    <input type="text" id="postal_code" name="postal_code" required>
                    <div class="error_msg">
                    <%if(errMsg != null){%>
                    <p><%=errMsg%> <a href="#">Update instead!</a></p>
                    <%}%>
                    </div><br />
                    <input type="submit" value="Add Address">
                </form>
            </div>
        </div>
    </body>
</html>
