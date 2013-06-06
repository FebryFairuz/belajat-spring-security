
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h3>Message : ${message}</h3>	
	<h3>id : ${id}</h3>	
	<h3>Username : ${username}</h3>	
	<h3>NAMA LAIN: ${namalain}</h3>	
	<h3>pass: ${password}</h3>	
	
	<a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
	
</body>
</html>