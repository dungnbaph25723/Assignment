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
<form action="/addNV" method="post">
    <div class="mb-3">
        <label class="form-label">ID Sản phầm</label><br/>
        <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" name="idCH">
            <c:forEach items="${listCH}" var="ch">
                <option value="${ch.id}">${ch.ten}</option>

            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label class="form-label">ID nha san xuat</label><br/>
        <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" name="idCV">
            <c:forEach items="${listCV}" var="cv">
                <option value="${cv.id}">${cv.ten}</option>

            </c:forEach>
        </select>
    </div>


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
        <input type="text" class="form-control" name="denDem">
    </div>
    <div class="mb-3">
        <label class="form-label">Ho</label>
        <input type="text" class="form-control" name="ho">
    </div>
    <div class="mb-3">
        <label class="form-label">Gioi tinh</label>
        <input type="text" class="form-control" name="gioiTinh">
    </div>

    <div class="mb-3">
        <label class="form-label">Ngay Sinh</label>
        <input type="text" class="form-control" name="ngaySinh">
    </div>

    <div class="mb-3">
        <label class="form-label">SDt</label>
        <input type="text" class="form-control" name="sdt">
    </div>

    <div class="mb-3">
        <label class="form-label">Mat Khau</label>
        <input type="text" class="form-control" name="matKhau">
    </div>

    <div class="mb-3">
        <label class="form-label">Trang thai</label>
        <input type="text" class="form-control" name="trangThai">
    </div>

    <button class="btn btn-primary">
        ADD
    </button>
</form>
<h1 style="text-align: center">Danh sach san pham</h1>

<table class="table">
    <thead>
    <tr>
        <td>Id</td>
        <td>Ma CH</td>
        <td>ten CV</td>
        <td>Ma</td>
        <td>Ten</td>
        <td>Ten dem</td>
        <td>Ho </td>
        <td>Gioi Tinh</td>
        <td>ngay sinh</td>
        <td>dia chi</td>
        <td>sdt</td>
        <td>mat khau</td>
        <td>trang thai</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listNV}" var="nv">
        <tr>
            <td>${nv.id}</td>

            <td>${nv.cuaHang.ten}</td>
            <td>${nv.chucVu.ten}</td>
            <td>${nv.ma}</td>
            <td>${nv.ten}</td>
            <td>${nv.tenDem}</td>
            <td>${nv.ho}</td>
            <td>${nv.gioiTinh}</td>
            <td>${nv.ngaySinh}</td>
            <td>${nv.diaChi}</td>
            <td>${nv.sdt}</td>
            <td>${nv.matKhau}</td>
            <td>${nv.trangThai}</td>
            <td>
                <a class="btn btn-primary" href="/detailNV?id=${ctsp.id}">detail</a>
                <a class="btn btn-primary" href="/deleteNV?id=${ctsp.id}">delete</a>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>

</body>
</html>