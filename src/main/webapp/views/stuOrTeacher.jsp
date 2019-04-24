<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fm
  Date: 19-4-24
  Time: 下午10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生名字</title>


</head>
<body>

<form action="findname">

    <input type="radio" value="2" checked name="line">2&nbsp;&nbsp;
    <input type="radio" value="3"  name="line">3&nbsp;&nbsp;
    <input type="radio" value="4" name="line">4&nbsp;&nbsp;<br>
    学生姓名：<input type="text" value="${requestScope.stuname}" name="stuname"><br>
    老师姓名：<input type="text" value="${requestScope.teachername}" name="teachername"><br>
    <input type="submit" value="查询">
    <p></p>
    <table border="1" cellspacing="0">
        <tr>
            <td>编号</td>
            <td>学生姓名</td>
            <td>年龄</td>
            <td>任课老师</td>
        </tr>
    <c:forEach var="i" items="${requestScope.list}">
        <tr>
            <td>${i.getId()}</td>
            <td>${i.getStuName()}</td>
            <td>${i.getAge()}</td>
            <td>${i.getTeacherName()}</td>
        </tr>
    </c:forEach>
    </table>
</form>



</body>
</html>
