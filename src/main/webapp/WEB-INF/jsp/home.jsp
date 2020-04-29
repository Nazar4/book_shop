<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>

<jsp:include page="header.jsp"/>
<div class="container">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
        </form>

        <h2>Welcome to the book-shop  | <a onclick="document.forms['logoutForm'].submit()">Logout</a>

        </h2>
    </c:if>
</div>

