<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>login登录界面</title>
</head>
<body>
<form method="get" action="test" onsubmit="return isvalidate();" >
        姓名：<input type="text" placeholder="请输入姓名" name="myname"><br/><br/>
  密码：<input type="password" placeholder="请输入密码" name="mypassword"><br/><br/>
  验证码:<input type="text" name="checkCode"/>
  <img alt="验证码" id="imagecode" src="/yzm"/>
  <a href="javascript:reloadCode()">看不清楚</a><br/><br/>
  <input type="submit" value="提交"/>
  </form>

</form>
</body>
</html>