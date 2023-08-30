package com.example.Ass_java44.servlet;

import com.example.Ass_java44.entity.ChucVu;
import com.example.Ass_java44.repository.ChucVuRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "/ChucVuServlet", value = {"/chuc-vu", "/detailCV", "/deleteCV", "/addCV", "/updateCV"})
public class ChucVuServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ChucVuRepository chucVuRepository = new ChucVuRepository();
        String uri = req.getRequestURI();
        if (uri.equals("/chuc-vu")) {

            List<ChucVu> list = chucVuRepository.getAll();
            req.setAttribute("listChucVu", list);
            req.getRequestDispatcher("chuc-vu.jsp").forward(req, resp);
        } else if (uri.contains("/detailCV")) {
            String id = req.getParameter("id");
            ChucVu cv = chucVuRepository.getByid(UUID.fromString(id));
            req.setAttribute("chucVu", cv);
            req.getRequestDispatcher("detailCV.jsp").forward(req, resp);

        } else if (uri.contains("/deleteCV")) {
            String id = req.getParameter("id");
            ChucVu cv = chucVuRepository.getByid(UUID.fromString(id));
            chucVuRepository.delete(cv);
            resp.sendRedirect("/chuc-vu");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ChucVuRepository chucVuRepository = new ChucVuRepository();
        String uri = req.getRequestURI();
        if (uri.contains("/addCV")) {
            String ma = req.getParameter("ma");
            String ten = req.getParameter("ten");

            ChucVu c = new ChucVu();
            c.setMa(ma);
            c.setTen(ten);

            chucVuRepository.addNew(c);
            resp.sendRedirect("/chuc-vu");
        } else if(uri.contains("/updateCV")){
            String id=req.getParameter("id");
            String ma=req.getParameter("ma");
            String ten=req.getParameter("ten");
            ChucVu c=new ChucVu();
            c.setId(UUID.fromString(id));
            c.setMa(ma);
            c.setTen(ten);

            chucVuRepository.update(c);

            resp.sendRedirect("/chuc-vu");

        }
    }
}
