<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Medical Store</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            background: url('https://t4.ftcdn.net/jpg/05/77/84/27/240_F_577842756_DWiS65lNLDG5DPaozrJk3c9TgkGGBwCb.jpg');
            background-size: cover;
            font-family: 'Arial', sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            overflow: hidden;
        }

        .container {
            text-align: center;
            max-width: 1000px;
            width: 90%;
        }

        .container h1 {
            color: #6a4c93;
            font-size: 2.5rem;
            margin-bottom: 20px;
        }

        .menu {
            margin-top: 20px;
            flex-direction: column;
            align-items: center;
        }

        .menu a {
            text-decoration: none;
            font-size: 1.5rem;
            color: #fff;
            background-color: #00FF00;
            padding: 15px;
            margin: 10px 0;
            border-radius: 12px;
            width: 100%;
            max-width: 300px;
            text-align: center;
            transition: background-color 0.3s ease;
        }

        .menu a:hover {
            background-color: #FFBF00;
        }

    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome to Batch-1 Medical Store</h1>
        <div class="menu" id="menu">
            <a href="addmed.jsp">Add Medicine</a>
            <a href="viewmed">View All Medicine</a>
            <a href="searchmed.jsp">Search Medicine</a>
        </div>
    </div>

</body>
</html>
