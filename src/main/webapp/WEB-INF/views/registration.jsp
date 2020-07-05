<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Реєстрація</title>
    <link href="../../resources/registration.css" rel="stylesheet" type="text/css" >
</head>
<body>

<div >
            <form:form  modelAttribute="user" action="/registration" method="POST">

                <div class="for">
                <table  width="100%">
                    <tr>
                        <td rowspan="10"><img class="img1"  src="/resources/image/logo4.1.png"></td>
                        <td colspan="2"><h1>Реєстрація</h1></td>
                    </tr>
                    <tr>
                        <td><label for="username" class="control-label col-sm-2">Логін:</label></td>
                        <td><form:input type="text"  path="username" id="username" class="form-control" placeholder="Логін" /></td>
                    </tr>
                    <tr>
                        <td><label for="surname" class="control-label col-sm-2">ПІБ:</label></td>
                   <td><form:input type="text" path="surname" id="surname" class="form-control" placeholder="ПІБ" /></td>
                    </tr>
                    <tr>
                        <td><label for="email" class="control-label col-sm-2">E-mail:</label></td>
                        <td> <form:input type="text" path="email" id="email" class="form-control" placeholder="E-mail"/></td>
                    </tr>
                    <tr>
                        <td><label for="male" class="control-label col-sm-2">Стать:</label></td>
                        <td> <form:input type="text" path="male" id="male" class="form-control" placeholder="Стать" /></td>
                    </tr>
                    <tr>
                        <td> <label for="phone" class="control-label col-sm-2">Номер тел.:</label></td>
                        <td>  <form:input type="text" path="phone" id="phone" class="form-control" placeholder="Номер тел."/></td>
                    </tr>
                    <tr>
                        <td> <label for="country" class="control-label col-sm-2">Країна:</label></td>
                        <td><form:input type="text" path="country" id="country" class="form-control" placeholder="Країна"/></td>
                    </tr>
                    <tr>
                        <td><label for="password" class="control-label col-sm-2">Пароль:</label></td>
                        <td><form:password path="password" id="password" class="form-control" placeholder="Пароль"/></td>
                    </tr>
                    <tr>
                        <td colspan="2"> <button class="myButton" type="submit">Реєстрація</button></td>
                    </tr>
                    <tr>
                        <td colspan="2"> <a class="a1" href="/login">У мене вже є аккаунт</a></td>
                    </tr>

                </table>
            </form:form>
</div>
</body>
</html>
