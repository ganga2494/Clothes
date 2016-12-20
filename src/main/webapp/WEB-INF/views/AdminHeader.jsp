<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>ClothesAdmin</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">		

</head>
<body>
<img align="left" src="resources/logo2.jpg" width="150" height="100"/>

  <div class="container">
  <div>
  Welcome   <core:out value="${UserName}"/>
  
</div>
</div>	
 
<div class="row" align="left" style="background-color:rgb(128,128,128)">
		
		<div>
		 
		
</div>
  </div>
  

			
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
 
    <ul class="nav navbar-nav">
      <li class="active"><a href="index.jsp">Home</a></li>
      
      
       <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Products<span class="caret"></span></a>
        <ul class="dropdown-menu">
        <li><a href="AdminProducts">ManageProducts</a></li>
          
          
        </ul>
      </li>
      
      
      
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Category<span class="caret"></span></a>
        <ul class="dropdown-menu">
        
          <li><a href="category">ManageCategory</a></li>
          
          
        </ul>
      </li>
      
      
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Supplier<span class="caret"></span></a>
        <ul class="dropdown-menu">
         <li><a href="SupplierView">ManageSupplier</a></li>
         
        </ul>
      </li>
     
     <li><a href="AboutUs">AboutUs</a></li>
      <li><a href="perform_logout">Logout</a></li>
      
    </ul>
  </div>
</nav>
  
