<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri = "jakarta.tags.fmt"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>

<c:if test="${msg==false}">
    Login Failed :))
</c:if>

<c:if test="${msg == true}">
    User Name: ${uname} <br>
    Password: ${pwd} <br>

    <!-- Logout Button -->
    <form action="logout" method="post">
        <button type="submit">Logout</button>
    </form>

</c:if>

</body>
</html>
