<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>502 jsp study</title>
	<link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
	<style>
			body *{
				font-family: 'Jua';
				}
	</style>

</head>
<body>
<form action="./multiprocess1" method="post" enctype="multipart/form-data">
	제목 : <input type="text" name="title" class="tit2">&nbsp;&nbsp;&nbsp;&nbsp;<button type="submit">전송</button><br>
	사진 : <input type="file" name="upload" class="upload2" multiple="multiple">&nbsp;&nbsp;&nbsp;&nbsp;<i class="bi bi-plus-circle-fill plus"></i>&nbsp;<i class="bi bi-dash-circle minus"></i><br>
	
	<script type="text/javascript">
		s=`<input type="file" name="upload" class="addfile" multiple="multiple"><br>`;
		$(".plus").click(function(){
			$(".minus").after(s);
		});
		
		$(".minus").click(function(){
			 $(".addfile").last().remove();
		})
	</script>
	
</form>
</body>
</html>