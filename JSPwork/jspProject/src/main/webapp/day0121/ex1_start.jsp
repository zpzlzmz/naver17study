<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%--페이지 지시어 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>HTML,JSP 주석 확인</h3>
	<!-- HTML 주석 -->
	<%--JSP 주석 --%>
	
	<%-- <script type="text/javascript">
		document.write("머쓲");
	</script>--%>
	
	<h4>이름:<%=name %></h4><!-- 선언문으로 선언 했을때 그 멤버 변수는 어디서든지 호출 가능  -->
	
	<%!
	//선언문 : 이곳에 변수를 등록하면 서블릿 변환시 멤버 변수로 등록됨
	String name ="홍길동";
	%>
	
	<%
	//스크립트릿(scriptlet): 자바영역
	//이곳에서 선언하는 변ㅅ후는 서블릿 변환시 지역변수로 등록된다(doGet의 지역변수로)
	
	//변수를 브라우저에 출력하는 방법 두가지
	
	//1번
	out.print("이름:"+name);
	%>
	
	<h4>이름:<%=name %></h4><%--표현식을 이용한 자바 영역의 변수 출력--%>
	
	
	<%
		String addr="서울시 강남구";
		
	%>
	<h5 style="color:blue;">주소:<%=addr %></h5>
	
	<!-- 
		jsp 실행 -- servlet(java파일)으로 변환 --class 파일로 컴파일 -- class파일이 실행되어
		브라우저로 나옴 
		
	 -->
	
</body>
</html>
 