

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<form action="/schedule/login" method="POST">
   <p>
      # ID: <input type="text" name="empNo"><br>
      # PW: <input type="password" name="password"><br>
      <input type="submit" value="로그인">



   </p>
</form>

</body>
</html>
