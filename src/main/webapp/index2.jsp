<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="lang" value="${not empty param.lang ? param.lang : not empty lang ? lang : pageContext.request.locale}"/>

<!DOCTYPE html>
<html>
<head>
    <title>Rental Car</title>
    <link rel="icon" href="data:;base64,iVBORw0KGgo=">

<%--    <link rel="stylesheet" type="text/css" href="css/index.css">--%>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>navigation-with-button</title>
<%--    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">--%>
   <style><%@include file="css/index.css"%></style>
</head>
<body>
<!-- Header Start -->
<header class="site-header">
    <div class="site-header__top">
        <div class="wrapper site-header__wrapper">
            <div class="site-header__start">
                <ul class="">
                    <li class=""><a href="#">About</a></li>
                    <li class=""><a href="#">Contact</a></li>
                </ul>
            </div>
            <div class="site-header__middle">
                <a href="#" class="brand">Brand</a>
            </div>
            <form action="helloServlet" method="post">
                <input type="hidden" name="action" value="switchLang">
                <input type="hidden" name="currentPageAbsoluteURL" value="${pageContext.request.requestURL}">
                <input type="hidden" name="currentParameters" value="${pageContext.request.getQueryString()}">
                <div class="dropdown-content">
                    <button type="submit" name="language" value="uk">
                        ${language['header.lang.ukr']}
                    </button>
                    <button type="submit" name="language" value="en">
                        ${language['header.lang.eng']}
                    </button>
                </div>
            </form>


            <form action="helloServlet" method="post">
                <a href="${pageContext.request.contextPath}/login.jsp">${language['label.Login']}</a>
            </form>
            <a href="${pageContext.request.contextPath}/register.jsp">${language['label.Register']}</a>
        </div>
    </div>
    </div>

    <div class="site-header__bottom">
        <div class="wrapper site-header__wrapper">
            <div class="site-header__start">
                <nav class="nav">
                    <button class="nav__toggle" aria-expanded="false" type="button">
                        menu
                    </button>
                    <ul class="nav__wrapper">
                        <li class="nav__item"><a href="${pageContext.request.contextPath}/index.jsp">
                            <p>${language['header.Home']}</p>
                        </a></li>
                        <li class="nav__item"><a href="#"><p>${language['header.fleet']}</p></a></li>
                        <li class="nav__item"><a href="#"> <p>${language['header.contact_us']}</p></a>
                        <li class="nav__item"><a href="#"><p>${language['header.services_upper']}</p></a></li>
                        <li class="nav__item"><a href="#"><p>${language['header.Make_a_booking']}</p></a></li>
                        </li>
                    </ul>
                </nav>
            </div>

            <div class="site-header__end bottom">
                <div class="search">
                    <button class="search__toggle" aria-label="Open search">
                        Search
                    </button>
                    <form class="search__form" action="">
                        <label class="sr-only" for="search">Search</label>
                        <input
                                type="search"
                                name=""
                                id="search"
                                placeholder="What's on your mind?"/>
                    </form>
                </div>
                <a href="${pageContext.request.contextPath}/home.jsp">GO TO Home</a>
                <%--<a href="${pageContext.request.contextPath}/exception">Exception</a>--%>
            </div>
        </div>
    </div>
</header>
<c:out value="hello"/>
<a href="${pageContext.request.contextPath}/page.jsp">CLiCK ME</a>
<a href="?lang=uk">UKR</a><br><a href="?lang=en">ENG</a>
<p>${language['label.Surname']}</p>
<p>${language['label.Login']}</p>

<p>${language['label.Register']}</p>

<h6>Locale param</h6>
</body>
</html>
