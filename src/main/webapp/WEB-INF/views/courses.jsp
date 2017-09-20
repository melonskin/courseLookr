<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Courses</title>
    <%--<link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >--%>
</head>
<body>
    <div>
        <h1>Course search result:</h1>
        <ul>
            <c:forEach items="${coursesList}" var="course" >
                <li>
                    <a href="courses/${course.id}">${course.department} ${course.number}: ${course.name}</a>
                </li>
            </c:forEach>
        </ul>
    </div>
</body>
</html>
