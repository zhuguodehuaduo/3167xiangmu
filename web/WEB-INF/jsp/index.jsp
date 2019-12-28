<%--
  Created by IntelliJ IDEA.
  User: liurenyi
  Date: 2019/10/21
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        div{
            width: 500px;
            height: 200px;
            background-color:forestgreen;
            margin: auto;
            position: absolute;
            top: 0;
            bottom: 0;
            left: 0;
            right: 0;


            text-align:center;

            display: table-cell;
            vertical-align:middle
        }
    </style>
</head>
<body>
    <form action="/selectIndex">
       <div>
           <h2>小型进销系统</h2>
           <p>用户名:<input type="text" name="username"></p>
           <p>密  码:<input type="text" name="password"></p>
           <p><input type="submit" value="登陆"></p>
       </div>
    </form>
</body>
</html>
