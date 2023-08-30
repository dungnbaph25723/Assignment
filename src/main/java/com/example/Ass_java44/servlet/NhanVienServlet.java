package com.example.Ass_java44.servlet;

import com.example.Ass_java44.entity.ChucVu;
import com.example.Ass_java44.entity.CuaHang;
import com.example.Ass_java44.entity.NhanVien;
import com.example.Ass_java44.repository.ChucVuRepository;
import com.example.Ass_java44.repository.CuaHangRepository;
import com.example.Ass_java44.repository.NhanVienRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "NhanVienServlet", value = {
        "/nhan-vien",
        "/detailNV",
        "/deleteNV",
        "/updateNV",
        "/addNV",

})
public class NhanVienServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri=req.getRequestURI();

        CuaHangRepository cuaHangRepository=new CuaHangRepository();
        List<CuaHang> listCH=cuaHangRepository.getAll();
        req.setAttribute("listCH",listCH);

        ChucVuRepository chucVuRepository=new ChucVuRepository();
        List<ChucVu>listCV=chucVuRepository.getAll();
        req.setAttribute("listCV",listCV);

        NhanVienRepository nhanVienRepository=new NhanVienRepository();
        if(uri.contains("/nhan-vien")){
            List<NhanVien> list=nhanVienRepository.getAll();
            req.setAttribute("listNV",list);
            req.getRequestDispatcher("nhan-vien.jsp").forward(req,resp);
        }else if(uri.contains("/detailNV")){
            String id=req.getParameter("id");
        }

    }
}
