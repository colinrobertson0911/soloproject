<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main</title>
</head>
<body>
	<h2>Main Screen</h2>
	
	<div>
		<form action="UserLoginSubmit" method="post">
		${errorMessage}
		<div>
			<label>User Id: </label>
			<input type="text" name="userId"/>
		</div>
		<div>
			<button type="submit">Submit</button>
		</div>
		
		</form>
	</div>
	
</body>
</html>