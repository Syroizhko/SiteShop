<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html >
<head>

    <title>Admin</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="../../resources/nav.css" rel="stylesheet" type="text/css" >
    <link href="../../resources/AdminMain.css" rel="stylesheet" type="text/css" >
</head>
<body>

<%@include file="block/nav.jsp"%>


<div class="name">
    <h1 class="h1">Список Користувачів:</h1>
</div>

<c:forEach  var="users" items="${users}" >
    <div  class="post">
        <div class="namePost">
            <h2 class="h2">${s.name}</h2>
        </div>

        <table width="100%" border="1" style="border-color: #f58d64" >
            <tr >
                <td width="2%" >${users.id}.</td>
                <td width="5%" bgcolor="#9ff5f3">${users.role}</td>
                <td width="20%">${users.username}</td>
                <td  width="20%" >${users.surname}</td>
                <td  width="33%">${users.email}</td>
                <td  width="5%">${users.male}</td>
                <td  width="10%">${users.phone}</td>
                <td  width="5%">${users.country}</td>
            </tr>
        </table>
        <table width="100%" >
            <tr>

                <td width="25%" class="but"> <a href="/admin/edit/${users.id}">
                    <button class="btn btn-danger" type="submit">Редагувати</button>
                </a>
                </td>
                <td width="25%" class="but"> <a href="/admin/delete/${users.id}">
                    <button class="btn btn-danger" type="submit">Видалити</button>
                </a>
                </td>
                <td width="25%" class="but"> <a href="setAdmin/${users.id}">
                    <button class="btn btn-danger" type="submit">Дати ADMIN</button>
                </a>
                </td>
                </td>
                <td width="25%" class="but"> <a href="setUser/${users.id}">
                    <button class="btn btn-danger" type="submit">Дати USER</button>
                </a>
                </td>
            </tr>
        </table>
    </div>

</c:forEach>


</body>
</html>