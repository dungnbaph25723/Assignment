package com.example.Ass_java44.servlet;

import com.example.Ass_java44.entity.SanPham;
import com.example.Ass_java44.repository.SanPhamRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.UUID;


@WebServlet(name = "/SanPhamServlet",value = {
        "/san-pham",
        "/detailSP",
        "/deleteSP",
        "/updateSP",
        "/addSP"
})
public class SanPhamServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SanPhamRepository sanPhamRepository=new SanPhamRepository();
        String uri=req.getRequestURI();
        if(uri.contains("/san-pham")){
            List<SanPham> list=sanPhamRepository.getAll();
            req.setAttribute("listSP",list);
            req.getRequestDispatcher("san-pham.jsp").forward(req,resp);
        }else  if(uri.contains("/detailSP")){
            String id=req.getParameter("id");
            SanPham sanPham=sanPhamRepository.getById(UUID.fromString(id));
            req.setAttribute("detail",sanPham);
            req.getRequestDispatcher("detailSP.jsp").forward(req,resp);
        }else if(uri.contains("/deleteSP")){
            String id=req.getParameter("id");

            SanPham sp=sanPhamRepository.getById(UUID.fromString(id));
            sanPhamRepository.delete(sp);
            resp.sendRedirect("san-pham");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SanPhamRepository sanPhamRepository=new SanPhamRepository();
        String uri=req.getRequestURI();

        String ma=req.getParameter("ma");
        String ten=req.getParameter("ten");


        if(uri.contains("/addSP")){
            SanPham s=new SanPham();

            s.setMa(ma);
            s.setTen(ten);
            sanPhamRepository.add(s);
            resp.sendRedirect("san-pham");
        }else if (uri.contains("/updateSP")){

            SanPham s=new SanPham();
            String id=req.getParameter("id");
            s.setMa(ma);
            s.setId(UUID.fromString(id));
            s.setTen(ten);
            sanPhamRepository.update(s);
            resp.sendRedirect("san-pham");
        }
    }
}
