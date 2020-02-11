<%@ page contentType="text/html; UTF-8" pageEncoding="utf-8"  language="java" isELIgnored="false" %>
<html>
<body>
<h2>Hello World!</h2>
</body>

<form action="${pageContext.request.contextPath}/login1.action" method="post">
    <input type="text" name="username">
    <input type="text" name="password">
    <input type="text" name="birth">
    <input type="submit" value="提交">
</form>

<form action="${pageContext.request.contextPath}/login5.action" method="post">
    <input type="text" name="teacher.username">
    <input type="text" name="teacher.password">
    <input type="submit" value="提交">
</form>

<form action="${pageContext.request.contextPath}/login6.action" method="post">
    <input type="checkbox" name="id" value="1">
    <input type="checkbox" name="id" value="2">
    <input type="checkbox" name="id" value="3">
    <input type="checkbox" name="id" value="4">
    <input type="submit" value="提交">
</form>

<form action="${pageContext.request.contextPath}/login7.action" method="post">
    <input type="text" name="users[0].username"><br>
    <input type="text" name="users[0].password"><br>
    <hr>
    <input type="text" name="users[1].username"><br>
    <input type="text" name="users[1].password"><br>
    <hr>
    <input type="text" name="users[2].username"><br>
    <input type="text" name="users[2].password"><br>
    <hr>
    <input type="text" name="users[3].username"><br>
    <input type="text" name="users[3].password"><br>
    <hr>
    <input type="submit" value="提交">
</form>

<form action="${pageContext.request.contextPath}/file.action" method="post" enctype="multipart/form-data">
    <input type="file" name="file">
    <input type="submit" value="上传">
</form>


</html>
