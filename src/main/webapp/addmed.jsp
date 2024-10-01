<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String status = (String) request.getAttribute("status"); %>
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
  			background: url('https://w0.peakpx.com/wallpaper/915/450/HD-wallpaper-interior-pharmacy-cute-pharmacy.jpg');
            background-size: cover;            
            font-family: 'Arial', sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            padding: 20px;
        }

        .container {
            width: 100%;
            max-width: 400px;
            background-color: #007399;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        h1 {
            color: #ffb31a;
            margin-bottom: 20px;
            font-size: 1.8rem;
        }

        input[type="text"], select {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 1rem;
        }

        input[type="submit"] {
            width: 100%;
            padding: 12px;
            background-color: #ffb31a;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 1.1rem;
            cursor: pointer;
            margin-top: 10px;
        }

        input[type="submit"]:hover {
            background-color: #FFA500;
        }

        .status-message {
            font-size: 1rem;
            color: #ffb31a;
            margin-bottom: 10px;
        }

        a {
            display: block;
            color: #FFBF00;
            margin-top: 10px;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Batch-1 Medical Store</h1>

        <% if (status != null) { %>
            <div class="status-message"><%= status %></div>
        <% } %>

        <form action="savemedicine">
            <input type="text" name="name" placeholder="Medicine Name">
            <input type="text" name="quantity" placeholder="Quantity">
            <select name="type" required>
                <option value="" disabled selected>Select Type</option>
                <option value="Tablet">Tablet</option>
                <option value="Capsule">Capsule</option>
                <option value="Syrup">Syrup</option>
                <option value="Injection">Injection</option>
            </select>
            <input type="text" name="manufacturer" placeholder="Manufacturer">
            <input type="text" name="expdate" placeholder="Expiry Date (yyyy/mm/dd)">
            <input type="text" name="price" placeholder="Price per Unit">
            <input type="submit" value="Add Medicine">
        </form>
		<a href="index.jsp">Home</a>
        <a href="addmed.jsp">Add Another Medicine</a>
        <a href="viewmed">View All Medicines</a>
        <a href="searchmed.jsp">Search Medicine</a>
    </div>
</body>
</html>
