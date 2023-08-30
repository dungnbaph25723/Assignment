package com.example.Ass_java44.servlet;

import com.example.Ass_java44.entity.CuaHang;
import com.example.Ass_java44.repository.CuaHangRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "CuaHangServlet", value = {"/cua-hang",
        "/detailCH",
        "/addCH",
        "/deleteCH",
        "/updateCH"})


public class CuaHangServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CuaHangRepository cuaHangRepository=new CuaHangRepository();
        String uri = request.getRequestURI();
        if (uri.equals("/cua-hang")) {

            List<CuaHang> list = cuaHangRepository.getAll();
            request.setAttribute("listCuaHang", list);
            request.getRequestDispatcher("cua-hang.jsp").forward(request, response);
        } else if (uri.contains("/detailCH")) {
            String id = request.getParameter("id");
            CuaHang ch=cuaHangRepository.getByid(UUID.fromString(id));
            request.setAttribute("cuaHang",ch);
            request.getRequestDispatcher("detailCH.jsp").forward(request,response);

        }else if(uri.contains("/deleteCH")){
            String id=request.getParameter("id");

            CuaHang ch=cuaHangRepository.getByid(UUID.fromString(id));
            cuaHangRepository.delete(ch);
            response.sendRedirect("cua-hang");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CuaHangRepository cuaHangRepository=new CuaHangRepository();
        String uri=request.getRequestURI();
        if(uri.contains("/addCH")){
            String ma=request.getParameter("ma");
            String ten=request.getParameter("ten");
            String dc=request.getParameter("diaChi");
            String tp=request.getParameter("thanhPho");
            String qg=request.getParameter("quocGia");
            CuaHang ch=new CuaHang();
            ch.setMa(ma);
            ch.setTen(ten);
            ch.setDiaChi(dc);
            ch.setThanhPho(tp);
            ch.setQuocGia(qg);

            cuaHangRepository.addNew(ch);
            response.sendRedirect("/cua-hang");

        }else if(uri.contains("/updateCH")){
            String id=request.getParameter("id");
            String ma=request.getParameter("ma");
            String ten=request.getParameter("ten");
            String dc=request.getParameter("diaChi");
            String tp=request.getParameter("thanhPho");
            String qg=request.getParameter("quocGia");
            CuaHang ch=new CuaHang();
            ch.setId(UUID.fromString(id));
            ch.setMa(ma);
            ch.setTen(ten);
            ch.setDiaChi(dc);
            ch.setThanhPho(tp);
            ch.setQuocGia(qg);

            cuaHangRepository.update(ch);

            response.sendRedirect("/cua-hang");

        }
    }
}



