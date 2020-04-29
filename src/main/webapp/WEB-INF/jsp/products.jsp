<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">


<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
       <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
       <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
       <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
       <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script src="resources/js/products.js"></script>
<link rel="stylesheet" href="resources/css/products.css">

</head>
<body>


	<jsp:include page="header.jsp"></jsp:include>

	<title>Products</title>
	<ul class="list">
		<c:forEach items="${products}" var="product">
		<c:set var = "product_id" value = "${product.id}"/>
		  <li class="item card">
			  <h1>${product.name}</h1>
			  <p>${product.genre}</p>
			  <p>${product.description}</p>
			  <p class="price">$${product.price}</p>
			  <a><button href="/basket?id=${product_id}"onclick="buyBook('${product.id}')" class="btn btn-outline-success my-2 my-sm-0"><h5>Buy book</h5></button></a>

			  <sec:authorize access="hasRole('ROLE_ADMIN')">
                        			  <a href="/products/delete?id=${product_id}" class="btn btn-outline-success my-2 my-sm-0">Delete</a>
                        	 </sec:authorize>
		  </li>
		</c:forEach>
	  </ul>

</body>
</html>