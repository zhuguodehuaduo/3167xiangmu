<%--
  Created by IntelliJ IDEA.
  User: liurenyi
  Date: 2019/10/25
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        div{
            border:1px solid #000;
            width:500px;
            height:300px;
            position:relative;left:500px;
            display:table-cell;
            text-align:center;
            vertical-align:middle;
        }
        p{
            position:relative;top:220px;left: 300px;
        }

    </style>
</head>
<body>
    <span>欢迎:${user.realname}<span/> <a href="/tuichu">退出登陆</a>
    <p><a href="toselectIndex" name="demo">销售</a></p>
    <p><a href="selectAllSale" name="demo">销售信息查询</a></p>
    <p><a href="selectQuantity"  name="demo">销售库存查询</a></p>
    <div>
        <h1>欢迎使用小型进销系统</h1>
    </div>
</body>
</html>
