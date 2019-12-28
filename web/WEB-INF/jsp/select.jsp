<%--
  Created by IntelliJ IDEA.
  User: liurenyi
  Date: 2019/10/22
  Time: 15:35
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
            position:relative;left:70px;
        }
    </style>
</head>
<body>
   <span>欢迎:${user.realname}<span/> <a href="/tuichu">退出登陆</a>
    <p><a href="toselectIndex" name="demo">销售</a></p>
    <p><a href="selectAllSale" name="demo">销售信息查询</a></p>
    <p><a href="selectQuantity"  name="demo">销售库存查询</a></p>
   <div>
       <form action="/selectAllSale" method="post">
           <h2>销售信息查询</h2>
           排序方式：
           <select name="orderby">
               <option value="0"
                       <c:if test="${orderby==0}">
                           selected
                       </c:if>
               >销售日期</option>

               <option value="1"
                       <c:if test="${orderby==1}">
                           selected
                       </c:if>
               >单笔总价</option>
           </select>
           <input type="submit" value="提交" />
           <table border="1">
               <tr>
                   <td>ID</td>
                   <td>商品</td>
                   <td>单价</td>
                   <td>数量</td>
                   <td>总价</td>
                   <td>销售日期</td>
                   <td>销售人</td>
               </tr>
               <c:forEach items="${select}" var="sale">
                   <tr>
                       <td>${sale.id}</td>
                       <td>${sale.productid.productname}</td>
                       <td>${sale.price}</td>
                       <td>${sale.quantity}</td>
                       <td>${sale.totalprice}</td>
                       <td>${sale.saleDate}</td>
                       <td>${sale.userid.realname}</td>
                   </tr>
               </c:forEach>
               <tr >
                   <td colspan="7">
                       <a href="selectAllSale?pageNum=1">首页</a>
                       <a href="selectAllSale?pageNum=${pageNum-1}">上一页</a>|
                       <a href="selectAllSale?pageNum=${pageNum+1}">下一页</a>|
                       <a href="selectAllSale?pageNum=${end}">末页</a>
                       第${pageNum}页/共${end}页(${totalItems}条记录)
                   </td>
               </tr>
           </table>
       </form>
   </div>
</body>
</html>
