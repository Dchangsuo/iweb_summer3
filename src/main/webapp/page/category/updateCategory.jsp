<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2022/8/11
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../include/header.jsp" />
    <h3>编辑商品信息</h3>
    <form action="updateCategoryServlet" method="post">
        编号：<input name="id" value="${category.id}"><br/>
        分类名称：<input name="name" value="${category.name}"><br/>
        <button>保存</button>
    </form>
</body>
</html>
