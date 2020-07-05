<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<header class="topnav">

    <a href="/">Главная</a>
    <a href="/profile/${user.id}">Профиль</a>
    <a href="/addPost/${user.id}">Подать обьявление</a>
    <sec:authorize  access="hasRole('ADMIN')">
        <a href="/admin">Адміністратор</a>
    </sec:authorize>

    <div class="topnav1">
        <sec:authorize  access="isAuthenticated()">
            <a href="/logout">Log Out</a>
        </sec:authorize>
        <a href="">Hi ${user.username}</a>

    </div>


</header>