<%--
  Created by IntelliJ IDEA.
  User: Shijin
  Date: 2017/9/20
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Interest: ${interest.name}</title>
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <jsp:include page="./layout/header.jsp" />

</head>
<body>
    <!-- jQuery bootstrap.min.js  -->
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

    <!-- Bootstrap  JavaScript  -->
    <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

    <div class="container">
        <h1>Interest package: ${interest.name}</h1>
        <br>
        <div>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>
                            Number
                        </th>
                        <th>
                            Course
                        </th>
                        <th>
                            Action
                        </th>
                    </tr>
                </thead>
                <c:forEach items="${courses}" var="course">
                    <tr>
                        <td>
                                ${course.department} ${course.number}
                        </td>
                        <td>
                            ${course.name}
                        </td>
                        <td>
                            <button class="btn btn-info"
                                    style="float: left;margin-right:5px;margin-bottom: 0px" onclick="location.href='/courses/${course.id}'">View</button>
                            <form class="form-inline form-group" style="float: left;margin-right:5px;margin-bottom: 0px" action='/interestCourse/${interest.id}_${course.id}/delete' method="post">
                                <button name="deleteRelation" value="delete" class="btn btn-danger">
                                    Delete
                                </button>
                            </form>

                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="row col-md-6 col-md-offset-3">
            <hr>
            <h3>Add a course: </h3>
            <form class="form-horizontal" action="/interestCourse/${interest.id}" method="POST" name="courseForm">
                <label class="col-sm-2 control-label">Department<br></label>
                <div class="col-sm-10">
                    <input type="text" name="department" class="form-control" placeholder="like CSCE">
                    <br>
                </div>
                <br>
                <label class="col-sm-2 control-label">Number<br></label>
                <div class="col-sm-10">
                    <input type="text" name="number" class="form-control" placeholder="like 608">
                    <br>
                </div>
                <br>
                <div class="form-group">
                    <div class="col-sm-10  col-sm-offset-5">
                        <br>
                        <button type="submit" class="btn btn-primary">Add
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>

</body>
</html>
