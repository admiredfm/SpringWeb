
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>航班号查询</title>
</head>
<body>

<center>
<form action="flyController">
    起飞机场：<input type="text" name="takeoff"> <br> 降落机场：<input type="text" name="aerodrome"> <br>
    <input type="submit" value="查询"><br>
    航班号：
    <% if (request.getAttribute("num") != null){
      out.print(request.getAttribute("num"));
    }
        %>
</form>
</center>
</body>
</html>
