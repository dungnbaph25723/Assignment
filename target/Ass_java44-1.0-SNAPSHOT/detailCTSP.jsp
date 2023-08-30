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
<form action="/updateCTSP" method="post">

    <div class="mb-3">
        <label class="form-label">Id</label>
        <input type="text" class="form-control"value="${detail.id}" name="id">
    </div>

    <div class="mb-3">
        <label class="form-label">ID Sản phầm</label><br/>
        <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" name="idSP">
            <c:forEach items="${listSP}" var="sp">
                <option value="${sp.id}" ${detail.sanPham.id==sp.id?"selected":""}>${sp.ten}</option>

            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label class="form-label">ID nha san xuat</label><br/>
        <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" name="idNSX">
            <c:forEach items="${listNSX}" var="nsx">
                <option value="${nsx.id}" ${detail.nsx.id ==nsx.id?"selected":""}>${nsx.ten}</option>

            </c:forEach>
        </select>
    </div>

    <div class="mb-3">
        <label class="form-label">ID mau sac</label><br/>
        <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" name="idMS">
            <c:forEach items="${listMauSac}" var="ms">
                <option value="${ms.id}"${detail.mauSac.id ==ms.id?"selected":""}>${ms.ten}</option>

            </c:forEach>
        </select>
    </div>

    <div class="mb-3">
        <label class="form-label">ID dong sp</label><br/>
        <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" name="idDSP">
            <c:forEach items="${listDongSP}" var="d">
                <option value="${d.id}" ${detail.dongSP.id ==d.id?"selected":""}>${d.ten}</option>

            </c:forEach>
        </select>
    </div>

    <div class="mb-3">
        <label class="form-label">Nam BH</label>
        <input type="text" class="form-control"value="${detail.namBH}" name="namBH">
    </div>
    <div class="mb-3">
        <label class="form-label">Mô tả</label>
        <input type="text" class="form-control" value="${detail.moTa}"name="moTa">
    </div>
    <div class="mb-3">
        <label class="form-label">Số lượng tồn</label>
        <input type="text" class="form-control"value="${detail.soLuongTon}" name="soLuongTon">
    </div>
    <div class="mb-3">
        <label class="form-label">giá nhập</label>
        <input type="text" class="form-control"value="${detail.giaNhap}" name="giaNhap">
    </div>
    <div class="mb-3">
        <label class="form-label">Giá bán</label>
        <input type="text" class="form-control"value="${detail.giaBan}" name="giaBan">
    </div>
    <button class="btn btn-primary">
        update
    </button>
</form>
</body>
</html>