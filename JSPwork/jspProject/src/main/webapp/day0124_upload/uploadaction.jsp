<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
<%-- <%
	//파일이 업로드 되는 실제 위치,코드가 있는 위치가 아니라.
	//톰켓서버에 배포된 프로젝트의 위츠를 찾아야함 
	String realFolder = getServletContext().getRealPath("/upload");
	//업로드 할 파일의 크기
	int uploadSize=1024*1024*5;//5mb 기본 단위는 바이트-> 1키로 바이트 *1024*5 는 5mb
	MultipartRequest multipartRequest = null;
	//tomcat 9까지는 가능, tomcat 10 부터는 JakartaEE가 적용됨 그래서 오류남;
	try{
		multipartRequest = new MultipartRequest(request,realFolder,
				uploadSize,"utf-8",new DefaultFileRenamePolicy());
	/* }catch(Exception e){
		out.print("파일 업로드 오류 발생:"+e.getMessage());
	} */
%>
<h5>실제 업로드 되는 위치</h5>
<h6><%=realFolder %></h6> --%>
</body>
</html>