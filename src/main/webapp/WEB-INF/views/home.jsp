<%--
  Created by IntelliJ IDEA.
  User: Shijin
  Date: 2017/9/16
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>CourseLookr</title>

    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <%--<link rel="stylesheet"--%>
    <%--type="text/css"--%>
    <%--href="<c:url value="/resources/style.css" />" >--%>
</head>
<body>
    <h1>Welcome to CourseLookr</h1>

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

    <%--<a href="<c:url value="/spittles" />">Spittles</a> |--%>
    <%--<a href="<c:url value="/spitter/register" />">Register</a>--%>
    <div>
        <h1>Search a course: </h1>
        <form method="POST" name="courseForm">
            Department: <input type="text" name="department">
            <br>
            Number:     <input type="text" name="number">
            <br>
            Name:       <input type="text" name="name">
            <br>
            <input type="submit" value="Search"/>
        </form>
    </div>

</body>
</html>
