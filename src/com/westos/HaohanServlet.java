package com.westos;

import com.westos.Haohan;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HaohanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取提交的参数
        String xuhao=request.getParameter("xuhao");
        String xingming=request.getParameter("xingming");
        Haohan haohan=new Haohan();
        //Integer.valueOf可能会引起类型转换异常,故需要进行类型检查
        haohan.setXuhao(Integer.valueOf(xuhao));
        haohan.setXingming(xingming);

        //添加到好汉列表
        //获取好汉列表
        ServletContext application = getServletContext();

        List<Haohan> list =(List) application.getAttribute("haohan");
        //注意检查NPE(空指针异常)
        if(list==null){
            list=new ArrayList<>();
        }
        list.add(haohan);
        application.setAttribute("haohan",list);
        response.sendRedirect(request.getContextPath()+"/paihangbang.jsp");
        //request.getRequestDispatcher("/paihangbang.jsp").forward(request,response);
    }
}
