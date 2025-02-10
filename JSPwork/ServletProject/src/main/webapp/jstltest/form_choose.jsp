<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
			body *{
				font-family: 'Jua';
				}
			.nara1{
				background-color:yellow;
				color:blue;
			}
			.nara2{
				background-color:pink;
				color:gray;
			}
			.nara3{
				background-color:black;
				color:yellow;
			}
			.nara{
				background-color:cyan;
				color:red;
			}
	</style>
</head>
<body>
<div style="margin:20px;">
	<form action="./form_choose.jsp" method="post">
		이름입력:<input type="text" name="myname"><br>
		가고싶은 나라 입력:<input type="text" name="mynara"><br>
		<button type="submit">결과 확인</button>
		
	</form>
	
	<!-- JSTL로 폼태그에 입력한 값을 바로 읽어오기 -->
		<c:if test="${!empty param.myname and !empty param.mynara }">
			<div>
				<h5>이름 : ${param.myname }</h5>
				<h5>가고싶은 나라 : ${param.mynara }</h5>
				
				<hr>
				
				<c:set var="nara" value="${param.mynara }"/>
				
				<c:choose>
					<c:when test="${nara=='프랑스'}">
						<h2 class="nara1">프랑스는 에펠탑이 아름답습니다.</h2>
					</c:when>
					<c:when test="${nara=='미국' }">
						<h2 class="nara2">미국의 그랜드캐니언은 정말 놀랍습니다.</h2>
					</c:when>
					<c:when test="${nara=='멕시코' }">
						<h2 class="nara3">멕시코의 밤거리는 정말 위험합니다</h2>
					</c:when>
					<c:otherwise>
						<h2 class="nara">${nara}는 무엇이 유명할까요 ?</h2>
					</c:otherwise>
				</c:choose>
			</div>
		</c:if>
		<c:if test="${empty param.myname or empty param.mynara }">
			<h2>두 데이터를 모두 입력해주세요</h2>
		</c:if>
	</div>
</body>
</html>