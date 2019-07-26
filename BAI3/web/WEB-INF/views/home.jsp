<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 7/16/2019
  Time: 1:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Convert</title>
</head>
<body>
    <form action="/convert" method="post">
        Tien: <input type="text" name="inputName" value=${inputName} >
        <input type="submit" value="Convert">
    </form>
    Result: ${convert}
</body>
</html>
