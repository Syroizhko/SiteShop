<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE HTML>
<html >
<head>

    <title>B&S</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="../../resources/nav.css" rel="stylesheet" type="text/css" >
    <link href="../../resources/main.css" rel="stylesheet" type="text/css" >
</head>
<body>
<div>
<%@include file="block/nav.jsp"%>
</div>

<div class="container">

    <form:form action="/sort" method="post">
    <table border="1" class="rubrick">
    <tr>
    <td>
        <label for="kind">Шукати за рубрикою </label>
    </td>
    <td>
        <select name="kind" id="inputState" class="form-control">
            <option selected>Виберіть рубрику</option>
            <option>Electronic</option>
            <option>Car</option>
            <option>Animal</option>
            <option>Phone</option>
        </select>
    <td>

    <td class="But" colspan="3"><button  class="myButton" type="submit">Знайти</button></td>
    </tr>
    </table>

    </form:form>


    <form:form action="/find" method="post">
    <table>
    <tr>
        <td>
            <label for="username">Шукати по імені продавця</label>
        </td>
        <td>
            <input name="username" type="text" path="username" id="username" class="form-control" placeholder="Продавець"/>
        </td>
        <td class="But" colspan="3"><button  class="myButton" type="submit">Знайти</button></td>

    </tr>
    </table>
</form:form>



<div class="name">
    <h1 class="h1">Список Оголошень:</h1>
</div>

<c:forEach  var="posts" items="${posts}" >


    <div class="post">

            <table width="100%" >
                <tr>
                    <td><h2>${posts.name}</h2></td>
                    <sec:authorize  access="hasRole('ADMIN')">
                        <td class="but"> <a href="${user.id}/edit/${posts.id}">
                            <button class="btn btn-danger" type="submit">Редагувати</button>
                        </a></td>
                    </sec:authorize>
                    <sec:authorize  access="hasRole('ADMIN')">
                        <td width="10%" class="but"> <a href="/delete/${posts.id}">
                            <button class="btn btn-danger" type="submit">Видалити</button>
                        </a></td>
                    </sec:authorize>
                </tr>
            </table >
        <table width="90%" >
            <tr>
                <td width="17%" rowspan="3" ><img class="img2" width="100%" alt="Advertisement photo"  src="/images/${posts.photoUrl}">
                <td valign="top" width="8%">Опис:</td><td class="tab" valign="top" width="75%" > ${posts.text}</td>
            </tr>
            <tr>
                <td>Рубрика:</td><td>${posts.kind}</td>
            </tr>
            <tr >
                <td>Ціна:</td> <td>${posts.price}</td>
            </tr>

        </table>
        <table  width="100%">
            <tr>
                <td width="25%" >${posts.user}</td><td class="cou1" width="40%" >${user.country},${posts.city}</td><td class="dat" width="35%" >${posts.date}</td>
            </tr>

        </table>
    </div>

</c:forEach>
</div>

</body>
</html>