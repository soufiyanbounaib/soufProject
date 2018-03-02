<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/fileSoufStyle.css">
<title>Sign in</title>
</head>
<body>
<h1>Sign in</h1>
<form action="controller.php" method="post">
    
   Email : <input type="text" name="eml" />
    Password : <input type="text" name="pwd" />
    <input type="submit" value="Sign in" name="action" />
    <a href="SignUpView.jsp">Sign Up</a>
    
</form>

</body>
</html>