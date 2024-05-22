<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Settings Page</title>
        <style>
            body {
                font-family: 'Arial', sans-serif;
                background-color: #f4f4f4;
                margin: 0;
                padding: 0;
                line-height: 1.6; 
            }
            header {
                display: flex;
                justify-content: space-between;
                align-items: center;
                padding: 10px;
                background-color: #f8f8f8;
            }
            header img {
                width: 40px;
                height: 40px;
            }
            .links ul {
                display: flex;
                list-style-type: none;
                padding: 0;
                margin: 0;
            }
            .links ul li {
                margin-right: 15px;
            }
            .links ul li:last-child {
                margin-right: 0;
            }
            .links ul li a {
                text-decoration: none;
                color: inherit;
            }
            .links img {
                width: 40px;
                height: 40px;
            }
            h1 {
                margin: 0;
                font-size: 24px;
            }
            section {
                background-color: #fff;
                border: 1px solid #ddd;
                padding: 20px;
                margin: 20px auto; 
                border-radius: 10px;
                max-width: 800px; 
            }
            section ul {
                list-style-type: none;
                padding: 0;
            }
            section ul li {
                padding: 10px 0;
                border-bottom: 1px solid #ddd;
            }
            section ul li img{
                height: 20px;
                width: 20px;
            }
            section ul li:last-child {
                border-bottom: none;
            }
            a {
                text-decoration: none;
                color: #007bff;
                font-weight: bold;
                transition: color 0.3s ease;
            }
            a:hover {
                color: #0056b3; /* Darker shade on hover */
                text-decoration: underline;
            }
        </style>
    </head>
    <body>
        <header>
            <nav class="links">
                <ul>
                    <li><a href="user_menu.jsp"><img src="images/back.jpg" alt=""></a></li>
                    <li><a href="user_menu.jsp"><h1>Menu</h1></a></li>
                </ul>
            </nav>
            <a href="#"><img src="images/search-icon.jpg" alt=""></a>
        </header>
        <section>
            <h1>Settings & Privacy</h1>
            <ul>
                <li><a href="profile.jsp"><img src="images/settings-icon2.jpg" alt="">Profile Settings</a></li>
                <li><a href="delete_account.jsp"><img src="images/delete.jpg" alt="">Delete Account</a></li>
                <li><a href="#"><img src="images/password.jpg" alt="">Change Password</a></li>
                <li><a href="#"><img src="images/pay.jpg" alt="">Shipments and Payments</a></li>
                <li><a href="#"><img src="images/dark.webp" alt=""> Dark Mode</a></li>
                <li><a href="#"><img src="images/language.jpg" alt=""> Language</a></li>
            </ul>
        </section>
        <section>
            <h1>Help & Support</h1>
            <ul>
                <li><a href=""><img src="images/help.jpg" alt=""> Help</a></li>
                <li><a href="#"><img src="images/inbox.jpg" alt=""> Support Inbox</a></li>
                <li><a href="#"><img src="images/about.jpg" alt=""> About</a></li>
                <li><a href="#"><img src="images/report.jpg" alt=""> Report a Problem</a></li>
                <li><a href="#"><img src="images/safety.jpg" alt=""> Safety</a></li>
            </ul>
        </section>
    </body>
</html>
