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
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <jsp:include page="./layout/header.jsp" />

</head>
<body>
    <!-- jQuery bootstrap.min.js  -->
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

    <!-- Bootstrap  JavaScript  -->
    <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <div class="container">
        <h1>${program.name} (${program.acronym})</h1>

        <div  class="row col-md-6 col-md-offset-3">
            <br>
            <h2>Required course packages: </h2>
            <c:if test = "${packages.size()==0}">
                <p>No required packages for this program.</p>
            </c:if>
            <c:if test="${packages.size()>0}">
                <ul  class="list-group">
                    <c:forEach items="${packages}" var="packagec">
                        <li class="list-group-item text-center">
                            <a href="/package/${packagec.id}">
                                    ${packagec.name}
                            </a>
                        </li>
                    </c:forEach>
                </ul>
            </c:if>

            <br>
            <hr>
            <h2>Course packages based on interest: </h2>
            <c:if test = "${interests.size()==0}">
                <p>No interest packages for this program.</p>
            </c:if>
            <ul  class="list-group">
                <c:forEach items="${interests}" var="interest">
                    <li class="list-group-item text-center">
                        <a href="/interest/${interest.id}">
                                ${interest.name}
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>


</body>
</html>
