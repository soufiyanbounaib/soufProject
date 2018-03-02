<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/fileSoufStyle.css">
<title>Insert title here</title>
</head>
<body>
<a href="controller.php?action=prefer">My preferred shop</a>

  <div class="content">
  
  <c:forEach items="${model.shops}" var="s">
  <div class="row">
      <div class="grid columns">
        <div class="title">
          <h3>${s.designation}<br/></h3>
        </div>
        <div class="btnlike">
        <div class="btn"><a href="controller.php?action=like&idsp=${s.ids}">like</a></div>
        </div>
      </div> 
  </div>
  </c:forEach>
  
   </div>
  
</body>
</html>