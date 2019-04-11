<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

Hello, ${name}

<form action="/calc" method="get">
    <input name="num1" type="number" placeholder="num 1" />
    <select name="type">
        <option>+</option>
        <option>-</option>
        <option>*</option>
        <option>/</option>
        <option>%</option>
    </select>
    <input name="num2" type="number" placeholder="num 2"/>
    <input type="submit" value="submit"/>
</form>
<form action="/user">
    <input name="name" type="text" placeholder="Input name"/>
    <input type="submit" value="submit"/>
</form>

<c:forEach items="${history}" var="item">
    ${item}
    <br>
</c:forEach>

</body>
</html>
