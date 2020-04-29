<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="b" %>

<head>
    <meta charset="utf-8">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet"/>
</head>

<jsp:include page="header.jsp"></jsp:include>
<br>
<br>

<div class="container">
    <div class="row">

            <h1>Basket</h1>

                <c:forEach items="${basket.product}" var="product">
                    <tr>
                        <c:set var = "product_id" value = "${product.id}"/>

                        <td>${product.name}</td>
                        <td>${product.price}</td>
                        <td>${product.description}</td>
                        <td>${product.genre}</td>

                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <h4><label>Products in Basket: ${basket.totalProduct}</label></h4>
            <br>
            <h4><label>Full price : ${basket.totalPrice}</label></h4>



    </div>
</div>