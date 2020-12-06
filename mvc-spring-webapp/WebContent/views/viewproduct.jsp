<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>     
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="./styles/viewproduct.css"/>
</head>
<body>
<!-- list of products has to be displayed here using JSTL..so add tag lib -->
<table class="table">
<c:forEach var="product" items="${productlist}">
<tr>
<td>${product.productId}</td>
<td>${product.name}</td>
<td>${product.dop}</td>
<td>${product.unitPrice}</td>
</tr>
</c:forEach>
</table>
<span><a href="showProductForm">AddProduct</a></span>
</body>
</html>