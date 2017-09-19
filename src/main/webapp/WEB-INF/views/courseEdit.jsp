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
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>${course.department} ${course.number} ${course.name}</title>
</head>
<body>
    <h2>Update info for ${course.department} ${course.number} ${course.name}</h2>
    <div>
        <form:form method="POST" modelAttribute="course">
            <%--Department:<form:input path="department" /><br>--%>
            <%--Number:<form:input path="number" /><br>--%>
            Name:<form:input id = "name" path="name" /><br>

            Credit:<form:input id = "credit" path="credit" /><br>

            Description:<form:textarea id = "desc" path="description" style="height:100px;width:300px;"/><br>

            <br>
            <input type="submit" value="Update" />
        </form:form>
    </div>

</body>
</html>
