<%@page import="ac.za.tut.user.User"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update user Page</title>
    <style>
        body {
            margin: 0;
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            min-height: 100vh;
        }
        .container {
            width: 100%;
            max-width: 1200px;
            padding: 20px;
            margin: auto;
        }
        header {
            width: 100%;
            background-color: rgba(0, 0, 0, 0.7);
            color: #eee;
            padding: 10px;
            display: flex;
            justify-content: space-between;
        }
        header .links ul {
            display: flex;
            list-style: none;
            gap: 15px;
            padding: 0;
            margin: 0;
        }
        header .links ul li a {
            color: #fff;
            text-decoration: none;
            transition: color 0.3s;
        }
        header .links ul li a:hover {
            color: darkgray;
        }
        .address_container {
            background-color: rgba(255, 255, 255, 0.1);
            box-shadow: 0 4px 8px rgba(0, 0, 0, 1.3);
            border-radius: 10px;
            padding: 10px;
            width: 100%;
            max-width: 500px;
            margin: 40px auto 0;
        }
        form {
            padding: 20px;
            background-color: #fff;
            border-radius: 10px;
        }
        form h1 {
            color: #333;
        }
        form label {
            font-weight: bold;
            color: #555;
            display: block;
            padding: 5px;
        }
        form input[type="text"] {
            width: 100%;
            padding: 5px;
            border: 1px solid #ccc;
            box-sizing: border-box;
            transition: border-color 0.3s;
        }
        form input[type="text"]:focus {
            border-color: #5cb85c;
        }
        .submit_form {
            display: flex;
            flex-direction: row;
            gap: 10px;
        }
        .submit_form input[type="submit"],
        .submit_form input[type="button"] {
            background-color: #5cb85c;
            color: #fff;
            cursor: pointer;
            transition: background-color 0.3s;
            margin-top: 5px;
            border-radius: 5px;
            border: none;
            padding: 10px 10px;
            border: 2px solid black;
        }
        .submit_form input[type="button"] {
            background-color: #c9302c;
        }
        .submit_form input[type="submit"]:hover {
            background-color: #4cae4c;
        }
        .submit_form input[type="button"]:hover {
            background-color: #d9534f;
        }
    </style>
</head>
<body>
    <%
         User user = (User)session.getAttribute("LoggedInUser");
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
        <div class="address_container">
            <form action="UpdateUserServlet.do" method="POST">
                <h1>Enter details below</h1>
                <label>First Name</label>
                <input type="text" name="name" placeholder="<%=user.getName()%>" value="<%=user.getName()%>">
                <label>Last Name</label>
                <input type="text" name="surname" placeholder="<%=user.getSurname()%>" value="<%=user.getSurname()%>" required>
                <label>Contact Number</label>
                <input type="text" name="cell_nr" placeholder="<%=user.getPhoneNumber()%>" value="<%=user.getPhoneNumber()%>" required>
                <h4>Address</h4>
                <label>Street Name</label>
                <input type="text" name="street_name" placeholder="<%=user.getAddress().getStreetName()%>" value="<%=user.getAddress().getStreetName()%>" required>
                <label>Address Line 1</label>
                <input type="text" name="address" placeholder="<%=user.getAddress().getAddressLine1()%>" value="<%=user.getAddress().getAddressLine1()%>" required>
                <label>Postal Code</label>
                <input type="text" name="postal_code" placeholder="<%=user.getAddress().getPostalCode()%>" value="<%=user.getAddress().getPostalCode()%>" required>
                <div class="submit_form">
                    <input type="submit" value="Save Changes">
                    <input type="button" value="Cancel" onclick="window.history.back();">
                </div>
            </form>
        </div>
    </div>
</body>
</html>
