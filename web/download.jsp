

<%@ page import="java.io.File" %>
<%@ page import="org.apache.commons.io.IOUtils" %>
<%@ page import="java.io.FileInputStream" %>
<%@ page import="java.io.OutputStream" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="org.apache.commons.io.FilenameUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //读取一个文件
    //此处会产生任意文件下载漏洞
    File file=new File(request.getParameter("filename"));
    //相对路径文件
//    request.getSession().getServletContext()
//            application.getRealPath()

    file=new File(request.getServletContext().getRealPath(request.getParameter("filename")));

    //文件下载漏洞的修复
    //1. 建立白名单.只允许下载特定目录下的文件.download
    //检查file.getAbsoluteFile()是不是包含我们指定的路径,包含则安全,不包含则错误

    //2.建立黑名单进行特殊目录保护
    //不允许路径中出现某些路径或字符
    //WEB-INF,.,..

    //TODO:

    //重置输出流,非必须
    //response.reset();
    out.clear();
    OutputStream os = response.getOutputStream();
    //指定下载的文件名,并对中文文件进行编码以防止乱码
    //如果是任意文件下载,需要处理文件名及其扩展名
    //获取文件扩展名
    String extfilename = FilenameUtils.getExtension(request.getParameter("filename"));
    System.out.println(extfilename);
    System.out.println(URLEncoder.encode("中文","utf-8"));
    response.setHeader("Content-disposition","attachment;filename="+ URLEncoder.encode("中文."+extfilename,"utf-8"));
    response.setContentType("application/octet-stream");
    //写文件到输出流
    IOUtils.copy(new FileInputStream(file),os);
    //写到输出流
    os.flush();
    //关闭
    os.close();
%>