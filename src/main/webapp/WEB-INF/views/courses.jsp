<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Courses</title>
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <jsp:include page="./layout/header.jsp" />

<%--<link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >--%>
</head>
<body>
    <!-- jQuery bootstrap.min.js  -->
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

    <!-- Bootstrap  JavaScript  -->
    <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <div class="container">
        <h1>Course search result:</h1>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Department</th>
                <th>Number</th>
                <th>Course</th>
                <th>Credit</th>
                <th>Action</th>
            </tr>
            </thead>
            <c:forEach items="${coursesList}" var="course" >
                <tr>
                    <td>
                        ${course.department}
                    </td>
                    <td>
                        ${course.number}
                    </td>
                    <td>
                        ${course.name}
                    </td>
                    <td>
                        ${course.credit}
                    </td>
                    <td>
                        <button class="btn btn-info"
                                onclick="location.href='/courses/${course.id}'">View</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
