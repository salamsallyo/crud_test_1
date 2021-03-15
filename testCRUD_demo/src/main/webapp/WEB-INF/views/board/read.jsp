<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>${board.b_title } : Simple CRUD test</title>
</head>
<body>
	<div class="container">
		<h2>No : ${board.b_id }</h2>
		<div class="form-group">
			<label for="form">Writer : ${board.b_writer }</label>
		</div>
		<div class="form-group">
			<label for="form">Title : ${board.b_title }</label>
		</div>
		<div class="form-group">
			<label for="form"><textarea rows="20" cols="100" id="contents" readonly>${board.b_contents }</textarea></label>
		</div>
		<div class="form-group">
			<label for="form">Create Time : ${board.b_created_date }</label>
			<label for="form">Modified Time: ${board.b_update_date }</label>
		</div>
		<div>
			<a href="/board"><button type="button" class="btn btn-info">Move to list</button></a>
			<a href="/board/update/${board.b_id }"><button type="button" class="btn btn-success">Update</button></a>
			<button type="button" id="deleteBoard" class="btn btn-danger">Delete</button>
		</div>
	</div>
</body>
<script>
	$("#deleteBoard").click(function(){
		var result = confirm("Are you sure want to delete this contents?");
		if(result){
			location.href = "/board/delete/${board.b_id}";
		}
	})
</script>
</html>