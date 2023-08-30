package com.example.Ass_java44.servlet;

import com.example.Ass_java44.entity.KhachHang;
import com.example.Ass_java44.repository.KhachHangRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "KhachHangServlet", value = {
        "/khach-hang",
        "/detailKH",
        "/deleteKH",
        "/addKH",
        "/updateKH",
})
public class KhachHangServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        KhachHangRepository khachHangRepository = new KhachHangRepository();
        String uri = req.getRequestURI();
        if (uri.contains("/khach-hang")) {
            List<KhachHang> list = khachHangRepository.getAll();
            req.setAttribute("listKH", list);
            req.getRequestDispatcher("khach-hang.jsp").forward(req, resp);
        } else if (uri.contains("/detailKH")) {
            String id = req.getParameter("id");
            KhachHang kh = khachHangRepository.getById(UUID.fromString(id));
            req.setAttribute("detail", kh);
            req.getRequestDispatcher("detailKH.jsp").forward(req, resp);

        } else if (uri.contains("/deleteKH")) {
            String id = req.getParameter("id");
            KhachHang kh = khachHangRepository.getById(UUID.fromString(id));
            khachHangRepository.delete(kh);
            resp.sendRedirect("khach-hang.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        KhachHangRepository khachHangRepository = new KhachHangRepository();
        String uri = req.getRequestURI();
        if (uri.contains("/addKH")) {
            String ma = req.getParameter("ma");
            String ten = req.getParameter("ten");
            String tendem = req.getParameter("tenDem");
            String ho = req.getParameter("ho");
            String ns = req.getParameter("ngaySinh");
            String sdt = req.getParameter("sdt");
            String dc = req.getParameter("diaChi");
            String tp = req.getParameter("thanhPho");
            String qg = req.getParameter("quocGia");
            String mk = req.getParameter("matKhau");
            KhachHang kh = new KhachHang();
            kh.setMa(ma);
            kh.setTenDem(ten);
            kh.setDiaChi(dc);
            kh.setQuocGia(qg);
            kh.setMatKhau(mk);
            kh.setTenDem(tendem);
            kh.setSdt(sdt);
            kh.setHo(ho);
            kh.setNgaySinh(Date.valueOf(ns));
            kh.setThanhPho(tp);

            khachHangRepository.add(kh);
            resp.sendRedirect("khach-hang");
        }
    }
}
