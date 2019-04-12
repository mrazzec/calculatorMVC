<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

Hello, ${name}

<form action="/calc" method="get">
    <input name="num1" type="number" placeholder="Input num 1" />
    <select required name="type">
        <option selected disabled>Выбор</option>
        <option value="SUM">+</option>
        <option value="SUB">-</option>
        <option value="MULT">*</option>
        <option value="DIV">/</option>
    </select>
    <input name="num2" type="number" placeholder="Input num 2"/>
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
