<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.techmunna.model.Employee" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style media="screen">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600&display=swap" rel="stylesheet">

      *,:
*before,
*:after{
    padding: 0;
    margin: 0;
    box-sizing: border-box;
}
body{
    background-color: #A9A9A9;
}
.background{
    width: 430px;
    height: 520px;
    position: absolute;
    transform: translate(-50%,-50%);
    left: 50%;
    top: 50%;
}
.background .shape{
    height: 200px;
    width: 200px;
    position: absolute;
    border-radius: 50%;
}
.shape:first-child{
    background: linear-gradient(
        #1845ad,
        #23a2f6
    );
    left: -80px;
    top: -80px;
}
.shape:last-child{
    background: linear-gradient(
        to right,
        #ff512f,
        #f09819
    );
    right: -30px;
    bottom: -80px;
}
form{
    height: 630px;
    width: 400px;
    background-color: #2a497d;
    position: absolute;
    transform: translate(-50%,-50%);
    top: 50%;
    left: 50%;
    border-radius: 20px;
    backdrop-filter: blur(10px);
    border: 2px solid rgba(255,255,255,0.1);
    box-shadow: 0 0 40px rgba(8,7,16,0.6);
    padding: 50px 35px;
}
form *{
    font-family: 'Poppins',sans-serif;
    color: #ffffff;
    letter-spacing: 0.5px;
    outline: none;
    border: none;
}
form h3{
    font-size: 32px;
    font-weight: bold;
    line-height: 42px;
   
}

label{
    display: block;
    margin-top: 30px;
    font-size: 16px;
    font-weight: 500;
}
input{
    display: block;
    height: 50px;
    width: 100%;
    background-color: rgba(255,255,255,0.07);
    border-radius: 3px;
    padding: 0 10px;
    margin-top: 8px;
    font-size: 14px;
    font-weight: 300;
}
::placeholder{
    color: #e5e5e5;
}
.btn{
    margin-top: 50px;
    width: 30%;
    background-color:#f28484;
    font-size: 18px;
    font-weight: 500;
    border-radius: 20px;
    cursor: pointer;
}

</style>
<body>
<% Employee e= (Employee)request.getAttribute("Employee");
   if(e == null){
	  
%>
<form action="reg">
<h1>Student Registration !!!</h1>

<div hidden>
<input type="number" name="tid"/>
</div>
<label for="text">Name</label>
<input type="text" name="tbName" placeholder="Enter a name"  />
<br>
<label for="text">gender</label>
<input type="text" name="tbgender" placeholder="Enter a gender"  />
<br>
<label for="Email">Date of birth</label>
<input type="password" name="tbdob"/>
<br>
<label for="Email">Email</label>
<input type="email" name="tbEmail" placeholder="Enter a Email"/>
<br>
<label for="Email">Phone</label>
<input type="tel" name="tbphone" placeholder="Enter a Mobile"/>
<br>
<div class="btn">
<input type="submit" name="btnReg" value="Submit"/>
</div>
<%
 }
   if(e != null){
	   
%>
    
<form action="update"> 
<h1>Student Edit Form</h1>
<div hidden>
<input type="number" name="tid" value="<%= e.getId() %>"/> 
</div>
<label for="text">Name</label>
<input type="text" name="tbName" placeholder="Enter a name" value="<%=e.getName() %>" />
<br>
<label for="dob">Gender</label>
<input type="date" name="tbgender" value="<%=e.getGender() %>"/>
<br>
<label for="dob">Date Of Birth</label>
<input type="date" name="tbdob" value="<%=e.getDob() %>"/>
<br>
<label for="Email">Email</label>
<input type="email" name="tbEmail" placeholder="Enter a Email" value="<%=e.getEmail() %>"/>
<br>
<label for="Email">Phone</label>
<input type="tel" name="tbphone" placeholder="Enter a Phone" value="<%=e.getPhone() %>"/>
<br>
<div class="btn">
<input type="submit" name="btnReg" value="Submit"/>
</div>

<%
}
%>
</form>
</body>
</html>