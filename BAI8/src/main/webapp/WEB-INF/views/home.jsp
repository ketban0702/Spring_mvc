<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 7/21/2019
  Time: 4:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/detail" method="post">
    <div class="form-check">
        <label class="form-check-label">
            <input type="checkbox" class="form-check-input" name="favorite" value="Lettuce">Lettuce
        </label>
    </div>
    <div class="form-check">
        <label class="form-check-label">
            <input type="checkbox" class="form-check-input" name="favorite" value="Tomato">Tomato
        </label>
    </div>
    <div class="form-check">
        <label class="form-check-label">
            <input type="checkbox" class="form-check-input" name="favorite" value="Mustard">Mustard
        </label>
    </div>
    <div class="form-check">
        <label class="form-check-label">
            <input type="checkbox" class="form-check-input" name="favorite" value="Sprouts">Sprouts
        </label>
    </div>
    <button type="submit" class="btn btn-primary">Ok</button>
</form>
</body>
</html>
