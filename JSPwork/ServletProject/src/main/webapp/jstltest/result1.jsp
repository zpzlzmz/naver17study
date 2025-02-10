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
	<h2>TestServletEx1으로 부터 포워드</h2>
	<%-- <h3>오늘날짜:${requestScope.today}</h3><!-- request영역의 변수는 requestScope로 가져온다(생략가능) --> --%>
	<h3>오늘날짜:${today}</h3>
	<h3> 오늘날짜 : ${today2}</h3>
	<h3>이름:${myname }</h3>
	<h3>나이:${myage }</h3>
	
	<hr>
	
	
	<!-- jstl로 변수선언과 연산자 공부하기 -->
	<c:set var="su1" value="7"/>
	<c:set var="su2" value="4"/>
	
	<h5>숫자1: ${su1 }</h5>
	<h5>숫자2: ${su2 }</h5>
	<h5>더하기: ${su1+su2 }</h5>
	<h5>빼기: ${su1-su2 }</h5>
	<h5>곱하기: ${su1*su2 }</h5>
	<h5>나누기1: ${su1 / su2 }</h5>
	<h5>나누기1: ${su1 div su2 }</h5>
	<h5>나누기2: ${su1%su2 }</h5>
	<h5>나누기2: ${su1 mod su2 }</h5>
	
	
	<!-- jstl에는 증감연산자가 없다. 그러면 su1 에 1을 더해서 출력하려면 -->
	<c:set var="su1" value="${su1+1}"/>
	<h6>su1에1증가 : ${su1 }</h6>
	
	<!-- 나이에 따라 성인인지 미성년자인지 출력해보자 -->
	
	<c:if test="${myage>=30 }">
		<h2 style="color:blue;"> ${myname } 님은 성인입니다.</h2>
	</c:if>
	
	<c:if test="${myage<30 }">
		<h2 style="color:red;">${myname }님은 미성년자 입니다. </h2>
	</c:if>
		
	
	
	
</body>
</html>