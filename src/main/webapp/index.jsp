<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>JavaRush Quest</title>
</head>
<body>
<br>
<h1><%= "Welcome!" %>
</h1>
<br/>
<h1><%="Пройди тест!"%></h1>
<p>
    Знакомство с экипажем
    <br/>
    Вспомни как тебя зовут
</p>
<form class="form-horizontal" action="create" method="get">
    <div class="row g-4 py-5 row-cols-1 row-cols-lg-3">
        <label class="col-md-4 control-label" for="name">Имя:</label>
        <div class="col-md-4">
            <div class="g-4 py-5 row-cols-1 row-cols-lg-3">
                <input id="name" name="name" type="text" placeholder="Введите имя" class="form-control input-md">
            </div>
            <br/>
            <div class="form-group">
                <label class="col-md-4 control-label" for="submit"></label>
                <div class="col-md-4">
                    <button id="submit" class="btn btn-success">Играть</button>
<%--                    <button id="reset-button" class="btn btn-success">Стоп</button>--%>
                    <br/>
                    <br/>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>