<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="lang" value="${not empty param.lang ? param.lang : not empty lang ? lang : pageContext.request.locale}"/>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="resources" var="locale"/>
<%--<fmt:setBundle basename="exceptionMessages" var="exc_msg"/>--%>

<!DOCTYPE html>
<html lang=${lang}>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/index.css">
</head>
<body>
<header>
    <ul>
        <li>
            <div class="dropdown">
                <form action="helloServlet" method="post">
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
        </li>
    </ul>

    </h1>
</header>

<h1><fmt:message  bundle="${locale}" key="label.WELCOME"/>
    <h2>
        <fmt:message bundle="${locale}" key="label.Login"/>
    </h2>
    <h2>
        <fmt:message bundle="${locale}" key="label.register"/>
    </h2>

    <h1> <fmt:message bundle="${locale}" key="label.WELCOME"/> </h1>
</body>