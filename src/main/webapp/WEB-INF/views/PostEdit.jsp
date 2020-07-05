<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>

    <title>B&S</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="../../../resources/nav.css" rel="stylesheet" type="text/css" >
    <link href="../../../resources/PostEdit.css" rel="stylesheet" type="text/css" >
</head>
<body>
<%@include file="block/nav.jsp"%>

<div class="post">
    <div class="row">
        <div class="col-sm-8 col-sm-offset-2">
            <form:form class="form-horizontal" modelAttribute="posts"
                       action="/addPost/${user.id}/edit/${posts.id}" method="POST" enctype="multipart/form-data">
                <table>
                    <tr>
                        <td colspan="2" style="text-align: center"><h2>Введіть ваші зміни</h2></td>
                    </tr>
                    <tr>
                        <td><label for="name" class="control-label col-sm-2">Назва:</label></td>
                        <td><form:input type="text"   path="name" id="name" class="form-control" placeholder="Назва" /></td>
                    </tr>
                    <tr>
                        <td> <label for="text" class="control-label col-sm-2">Опис</label></td>
                        <td><form:input type="text"   path="text" id="text" class="form-control" placeholder="Назва" /></td>
                    </tr>
                    <tr>
                        <td>
                            <label for="kind">Рубрика</label>
                        </td>
                        <td>
                            <select  name="kind" id="inputState" class="form-control">
                                <option selected>Виберіть рубрику</option>
                                <option>Electronic</option>
                                <option>Car</option>
                                <option>Animal</option>
                                <option>Phone</option>
                            </select>
                        <td>
                    </tr>
                    <tr>
                        <td><label for="city" class="control-label col-sm-2">Місто:</label></td>
                        <td> <form:input type="text"   path="city" id="city" class="form-control" placeholder="Місто" /></td>
                    </tr>
                    <tr>
                        <td><label for="price" class="control-label col-sm-2">Ціна:</label></td>
                        <td><form:input type="text"   path="price" id="price" class="form-control" placeholder="Ціна" /></td>
                    </tr>

                    <tr>
                        <td><label for="file" class="control-label col-sm-2">Вибрати фото:</label></td>
                        <td> <input name="image" id="image" type="file"></td>
                    </tr>

                    <tr>
                        <td colspan="2" style="text-align: center"><button class="myButton" type="submit" >Змінити оголошення </button></td>
                    </tr>

                </table>
            </form:form>
        </div>
    </div>




</div>
</body>
</html>