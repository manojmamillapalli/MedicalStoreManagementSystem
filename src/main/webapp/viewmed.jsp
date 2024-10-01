<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
    // Retrieve the selected option from the session
    String selectedOption = (String) session.getAttribute("selectedOption");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Medical Store</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background: url('https://png.pngtree.com/thumb_back/fh260/background/20240401/pngtree-blur-pharmacist-taking-medicine-from-shelf-in-pharmacy-image_15649362.jpg');
        background-size: cover;
        background-repeat: no-repeat;
        color: #333;
    }
    .nav-container {
        margin: 20px;
        display: flex;
        justify-content: center;
        gap: 20px;
    }
    .nav-container a {
        text-decoration: none;
    }
    .nav-container .btn {
        padding: 10px 20px;
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 5px;
        font-size: 16px;
        cursor: pointer;
    }
    .nav-container .btn:hover {
        background-color: #45a049;
    }
    table {
        width: 80%;
        border-collapse: separate;
        border-spacing: 0;
        margin-top: 20px;
        background-color: white;
        border-radius: 15px;
        overflow: hidden;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }
    th, td {
        padding: 15px 20px;
        text-align: left;
    }
    th {
        background-color: #4CAF50;
        color: white;
        font-size: 18px;
        text-transform: uppercase;
    }
    select {
    padding: 6px; 
    font-size: 14px; 
    border: 1px solid #ccc;
    border-radius: 4px;
    background-color: #4CAF50;
    color: #333;
    transition: border-color 0.3s;
    outline: none;
	}

    tr {
        border-bottom: 1px solid #ddd;
    }
    tr:last-child {
        border-bottom: none;
    }
    tr:nth-child(even) {
        background-color: #ccffcc;
    }
    tr:nth-child(odd) {
        background-color: #e6ffe6;
    }
    tr:hover {
        background-color: #f1f1f1;
    }
    td a {
        color: #0073e6;
        text-decoration: none;
        padding: 6px 12px;
        background-color: #e7f3ff;
        border-radius: 4px;
        transition: background-color 0.3s ease;
    }
    td a:hover {
        background-color: #cfe3ff;
    }
    td {
        font-size: 16px;
    }
</style>
</head>
<body>
    <center>
        <div class="nav-container">
        	<a href="index.jsp"><button class="btn">Home</button></a>
            <a href='addmed.jsp'><button class="btn">Add Medicine</button></a>
            <a href='viewmed'><button class="btn">View All Medicines</button></a>
            <a href='searchmed.jsp'><button class="btn">Search Medicine</button></a>
        </div>
        
        <table>
        <tr>
            <th>Medicine Id</th>
            <th>Medicine Name</th>
            <th>Quantity</th>
            <th>Type
 <form action="viewmed" method="GET">
    <select name="option" onchange="this.form.submit()">
        <option value="" <%= (selectedOption == null || selectedOption.isEmpty()) ? "selected" : "" %>>-Select-</option>
        <option value="All" <%= "All".equals(selectedOption) ? "selected" : "" %>>All</option>
        <option value="Tablet" <%= "Tablet".equals(selectedOption) ? "selected" : "" %>>Tablet</option>
        <option value="Capsule" <%= "Capsule".equals(selectedOption) ? "selected" : "" %>>Capsule</option>
        <option value="Syrup" <%= "Syrup".equals(selectedOption) ? "selected" : "" %>>Syrup</option>
        <option value="Injection" <%= "Injection".equals(selectedOption) ? "selected" : "" %>>Injection</option>
    </select>
</form>
            	
            </th>
            <th>Manufacturer</th>
            <th>Expiry Date</th>
            <th>Price per Unit</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${medicines}" var="med">
            <tr>
                <td><c:out value="${med.id}"></c:out></td>
                <td><c:out value="${med.name}"></c:out></td>
                <td><c:out value="${med.quantity}"></c:out></td>
                <td><c:out value="${med.type}"></c:out></td>
                <td><c:out value="${med.manufacturer}"></c:out></td>
                <td><c:out value="${med.expdate}"></c:out></td>
                <td><c:out value="${med.price}"></c:out></td>
                <td><a href='editmed.jsp?id=${med.id}&name=${med.name}&quantity=${med.quantity}&type=${med.type}&manufacturer=${med.manufacturer}&expdate=${med.expdate}&price=${med.price}'>Edit</a></td>
                <td><a href='deletemed?id=${med.id}'>Delete</a></td>
            </tr>
        </c:forEach>
        </table>
    </center>
</body>
</html>
