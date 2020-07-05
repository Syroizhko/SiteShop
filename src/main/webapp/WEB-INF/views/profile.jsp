<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>

    <title>Профіль</title>
    <link href="../../resources/nav.css" rel="stylesheet" type="text/css" >
    <link href="../../resources/profile.css" rel="stylesheet" type="text/css" >
</head>

<body>

<%@include file="block/nav.jsp"%>

<div class="form">
    <form action="/profile/${user.id}">
        <table width="100%" cellspacing="10px"  >
            <tr>
                <th height="50px" colspan="3"><h1 class="h1">Профиль</h1></th>

            </tr>
            <tr><td  rowspan="5"><img class="img3" width="100%" alt="User photo"  src="/images/${user.photoUrl}"></td>
                <td class="t" height="10px">ПІБ:</td><td class="t1">${user.surname}</td></tr>
            <tr><td class="t" height="10px">E-mail:</td><td class="t1">${user.email}</td></tr>
            <tr><td class="t" height="10px">Стать:</td><td class="t1">${user.male}</td></tr>
            <tr><td class="t" height="10px" >Тел:</td><td class="t1">${user.phone}</td></tr>
            <tr><td class="t" height="10px">Країна:</td><td class="t1">${user.country}</td></tr>
            <tr >
                <td >
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2">
                            <form:form class="form-horizontal"
                                       action="/profile/${user.id}" method="POST" enctype="multipart/form-data">
                                <div class="form-group">
                                    <label for="file" class="control-label col-sm-2">Змінити фото:</label>
                                    <div class="col-sm-10">
                                        <input name="image" id="image" type="file">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-10 col-sm-offset-2">
                                        <button class="myButton" type="submit">Додати фото </button>
                                    </div>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </td>

                <td valign="bottom" height="50px" colspan="3"><a class="myButton" href="/profile/${user.id}/edit">Редагувати Профиль</a></td></tr>
        </table>

    </form>





</div>
</body>
</html>

