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
<%
//post 방식일 경우 한글 깨짐 현상 해결법(반드시 첫 줄에 있어야함)
	request.setCharacterEncoding("utf-8");

	String myid=request.getParameter("myid");
	String mypass = request.getParameter("mypass");
	String myname = request.getParameter("myname");
	String driver = request.getParameter("driver");
	String homeaddr=request.getParameter("homeaddr");
	String fcolor = request.getParameter("fcolor");
	String mybirth = request.getParameter("mybirth");
	
	//체크박스 그룹이 여러개인경우 배열로 읽음 
	//if 체크를 하나도 안했을 경우 null 값이 들어옴 
	
	String hobby[] = request.getParameterValues("hobby");
	
	
	String myfood = request.getParameter("myfood");
%>
<body>

	<div style="font-size:20px; color:<%=fcolor %>";>
	아이디:<%=myid %><br>
	패스워드:<%=mypass %><br>
	이름:<%=myname %><br>
	<%-- 운전면허:<%=driver %>:(<%=driver.equals("yes")?"있음":"없음" %>)<br> --%>
	<!-- 값에 null 이 들어올 확률이 있을 경우 무조건 조건은  NULL로  잡아야함 유남쌩 ?  -->
	운전면허:<%=driver %>:(<%=driver==null?"없음":"있음" %>)<br>
	주거지:<%=homeaddr %><br>
	
	취미:
	<%
		if(hobby==null){
			out.print("<b>취미 그딴거 없음</b><br>");
		}else{
			String s="나의 취미는 ";
			for(String h:hobby)
				s+="["+h+"]";
			s+="입니다";
			%>
			<b><%=s%></b><br>
			
		<%}	
	%>
	
	좋아하는 음식: <img src="../image/food/<%=myfood%>" width="100" height="100" border="1"><br>
	글자색 : <%=fcolor %><br>
	생년월일 : <%=mybirth %><br>
	
	</div>
</body>
</html>