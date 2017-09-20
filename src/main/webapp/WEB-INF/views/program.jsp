<%--
  Created by IntelliJ IDEA.
  User: Shijin
  Date: 2017/9/20
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>${program.name}</title>
</head>
<body>
    <h1>${program.name} (${program.acronym})</h1>

    <div>
        <h2>Required course packages: </h2>
        <c:if test = "${packages.size()==0}">
            <p>No required packages for this program.</p>
        </c:if>
        <c:if test="${packages.size()>0}">
            <ul>
                <c:forEach items="${packages}" var="packagec">
                    <li>
                        <a href="/package/${packagec.id}">
                                ${packagec.name}
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </c:if>
    </div>

    <div>
        <h2>Selected course packages based on interest: </h2>
        <c:if test = "${interests.size()==0}">
            <p>No interest packages for this program.</p>
        </c:if>
        <ul>
            <c:forEach items="${interests}" var="interest">
                <li>
                    <a href="/interest/${interest.id}">
                            ${interest.name}
                    </a>
                </li>
            </c:forEach>
        </ul>
    </div>

</body>
</html>
