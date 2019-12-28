<%--
  Created by IntelliJ IDEA.
  User: liurenyi
  Date: 2019/10/21
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        div{border:1px solid #000;width:500px;height:300px;
            position:relative;left:500px;
        }
        p{
            position:relative;top:220px;left: 300px;
        }
        form{
            position:relative;left:130px;top:50px;
        }
    </style>
</head>
<body>
     <span>欢迎:${user.realname}<span/> <a href="/tuichu">退出登陆</a>
     <p><a href="toselectIndex" name="demo">销售</a></p>
     <p><a href="selectAllSale" name="demo">销售信息查询</a></p>
     <p><a href="selectQuantity"  name="demo">销售库存查询</a></p>
    <div>
        <form action="/InsertSale">
            <table>
                <h3>添加销售</h3>
                <tr>
                    <td>
                        商品名称:
                        <select name="productName">
                            <option value="">--请选择--</option>
                            <c:forEach items="${emps}" var="pro">
                                <option value="${pro.id}">${pro.productname}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>销售单价:<input type="text" name="price"></td>
                </tr>
                <tr>
                    <td>销售数量:<input type="text" name="quantity"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="保存"></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
