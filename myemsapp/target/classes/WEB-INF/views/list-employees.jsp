
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Employees Listing</title>
</head>

<body>

	<div class="container">

		<h3>Students Listing</h3>
		<hr>

		  <form action="" class="form-inline">
		
		    <c:url var="addUrl" value="/employees/displayEmployeeForm" />
		
		    <!-- Add a button -->
		    <a href="${addUrl}" class="btn btn-primary btn-sm mb-3"> Add Employee
		    </a>
		
		
			<!-- Add Logout button -->
			  <c:url var="logoutUrl" value="/logout" />
			  <a href="${logoutUrl}" class="btn btn-primary btn-sm mb-3 mx-auto">
			    Logout 
			  </a>  
		
		  </form>  

		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Country</th>
					<th>Action</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${employees}" var="employeeObj">
					<tr>
						<td><c:out value="${employeeObj.firstName}" /></td>
						<td><c:out value="${employeeObj.lastName}" /></td>
						<td><c:out value="${employeeObj.email}" /></td>
						<td><c:out value="${employeeObj.country}" /></td>
		
					  <td>
					    <!-- Add "update" button/link --> 
					    <c:url var="updateUrl"
					      value="/employees/displayEmployeeForm_Update?employeeId=${employeeObj.id}" /> 
					    <a href="${updateUrl}" class="btn btn-info btn-sm"> 
					      Update 
					    </a>
					    
						  <!-- Add "delete" button/link -->							
						  <c:url var="deleteUrl" value="/employees/delete?employeeId=${employeeObj.id}" />				
						  <a href="${deleteUrl}" class="btn btn-danger btn-sm"
						    onclick="if (!(confirm('Are you sure you want to delete this Employee?'))) return false">
						    Delete 
						  </a>  
					    
					    
					  </td>  
						
					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>

</body>

</html>