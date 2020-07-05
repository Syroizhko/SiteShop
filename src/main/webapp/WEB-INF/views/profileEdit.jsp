<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Редагувати профиль</title>
    <link href="../../resources/nav.css" rel="stylesheet" type="text/css" >
    <link href="../../resources/profileEdit.css" rel="stylesheet" type="text/css" >
</head>

<body>

<%@include file="block/nav.jsp"%>
<div>


    <div class="row">
        <div class="col-sm-8 col-sm-offset-2">
            <form:form  modelAttribute="user"  method="POST">
                <div class=post>
                    <table  width="100%" >
                        <tr>
                            <th colspan="3"> <h1 class="h1">Редагувати профіль</h1></th>
                        </tr>

                        <tr >
                            <td valign="top" width="30" rowspan="8">
                                <img class="img3" width="100%" alt="User photo"  src="/images/${user.photoUrl}">
                            </td>

                        </tr>
                        <tr>
                            <td width="20%" class="td"><label for="username" class="control-label col-sm-2">Логін:</label></td>
                            <td width="50%"  ><form:input type="text"   path="username" id="username" class="form-control" placeholder="Логін" /></td>
                        </tr>
                        <tr>
                            <td class="td"><label for="surname" class="control-label col-sm-2">ПІБ:</label></td>
                            <td ><form:input type="text" path="surname" id="surname" class="form-control" placeholder="ПІБ" /></td>
                        </tr>
                        <tr>
                            <td class="td"><label for="email" class="control-label col-sm-2">E-mail:</label></td>
                            <td> <form:input type="text" path="email" id="email" class="form-control" placeholder="E-mail"/></td>
                        </tr>
                        <tr>
                            <td class="td"><label for="male" class="control-label col-sm-2">Стать:</label></td>
                            <td> <form:input type="text" path="male" id="male" class="form-control" placeholder="Стать" /></td>
                        </tr>
                        <tr>
                            <td class="td"> <label for="phone" class="control-label col-sm-2">Номер тел.:</label></td>
                            <td>  <form:input type="text" path="phone" id="phone" class="form-control" placeholder="Номер тел."/></td>
                        </tr>
                        <tr>
                            <td class="td"> <label for="country" class="control-label col-sm-2">Країна:</label></td>
                            <td><form:input type="text" path="country" id="country" class="form-control" placeholder="Країна"/></td>
                        </tr>
                        <tr>
                            <td class="td"><label for="password" class="control-label col-sm-2">Пароль:</label></td>
                            <td><form:password path="password" id="password" class="form-control" placeholder="Пароль"/></td>
                        </tr>
                        <tr>
                            <td class="But" colspan="3"><button  class="myButton" type="submit">Редагувати</button></td>
                        </tr>

                    </table>
                </div>
            </form:form>


        </div>
    </div>

</div>
</body>
</html>

