<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="lang" value="${not empty param.lang ? param.lang : not empty lang ? lang : pageContext.request.locale}" scope="session"/>
<html>
<head lang="${lang}">
    <meta http-equiv='cache-control' content='no-cache'>
    <meta http-equiv='expires' content='0'>
    <meta http-equiv='pragma' content='no-cache'>
    <title>Register</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<h1>REGISTER</h1>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-5">
            <div class="card">
                <div class="card-header">${language['label.Register']}</div>
                <div class="card-body">

                    <form class="form-horizontal" method="post" action="helloServlet">
                        <input  type="hidden" name="action" value="register">
<%--                        <div class="form-group">--%>
<%--                            <label for="name" class="cols-sm-2 control-label"><fmt:message bundle="${locale}" key="label.Name"/></label>--%>
<%--                            <div class="cols-sm-10">--%>
<%--                                <div class="input-group">--%>
<%--                                    <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>--%>
<%--                                    <input type="text" class="form-control" name="name" id="name" placeholder="<fmt:message bundle="${locale}" key="label.Enter"/><fmt:message bundle="${locale}" key="label.Name"/>" />--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <div class="form-group">--%>
<%--                            <label for="email" class="cols-sm-2 control-label"><fmt:message bundle="${locale}" key="label.Surname"/></label>--%>
<%--                            <div class="cols-sm-10">--%>
<%--                                <div class="input-group">--%>
<%--                                    <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>--%>
<%--                                    <input type="text" class="form-control" name="email" id="email" placeholder="<fmt:message bundle="${locale}" key="label.Surname"/>" />--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
                        <div class="form-group">
                            <label for="username" class="cols-sm-2 control-label"> ${language['label.Username']}</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
                                    <input type="text" class="form-control" name="login" id="username" placeholder="${language['label.username']}" />
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="cols-sm-2 control-label">${language['label.Password']}</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                    <input type="password" class="form-control" name="password" id="password" placeholder="${language['label.Enter']}${language['label.password']}" />
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="confirm" class="cols-sm-2 control-label">${language['label.Confirm']}${language['label.password']}</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                    <input type="password" class="form-control" name="confirm" id="confirm" placeholder="${language['label.Confirm']}${language['label.password']}" />
                                </div>
                            </div>
                        </div>
                        <div class="form-group ">
                            <button type="submit" class="btn btn-primary btn-lg btn-block login-button">${language['label.Register']}</button>
                        </div>
                        <div class="login-register">
                            <a href="${pageContext.request.contextPath}/login.jsp">${language['label.Login']}</a>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>
