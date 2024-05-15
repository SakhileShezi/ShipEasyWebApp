<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add Shipping Methods Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }
        header {
            background-color: #007bff;
            color: #fff;
            padding: 10px 0;
            text-align: center;
        }
        footer {
            background-color: #333;
            color: #fff;
            padding: 10px 0;
            text-align: center;
            position: fixed;
            bottom: 0;
            width: 100%;
        }
        form {
            margin-top: 50px;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            width: 300px;
            margin: 0 auto;
        }
        label {
            font-weight: bold;
            margin-top: 10px;
        }
        select, input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <header>
        <h1>Add Shipping Methods</h1>
    </header>
    <form action="AddStatusServlet.do" method="POST">
        <div>
            <label><b>Transportation Mode </b></label><br />
            <select name="transport">
                <option value="ShipEasy Service">ShipEasy Service</option>
                <option value="Courier Service">Courier Service</option>
                <option value="Truck">Truck</option>
                <option value="Scooter">Scooter</option>
                <option value="Van">Van</option>
            </select> <br />
            <label><b>Delivery Method </b></label><br />
            <select name="delivery_method">
                <option value="Standard Shipping">Standard Shipping</option>
                <option value="Same-Day Delivery">Same-Day Delivery</option>
                <option value="Ground Shipping">Ground Shipping</option>
                <option value="Express Delivery">Express Delivery</option>
            </select> <br />
            <label><b>Current Status </b></label><br />
            <select name="status">
                <option value="Shipment Confirmed">Shipment Confirmed</option>
                <option value="Processing Shipment">Processing Shipment</option>
                <option value="Out for Collection">Out for Collection</option>
                <option value="Checking Quality">Checking Quality</option>
                <option value="On Delivery">On Delivery</option>
                <option value="Delivered">Delivered</option>
            </select> <br />
            <label><b>Next Action</b></label><br />
            <select name="future_stats">
                <option value="Shipment Confirmed">Shipment Confirmed</option>
                <option value="Processing Shipment">Processing Shipment</option>
                <option value="Out for Collection">Out for Collection</option>
                <option value="Checking Quality">Checking Quality</option>
                <option value="On Delivery">On Delivery</option>
                <option value="Delivered">Delivered</option>
            </select> <br />
            <input type="submit" value="Complete">
        </div>
    </form>
    <footer>
        <p>© 2024 ShipEasy Services. All rights reserved.</p>
    </footer>
</body>
</html>
