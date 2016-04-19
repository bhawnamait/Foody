<%--
  Created by IntelliJ IDEA.
  User: bhawna
  Date: 19/04/16
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Restaurant</title>
</head>
<body>
<form  action="/restaurant/addNew" method="post">
    <label>
        Name:
        <input type="text" name="name" id="name">

    </label>
    <label>
        Lat:
        <input type="text" name="lat" id="lat">
    </label>
    <label>
        Lon:
        <input type="text" name="lon" id="lon">
    </label>
    <input type="submit" value="Submit">
</form>
</body>
</html>

