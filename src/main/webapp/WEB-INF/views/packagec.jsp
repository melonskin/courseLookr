<%--
  Created by IntelliJ IDEA.
  User: Shijin
  Date: 2017/9/20
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Package: ${packagec.name} for ${program.acronym}</title>
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <jsp:include page="./layout/header.jsp" />

</head>
<body>
    <!-- jQuery bootstrap.min.js  -->
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

    <!-- Bootstrap  JavaScript  -->
    <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

    <div class="container">
        <h1>Required package for ${program.acronym}: ${packagec.name}</h1>
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
                            <a href="/courses/${course.id}">${course.name}</a>
                        </td>
                        <td>
                            <button class="btn btn-danger"
                                    onclick="this.disabled=true;post('/courseInterest/${course.id}_${packagec.id}/delete')">
                                Delete
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>
