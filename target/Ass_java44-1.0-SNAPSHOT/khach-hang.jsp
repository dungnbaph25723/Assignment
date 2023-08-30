<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 27/07/2023
  Time: 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body class="container">
<form action="/updateKH" method="post">


    <div class="mb-3">
        <label class="form-label">Ma</label>
        <input type="text" class="form-control" name="ma">
    </div>
    <div class="mb-3">
        <label class="form-label">Ten</label>
        <input type="text" class="form-control" name="ten">
    </div>
    <div class="mb-3">
        <label class="form-label">ten dem</label>
        <input type="text" class="form-control" name="tenDem">
    </div>
    <div class="mb-3">
        <label class="form-label">Ho</label>
        <input type="text" class="form-control" name="ho">
    </div>
    <div class="mb-3">
        <label class="form-label">Ngay SInh</label>
        <input type="text" class="form-control" name="ngaySinh">
    </div>

    <div class="mb-3">
        <label class="form-label">So dien thoai</label>
        <input type="text" class="form-control" name="sdt">
    </div>

    <div class="mb-3">
        <label class="form-label">Dia chi</label>
        <input type="text" class="form-control" name="diaChi">
    </div>

    <div class="mb-3">
        <label class="form-label">thanh pho</label>
        <input type="text" class="form-control" name="thanhPho">
    </div>

    <div class="mb-3">
        <label class="form-label">Quoc Gia</label>
        <input type="text" class="form-control" name="quocGia">
    </div>

    <div class="mb-3">
        <label class="form-label">mat khau</label>
        <input type="text" class="form-control" name="mauKhau">
    </div>


    <button class="btn btn-primary">
        update
    </button>
</form>
<h1 style="text-align: center">Danh sach san pham</h1>

<table class="table">
    <thead>
    <tr>
        <td>id</td>
        <td>ma</td>
        <td>ten</td>
        <td>ten dem</td>
        <td>ho</td>
        <td>ngay sinh</td>
        <td>so dien thoai</td>
        <td>dia chi</td>
        <td>thanh pho</td>
        <td>quoc gia</td>
        <td>mat khau</td>



    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listKH}" var="kh">
        <tr>
            <td>${kh.id}</td>
            <td>${kh.ma}</td>
            <td>${kh.ten}</td>
            <td>${kh.tenDem}</td>
            <td>${kh.ho}</td>
            <td>${kh.ngaySinh}</td>
            <td>${kh.sdt}</td>
            <td>${kh.diaChi}</td>
            <td>${kh.thanhPho}</td>
            <td>${kh.quocGia}</td>
            <td>${kh.matKhau}</td>
            <td>
                <a class="btn btn-primary" href="/detailKH?id=${kh.id}">detail</a>
                <a class="btn btn-primary" href="/deleteKH?id=${kh.id}">delete</a>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>

</body>
</html>