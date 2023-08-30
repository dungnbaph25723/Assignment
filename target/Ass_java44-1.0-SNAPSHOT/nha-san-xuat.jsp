<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 22/7/2023
  Time: 12:14 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body class="container">
<form action="/addNSX"method="post">

    <div class="mb-3">
        <label class="form-label">Ma</label>
        <input type="text" class="form-control" name="ma">
    </div>
    <div class="mb-3">
        <label class="form-label">ten</label>
        <input type="text" class="form-control"name="ten">
    </div>

    <button class="btn btn-primary">
        Add
    </button>
</form>
<h1 style="text-align: center">Danh sach san pham</h1>

<table class="table">
    <thead>
    <tr>
        <td>Id</td>
        <td>Ma</td>
        <td>Ten</td>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listNSX}" var="nsx">
        <tr>
            <td>${nsx.id}</td>
            <td>${nsx.ma}</td>
            <td>${nsx.ten}</td>
            <td>
                <a class="btn btn-primary" href="/detailNSX?id=${nsx.id}">detail</a>
                <a class="btn btn-primary" href="/deleteNSX?id=${nsx.id}">delete</a>
            </td>

        </tr>
    </c:forEach>

    </tbody>
</table>

</body>
</html>
