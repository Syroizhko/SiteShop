<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Вхід на сторінку</title>

   <link href="../../resources/login.css" rel="stylesheet" type="text/css" >

</head>

<body class="body1">



<sec:authorize access="isAuthenticated()">
        <% response.sendRedirect("/"); %>
</sec:authorize>


<form:form method="POST" action="/login">
<div class="form" >

    <table class="tab" width="100%" >
        <tr>

            <td width="60%" rowspan="6" class="td1" ><img class="img1"  src="/resources/image/logo4.1.png"></td>

            <td width="40%" colspan="2" class="tit"><h2 class="Enter">Вхід на сторінку</h2></td>

        </tr>
        <tr class="tr1">
            <td >
                <label>Логін:</label>
            </td>
            <td ><input name="username" type="text" placeholder="Логін" autofocus="true"/></td>
        </tr>
        <tr>
            <td>
                <label>Пароль:</label>
            </td>
            <td>
                <input name="password" type="password" placeholder="Пароль"/>
            </td>
        </tr>

        <tr >
            <td colspan="2">
                <a href="/"><button class="myButton" type="submit">Вхід</button></a>
            </td>
        </tr>
        <tr>
            <td colspan="2" class="td2"><h4><a href="/registration" class="a1">Реєстрація</a></h4></td>
        </tr>

    </table>
</div>

</form:form>

