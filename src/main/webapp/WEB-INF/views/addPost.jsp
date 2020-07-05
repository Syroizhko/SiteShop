
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html >
<head>

    <title>Додати оголошення</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="../../resources/nav.css" rel="stylesheet" type="text/css" >
    <link href="../../resources/addPost.css" rel="stylesheet" type="text/css" >
</head>
<body>

<%@include file="block/nav.jsp"%>

<div >
    <div class="row">
        <div >
            <form:form class="form-horizontal"
                       action="/addPost/${user.id}" method="POST" enctype="multipart/form-data">
            <div class="post1">
                <div ><h1 class="h1">Заповніть всі поля</h1></div>

                <table width="100%" >
                    <tr>
                        <td width="40%"><label for="text" class="control-label col-sm-2">Назва:</label></td>
                    <td width="60%"> <input type="text" name="name" placeholder="Назва:" /></td>
                    </tr>
                    <tr>
                        <td><label for="name" class="control-label col-sm-2">Текст:</label></td>
                        <td><input type="text" name="text" placeholder="Текст"></td>
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
                        <td> <input type="text" name="city" placeholder="Місто:" /></td>
                    </tr>
                    <tr>
                        <td><label for="price" class="control-label col-sm-2">Ціна:</label></td>
                        <td><input type="text" name="price" placeholder="Ціна:" /></td>
                    </tr>
                    <tr>
                    <td class="im" colspan="2"><label for="file" class="control-label col-sm-2">Виберіть фото:</label>
                        <input name="image" id="image" type="file"></td>
                    </tr>
                    <tr>
                        <td class="But" valign="bottom" colspan="2"><button class="myButton" type="submit">Опублікувати </button></td>
                </tr>
                </table>
            </form:form>
        </div>
    </div>


        <c:forEach  var="posts" items="${posts}" >
        <div class="post">

           <table width="100%">
               <tr>
                   <td><h2>${posts.name}</h2></td>
                   <td class="but"> <a href="/addPost/${user.id}/delete/${posts.id}">
                       <button class="btn btn-danger" type="submit">Видалити</button>
                   </a></td>
               </tr>

           </table>

        <table width="90%" >
            <tr>
                <td width="17%" rowspan="2" ><img class="img2" width="100%" alt="Advertisement photo"  src="/images/${posts.photoUrl}">
                <td valign="top" width="8%">Опис:</td><td class="tab" valign="top" width="75%" > ${posts.text}</td>
            </tr>
            <tr>
                <td>Ціна:</td> <td>${posts.price}</td>
            </tr>

        </table>
        <table  width="100%">
            <tr>
                <td width="25%" ><a href="/addPost/${user.id}/edit/${posts.id}">
                    <button class="btn btn-danger" type="submit">Редагувати</button>
                </a></td><td class="cou1" width="40%" >${user.country},${posts.city}</td><td class="dat" width="35%" >${posts.date}</td>
            </tr>

        </table>
    </div>
    </div>

    </c:forEach>

</body>
</html>