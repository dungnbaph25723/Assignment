<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/8/2023
  Time: 5:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
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
</body>
</html>
