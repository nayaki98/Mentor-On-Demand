<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    import="java.util.*,com.examples.mentor.model.*" pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Mentor on Demand</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="/Style/style.css">
</head>
<body>
<h1 style="text-align: center;">MENTOR ON DEMAND</h1>
       
        <br>
        
         <div class="row">
            <nav class="navbar navbar-inverse">
                <ul class="nav navbar-nav col-lg-12 ">
                    <li class="col-md-1 col-md-offset-1 "><a href="/mentorHomePage">Home</a></li>
                 <li class="col-md-2"><a href="/requestlist">Request Status</a></li>
                     <li class="col-md-2" ><a href="#">Current Training</a></li>
                      <li class="col-md-2" ><a href="#">Completed Training</a></li>
                 <li class="col-md-1"><a href="userList">User List</a></li>
                    <li class="col-md-1"><a href="/logout">Log Out</a></li>
                   
            </nav>
        </div>
        
<div class="container">

   
        <h3 class="createaccount">User List</h3><br>
        <%
        List userList=(List)request.getAttribute("userList");
		%>
		
		<table class="table table-striped">
		 <tr class="section">
		 <th >User Id</th>
            <th>USer Name</th>
             <th >Contact Number</th>
              <th>Email</th> 
           <th></th>
    </tr>

        <% for(int i=0;i<userList.size();i++){
	Users user=(Users)userList.get(i);
	%>
	
	 <tr>
            <td ><%= user.getUserId() %></td>
            <td><%= user.getUserName()%></td>
             <td ><%= user.getMobileNumber()%></td>
            <td ><%= user.getEmail()%></td>
            
          <%-- <td id="td2 ptext"> <a href="updateCompany?companyCode=<%= c.getCompanyCode()%>" ><button class="edit">Edit</button></a> 
          <a href="deleteCompany?companyCode=<%= c.getCompanyCode()%>" ><button class="edit">Delete</button></a></td> --%>
          <td></td>
        </tr>
        <% }%>
     </table>
    </div>
   
</div>
</body>
</html>