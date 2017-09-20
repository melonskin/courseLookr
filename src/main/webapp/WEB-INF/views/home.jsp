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
<%@ page isELIgnored="false" %>

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

    <!-- jQuery bootstrap.min.js  -->
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

    <!-- Bootstrap  JavaScript  -->
    <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

    <div>
        <h2>Search a course: </h2>
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

    <div>
        <h2>Look for course based on programs: </h2>
        <ul>
            <c:forEach items="${programs}" var="program">
                <li>
                    <a href="/program/${program.id}">
                        ${program.name} (${program.acronym})
                    </a>
                </li>
            </c:forEach>
        </ul>
    </div>

</body>
</html>
