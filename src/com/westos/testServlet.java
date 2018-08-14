package com.westos;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class testServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    //用于验证验证码
    {
        String name=request.getParameter("myname");
        String password=request.getParameter("mypassword");
        String piccode = (String) request.getSession().getAttribute("piccode");
        String checkCode = request.getParameter("checkCode");  //取值
        //checkCode=checkCode.toUpperCase();  //把字符全部转换为大写的（此语句可以用于验证码不区分大小写）
        response.setContentType("text/html;charset=gbk");//解决乱码问题
        PrintWriter out = response.getWriter();

        String html = "<html><head><title></title></head><body><p>登录成功</p><a href='index.jsp'>返回</a></body></html>";//设置登录成功页面
        if (checkCode.equals(piccode)) {
            if(name.equals("lxf")){
                if(password.equals("123")){
                    out.write(html);//信息验证成功，跳转
                }
                else out.println("密码错误！！！");
            }
            else out.println("用户名不存在！！！");
        } else {
            out.println("验证码输入错误！！！");
        }


        out.flush();//将流刷新
        out.close();//将流关闭
    }

}
