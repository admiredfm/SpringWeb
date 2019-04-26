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
    <script src="https://lib.sinaapp.com/js/jquery/2.0.2/jquery-2.0.2.min.js"></script>
</head>
<body count="${requestScope.count}" start="${requestScope.start}" end="${requestScope.end}">
<form>
    <input type="radio" value="2"
           <c:if test="${requestScope.line != 3 || requestScope.line != 4}">checked</c:if> name="line">2&nbsp;&nbsp;
    <input type="radio" value="3"
           <c:if test="${requestScope.line == 3}">checked</c:if> name="line">3&nbsp;&nbsp;
    <input type="radio" value="4"
           <c:if test="${requestScope.line == 4}">checked</c:if> name="line">4&nbsp;&nbsp;<br>
    学生姓名：<input type="text" id="sname" value="${requestScope.stuname}" name="stuname"><br>
    老师姓名：<input type="text" id="tname" value="${requestScope.teachername}" name="teachername"><br>
    <button id="ca" value="">查询</button>
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
    <button id="sbut" value="">上一页</button>
    &nbsp;&nbsp;&nbsp;&nbsp;
    <button id="xbut" value="">下一页</button>
</form>
<script>
    $(function () {
        $("#sbut").click(function () {
            var body = $("body");
            var count = body.attr("count");
            var start = body.attr("start");
            var end = body.attr("end");
            var line = $("input[name='line']:checked").val();
            if (end > line) {
                $.get("next", {
                    'count': count,
                    'start': start,
                    'end': end,
                    'line': line,
                    'flag': "upPage"
                }, function () {
                    window.location.replace("http://localhost:8080/SpringWeb_war_exploded/next?start=" + start + "&end=" + end + "&line=" + line + "&flag=upPage");
                });
            }
            return false;
        });
        $("#xbut").click(function () {
            var body = $("body");
            var count = body.attr("count");
            var start = body.attr("start");
            var end = body.attr("end");
            var line = $("input[name='line']:checked").val();
            if (end < count) {
                $.get("next", {
                    'count': count,
                    'start': start,
                    'end': end,
                    'line': line,
                    'flag': "nextPage"
                }, function () {
                    window.location.replace("http://localhost:8080/SpringWeb_war_exploded/next?start=" + start + "&end=" + end + "&line=" + line + "&flag=nextPage");
                });
            }
            return false;
        });
        $("#ca").click(function () {
            var body = $("body");
            var count = body.attr("count");
            var line = $("input[name='line']:checked").val();
            var stuname = $("#sname").val();
            var teachername = $("#tname").val();
            $.get('next', {
                'count': count,
                'stuname': stuname,
                'teachername': teachername,
                'line': line,
                'flag': "ca"
            }, function (data) {
                window.location.replace("http://localhost:8080/SpringWeb_war_exploded/next?count=" + count + "&stuname=" + stuname + "&teachername=" + teachername + "&line=" + line + "&flag=ca");
            });
            return false;
        })
    });
</script>


</body>
</html>
