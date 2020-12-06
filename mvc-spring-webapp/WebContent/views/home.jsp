<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>     
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="./styles/product1.css"/>
</head>
<body>
<h1>Product</h1>
<!-- on action addproduct it goes to product controller -->
<!-- 1)include the jstl lib above..as done above doctype html..returning the product to controller...object being returned ..path to be specified for fields-->
<form:form class="form" action="addProduct" method="post" modelAttribute="product">
<form:errors path="dop" cssClass="errorblock" element="div"/>
<fieldset>
<legend>Add Product</legend>
<form:input type="text" path="name" pattern="[a-zA-Z]*"  placeholder="Product Name" required="required"/>
<form:input type="number" path="unitPrice"  placeholder="UnitPrice" required="required" />
<form:input type="date" path="dop"  placeholder="dateOfPurchase" required="required"/>
<input type="submit" value="Add"/>
<input type="reset" value="Reset"/>
</fieldset>
</form:form>
</body>
</html>