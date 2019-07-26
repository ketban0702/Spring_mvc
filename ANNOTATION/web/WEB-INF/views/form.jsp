<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 7/17/2019
  Time: 3:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form</title>
</head>
<body>
    <form action="/sent" method="post">
      Name:  <input type="text" name="inputName" value="${name1}"><br>
        Age:  <input type="text" name="inputAge" value="${age1}"><br>
        <input type="submit" value="Send">
    </form>
        Name: ${name} <br>
        Age:${age}

</body>
</html>
