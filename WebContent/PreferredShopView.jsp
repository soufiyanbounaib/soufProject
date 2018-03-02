<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/fileSoufStyle.css">
<title>My preferred shop</title>
</head>
<body >
<a href="controller.php?action=home">Home</a>
<div class="content">
  
  <c:forEach items="${model.preferredshops}" var="ps">
  <div class="row">
      <div class="grid columns">
        <div class="title">
          <h3>${ps.designation}<br/></h3>
        </div>
        <div class="btnlike">
        <div class="btn"><a href="controller.php?action=dislike&idps=${ps.ids}">Dislike</a></div>
        </div>
      </div> 
  </div>
  </c:forEach>
  
   </div>

</body>
</html>