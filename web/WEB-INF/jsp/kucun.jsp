<%--
  Created by IntelliJ IDEA.
  User: liurenyi
  Date: 2019/10/22
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        div{
            border:1px solid #000;width:500px;height:300px;
            position:relative;left:500px;
        }
        p{
            position:relative;top:220px;left: 300px;
        }
       /*span{text-align:center;display:block;size: A3;}*/
        #shangpin{position:relative;left:170px;}
        #shuliang{
            position:relative;top:150px;right:100px;
        }
    </style>
</head>
<body>
     <span id="huanying">欢迎:${user.realname}<span/> <a href="/tuichu">退出登陆</a>
        <p><a href="toselectIndex" name="demo">销售</a></p>
        <p><a href="selectAllSale" name="demo">销售信息查询</a></p>
        <p><a href="selectQuantity"  name="demo">销售库存查询</a></p>
    <div>
        <form action="/selectQuantity">
            <strong>查看库存:</strong>
            <span id="shangpin">
                商品名称:
                <select name="productname">
                <option value="">--请选择--</option>
                <c:forEach items="${list}" var="pro">
                    <option value="${pro.id}">${pro.productname}</option>
                </c:forEach>
                </select>
            <input type="submit" value="查看">
            </span>
            <strong id="shuliang">剩余数量:${kucun}</strong>
        </form>
    </div>
</body>
</html>
