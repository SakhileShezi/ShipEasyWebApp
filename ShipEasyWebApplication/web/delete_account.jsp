<%@page import="ac.za.tut.user.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Account Deletion Confirmation</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            padding: 20px;
            background-color: #f9f9f9;
        }
        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .button {
            display: inline-block;
            padding: 10px 20px;
            font-size: 16px;
            margin-top: 20px;
            cursor: pointer;
            background-color: #007bff;
            border: 2px solid black;
            color: white;
            border: none;
            border-radius: 5px;
        }
        .button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <%
        User user = (User)session.getAttribute("LoggedInUser");
    %>
    <div class="container">
        <h1>Account Deletion Confirmation</h1>
        <p>Dear <%= user.getName()%>,</p>
        <p>We understand that you wish to delete your account. Please be aware of the following important information before proceeding:</p>
        <ul>
            <li><strong>Ongoing Shipments:</strong> If you currently have shipments in progress. Deleting your account will not affect the delivery of these shipments. They will continue to be processed and delivered as scheduled. However, you will no longer have access to tracking information or support for these shipments through your account.</li>
            <li><strong>Order History and Data:</strong> All your order history, personal information, and preferences will be permanently deleted. This action is irreversible.</li>
            <li><strong>Support and Refunds:</strong> Post deletion, you will not be able to access any previous support tickets or request refunds through your account. Please ensure all issues are resolved before proceeding.</li>
        </ul>
        <p>If you understand and agree to these terms, please confirm your request by clicking the "Delete Account" button below.</p>
        <form action="DeleteAccount.do" method="POST">
            <button type="submit" class="button">Delete Account</button>
        </form>
        <p>If you have any questions or need further assistance, please contact our support team.</p>
        <p>Thank you,<br>ShipEasy Support Team</p>
    </div>
</body>
</html>
