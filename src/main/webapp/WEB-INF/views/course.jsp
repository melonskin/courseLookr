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
        <a href="/courses/${course.id}/edit">Edit</a>
    </div>

    <h2>Previous sections: </h2>
    <div>
        <table width="80%" border = "1">
            <tr>
                <th>Section</th>
                <th>Instructor</th>
                <th>Term</th>
                <th>Year</th>
                <th>GPA</th>
                <th>No. students</th>
                <th>A %</th>
                <th>B %</th>
                <th>C %</th>
                <th>D %</th>
                <th>F %</th>
                <th>Q drop %</th>
            </tr>
            <c:forEach items="${sections}" var="section" >
                <tr>
                    <td>
                        ${section.number}
                    </td>
                    <td>
                        ${section.instructor}
                    </td>
                    <td>
                        ${section.term}
                    </td>
                    <td>
                        ${section.year}
                    </td>
                    <td>
                        ${section.gpa}
                    </td>
                    <td>
                        ${section.student}
                    </td>
                    <td>
                        ${section.a}
                    </td>
                    <td>
                        ${section.b}
                    </td>
                    <td>
                        ${section.c}
                    </td>
                    <td>
                        ${section.d}
                    </td>
                    <td>
                        ${section.f}
                    </td>
                    <td>
                        ${section.q}
                    </td>
                </tr>
            </c:forEach>
        </table>

    </div>
</body>
</html>
