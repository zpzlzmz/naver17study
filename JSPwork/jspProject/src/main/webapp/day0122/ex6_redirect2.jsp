<%@page import="java.util.Vector"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<%
	//request에 저장된 list 를 얻어보자
	List<String> list = (Vector<String>)request.getAttribute("list");
    //redirect로 이동하면 request가 새로 생성 되기때문에 저장된 데이터는 가져올 수 없다.
	if(list == null){
		out.print("<h1>리스트가 업성요;</h1>");
	}else{
		out.print("<h1>리스트가 이써용;</h1>");
	}
%>
</body>
</html>