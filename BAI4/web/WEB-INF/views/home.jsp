<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 7/16/2019
  Time: 2:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
    <form action="/home" method="post">
        Word:<input type="text" name="inputWord" value=${dic.inputName}><br>
        <input type="submit" value="Search">
    </form>
    Result:${dic.result}
</body>
</html>
