<%--
  Created by IntelliJ IDEA.
  User: lenovo-pc
  Date: 2018/7/23
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login登录界面</title>
</head>
<body>
 <form action="<%=request.getContextPath()%>/Verify" method="post">
    <input type="text" name="verificationCode"/>
    <img alt="验证码" id="vcode" src="<%=request.getContextPath() %>/Image">
    <a href="javascript:refreshcode()">刷新</a>
    <br>
    <input type="submit" value="提交">
</form>
</body>
</html>
