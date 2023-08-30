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
        <input type="text" class="form-control"value="${detail.ma}" name="ma">
    </div>
    <div class="mb-3">
        <label class="form-label">Ten</label>
        <input type="text" class="form-control" value="${detail.ten}"name="ten">
    </div>
    <div class="mb-3">
        <label class="form-label">ten dem</label>
        <input type="text" class="form-control"value="${detail.tenDem}" name="tenDem">
    </div>
    <div class="mb-3">
        <label class="form-label">Ho</label>
        <input type="text" class="form-control"value="${detail.ho}" name="ho">
    </div>
    <div class="mb-3">
        <label class="form-label">Ngay SInh</label>
        <input type="text" class="form-control"value="${detail.ngaySinh}" name="ngaySinh">
    </div>

    <div class="mb-3">
        <label class="form-label">So dien thoai</label>
        <input type="text" class="form-control"value="${detail.sdt}" name="sdt">
    </div>

    <div class="mb-3">
        <label class="form-label">Dia chi</label>
        <input type="text" class="form-control"value="${detail.diaChi}" name="diaChi">
    </div>

    <div class="mb-3">
        <label class="form-label">thanh pho</label>
        <input type="text" class="form-control"value="${detail.thanhPho}" name="thanhPho">
    </div>

    <div class="mb-3">
        <label class="form-label">Quoc Gia</label>
        <input type="text" class="form-control"value="${detail.quocGia}" name="quocGia">
    </div>

    <div class="mb-3">
        <label class="form-label">mat khau</label>
        <input type="text" class="form-control"value="${detail.matKhau}" name="mauKhau">
    </div>


    <button class="btn btn-primary">
        update
    </button>
</form>
<h1 style="text-align: center">Danh sach san pham</h1>



</body>
</html>