<%--
  Created by IntelliJ IDEA.
  User: Shijin
  Date: 2017/9/17
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>${course.department} ${course.number} ${course.name}</title>
</head>
<body>
    <div>
        <h1>${course.department} ${course.number} ${course.name}</h1>
        <p>Credit: ${course.credit}</p>
        <p>${course.description}</p>
    </div>
</body>
</html>
