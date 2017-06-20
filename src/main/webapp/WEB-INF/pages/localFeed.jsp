<%--
  Created by IntelliJ IDEA.
  User: suruchi
  Date: 19/4/16
  Time: 11:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>



  <c:forEach items="${object}" var="object1">
  <td>${object1.name}    </td>${object1.dist}<br>
  </c:forEach>


  <%--<p id="demo"></p>--%>
  <%--<script>--%>
  <%--var items;--%>
   <%--var text = "";--%>
  <%--var i;--%>
  <%--var object ="${object}"--%>
  <%--for (i = 0; i < object.length; i++) {--%>
      <%--text += object[i].name + "<br>";--%>
  <%--}--%>

  <%--document.getElementById("demo").innerHTML = text;--%>
  <%--</script>--%>


</body>
</html>
