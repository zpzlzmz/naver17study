<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String amho = request.getParameter("amho");
	//암호가 bitcamp가 맞으면 쿠키 생성 이름은 loginok
	
	if(amho.equals("bitcamp")){
		Cookie cookie=new Cookie("loginok",amho); // name은 loginok, value 는 아무거나 저장
		cookie.setPath("/");// 저장위치root
		cookie.setMaxAge(10);// 쿠키 유지시간 , 초단위if 한시간을 주고 싶다면 60*60 이렇게, 하루는 60*60*24 이런식으로 하기
		response.addCookie(cookie);//브라우저에 쿠키 추가
		response.sendRedirect("./cookiemain.jsp");//메인 페이지로 이동
		
	}else{%>
		<script>
			alert("암호가 맞지 않습니다");
			history.back();
		</script>
		<%}
 %>

