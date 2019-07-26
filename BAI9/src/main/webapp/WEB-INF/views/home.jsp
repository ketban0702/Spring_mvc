<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 7/21/2019
  Time: 4:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>${result1}</h1><br>
<form  action="/homes" method="post" >
    <input type="number"  name="number1" value=${num1}>
    <input type="number"  name="number2" value=${num2}> <br>
    <button type="submit"  name="add">addition(+)</button>
    <button type="submit"  name="sub">Subtraction(-)</button>
    <button type="submit"  name="mul">Multiplication(x)</button>
    <button type="submit"  name="div">Division(/)</button>
</form>
    <h1>Result: ${result}</h1>
</body>
</html>
