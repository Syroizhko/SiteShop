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

<div>
    <div class="row">
        <div class="col-sm-8 col-sm-offset-2">
            <form:form class="form-horizontal"
                       action="/edit/${posts.id}" modelAttribute="posts" method="POST" enctype="multipart/form-data">
                <div ><h4>Введіть ваші зміни</h4></div>
                            <div class=post>
                                <table  width="100%" >
                                    <tr>
                                        <th colspan="3"> <h1 class="h1">Редагувати оголошення</h1></th>
                                    </tr>

                                    <tr >
                                        <td valign="top" width="30" rowspan="8">
                                            <img class="img3" width="100%" alt="User photo"  src="/images/${posts.photoUrl}">
                                        </td>

                                    </tr>
                                    <tr>
                                        <td width="20%" class="td"><label for="name" class="control-label col-sm-2">Назва:</label></td>
                                        <td width="50%"  ><form:input type="text"   path="name" id="name" class="form-control" placeholder="Назва" /></td>
                                    </tr>
                                    <tr>
                                        <td class="td"><label for="text" class="control-label col-sm-2">Текст:</label></td>
                                        <td ><form:input type="text" path="text" id="text" class="form-control" placeholder="Текст" /></td>
                                    </tr>
                                    <tr>
                                        <td class="td"><label for="city" class="control-label col-sm-2">Місто:</label></td>
                                        <td> <form:input type="text" path="city" id="city" class="form-control" placeholder="Місто"/></td>
                                    </tr>
                                    <tr>
                                        <td class="td"><label for="price" class="control-label col-sm-2">Ціна:</label></td>
                                        <td> <form:input type="text" path="price" id="price" class="form-control" placeholder="Ціна" /></td>
                                    </tr>
                                    <tr>
                                        <td class="im" colspan="2"><label for="file" class="control-label col-sm-2">Виберіть фото:</label>
                                            <input name="image" id="image" type="file"></td>
                                    </tr>

                                    <tr>
                                        <td class="But" colspan="3"><button  class="myButton" type="submit">Змінити</button></td>
                                    </tr>

                                </table>
                            </div>

            </form:form>
        </div>
    </div>




</div>
</body>
</html>