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
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <jsp:include page="./layout/header.jsp" />

</head>
<body>

    <!-- jQuery bootstrap.min.js  -->
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

    <!-- Bootstrap  JavaScript  -->
    <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

    <div class="container">
        <div  class="row ">
            <h2>Update info for ${course.department} ${course.number} ${course.name}</h2>
            <br>
            <div class="text-center">
                <ul  class="list-group">
                    <c:forEach items="${errors}" var="error">
                        <li class="list-group-item">
                    <span style="color:red">
                            ${error.defaultMessage}
                    </span>
                        </li>
                    </c:forEach>
                </ul>
                <br>
                <br>
            </div>
            <div class="col-md-6 col-md-offset-3">
                <form:form  class="form-horizontal" method="POST" modelAttribute="course" align="center">

                    <%--Name:<form:input id = "name" path="name" /><br>--%>

                    <%--Credit:<form:input id = "credit" path="credit" /><br>--%>

                    <%--Description:<form:textarea id = "desc" path="description" style="height:100px;width:300px;"/><br>--%>

                    <%--<br>--%>
                    <%--<input type="submit" value="Update" />--%>

                    <label class="col-sm-2 control-label">Name<br></label>
                    <div class="col-sm-10">
                        <form:input id="name" class="form-control" path="name"/>
                        <br>
                    </div>

                    <label class="col-sm-2 control-label">Credit<br></label>
                    <div class="col-sm-10">
                        <form:input id="credit" class="form-control" path="credit"/>
                        <br>
                    </div>

                    <label class="col-sm-2 control-label">Description<br></label>
                    <div class="col-sm-10">
                        <form:textarea id="desc" class="form-control" path="description"/>
                        <br>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-10 col-sm-offset-5">
                            <br>
                            <input type="submit" value="Update" class="btn btn-primary"/>
                        </div>
                    </div>

                </form:form>
            </div>
        </div>

    </div>


</body>
</html>
