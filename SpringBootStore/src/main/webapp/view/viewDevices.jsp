<%--
  Created by IntelliJ IDEA.
  User: Duc
  Date: 27/06/2023
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>View available of ${devices.brandName}</title>
</head>
<body>

<h3>List of available ${devices.brandName}</h3>
<hr>
<ul>
<c:forEach items="${devices.devices}" var="device">
    <li>ID: ${device.id}, Name: ${device.name}, Type: ${device.type}</li>
</c:forEach>
</ul>
</body>
</html>
