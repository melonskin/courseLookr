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

    <link rel="stylesheet"
    type="text/css"
    href="<c:url value="/resources/style.css" />" >
</head>
<body>
    <!-- jQuery bootstrap.min.js  -->
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

    <!-- Bootstrap  JavaScript  -->
    <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <div class="container">
        <h1>Welcome to CourseLookr</h1>
        <br>
        <br>

        <div class="row col-md-6 col-md-offset-3">
            <h2>Search a course: </h2>
            <form class="form-horizontal" method="POST" name="courseForm">
                <label class="col-sm-2 control-label">Department<br></label>
                <div class="col-sm-10">
                    <input type="text" name="department" class="form-control" placeholder="CSCE">
                    <br>
                </div>
                <br>
                <label class="col-sm-2 control-label">Number<br></label>
                <div class="col-sm-10">
                    <input type="text" name="number" class="form-control" placeholder="608">
                    <br>
                </div>
                <br>
                <label class="col-sm-2 control-label">Name<br></label>
                <div class="col-sm-10">
                    <input type="text" name="name" class="form-control" placeholder="Database">
                    <br>
                </div>
                <br>
                <div class="form-group">
                    <div class="col-sm-10  col-sm-offset-5">
                        <br>
                        <button type="submit" class="btn btn-primary">Search
                        </button>
                    </div>
                </div>
            </form>
            <br>
            <hr>
            <h2>Courses related to programs: </h2>

            <table  class="table table-striped">
                <thead>
                    <tr>
                        <th>
                            Name
                        </th>
                        <th>
                            Acronym
                        </th>
                    </tr>
                </thead>
                <c:forEach items="${programs}" var="program">
                    <tr>
                        <td>
                            <a href="/program/${program.id}">
                                    ${program.name}
                            </a>
                        </td>
                        <td>
                            ${program.acronym}
                        </td>

                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>


</body>
</html>
