<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="com.techmunna.model.Employee" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style>
html,
body {
	height: 100%;
}
h1{
margin-bottom:80px;
text-align:center;
color: white;

}
body {
	margin: 0;
	background: linear-gradient(45deg, #49a09d, #5f2c82);
	font-family: sans-serif;
	font-weight: 100;
}
.container {
	position: absolute;
	top: 30%;
	left: 50%;
	transform: translate(-50%, -50%);
}

table {
	width: 800px;
	border-collapse: collapse;
	overflow: hidden;
	box-shadow: 0 0 20px rgba(0,0,0,0.1);
}

th,
td {
	padding: 15px;
	background-color: rgba(255,255,255,0.2);
	color: #fff;
	font-weight: bold;
}

th {
	text-align: left;
	background-color: #1c285b;

} 


</style>
<body>

<div class="container">
<h1>Student Details</h1>
<table border="1">
<thead>
<tr>
<th>Sno</th>
<th>Name</th>
<th>Email</th>
<th>Password</th>
<th>Mobile</th>
<th>Action</th>
</tr>
</thead>
<% 
ArrayList<Employee> al = (ArrayList<Employee>)request.getAttribute("lst");
for(Employee s: al) 
{
%>
<tbody>
<tr>
<td><%= s.getId() %></td>
<td><%= s.getName() %></td>
<td><%= s.getEmail() %></td>
<td><%= s.getDob() %></td>
<td><%=  s.getGender() %></td>
<td><%=  s.getPhone() %></td>
<td>

     <a href="edit?id=<%=s.getId() %>">Edit</a>
     <a href="delete?id=<%=s.getId() %>">Delete</a> 
</td>
</tr>
</tbody>
<%
}
%>
</table>
</div>
</html>