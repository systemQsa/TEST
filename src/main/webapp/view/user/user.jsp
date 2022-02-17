<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8"  %>
<c:set var="lang" value="${not empty param.lang ? param.lang : not empty lang ? lang : pageContext.request.locale}"/>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="resources" var="locale"/>
<html lang="${locale}">
<head>
    <title>USER</title>
</head>
<body>
<h1>WELCOME USER</h1>
<<form method="get" action="${pageContext.request.contextPath}/helloServlet">
    <input type="hidden" name="action" value="logout">
    <button type="submit"> <fmt:message bundle="${locale}" key="label.Logout"/></button>
</form>

</body>
</html>
