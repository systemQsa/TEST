
<%@ page contentType="text/html;charset=UTF-8"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="ftm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="lang" value="${not empty param.lang ? param.lang : not empty lang ? lang : pageContext.request.locale}"/>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="resources" var="locale"/>
<html lang="${lang}">
<head>
    <title>Admin</title>
</head>
<body>
<h1>Welcome Admin</h1>
<form  method="get" action="${pageContext.request.contextPath}/helloServlet">
    <input type="hidden" name="action" value="logout">
    <button type="submit"> <fmt:message bundle="${locale}" key="label.Logout"/></button>
</form>

<div class="dropdown">
    <form action="${pageContext.request.contextPath}/helloServlet" method="post">
        <input type="hidden" name="action" value="switchLang">
        <input type="hidden" name="currentPageAbsoluteURL" value="${pageContext.request.requestURL}">
        <input type="hidden" name="currentParameters" value="${pageContext.request.getQueryString()}">
        <div class="dropdown-content">
            <button type="submit" name="language" value="uk">
                <fmt:message bundle="${locale}" key="header.lang.ukr"/>
            </button>
            <p>LoCALe request</p>
            <p>"${pageContext.request.locale}"</p>
            <p> Locale response</p>
            <p>${pageContext.response.locale}"</p>
            <button type="submit" name="language" value="en">
                <fmt:message bundle="${locale}" key="header.lang.eng"/>
            </button>
        </div>
    </form>
</div>
</body>
</html>
