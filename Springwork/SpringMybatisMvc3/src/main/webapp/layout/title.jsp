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
			a:link,a:visited{
					color:black;
					text-decoration:none;
					
				}
			a:hover{
					color:hotpink;
					
				}
			ul.menu{
					list-style:none; /* 앞에 . 부터 없앰 */
					margin:10px;
										
				}
			ul.menu li{
					float:left;
					width:100px;
					height: 40px;
					line-height:40px;
					text-align:center;
					background-color:#ffe4e1;
					margin-right:10px;
					border: 1px solid gray;
					border-radius:20px;
				}
				ul.menu li:hover{
					background-color:#d3d3d3;
					box-shadow:5px 5px 5px gray;
				}
	</style>

</head>
<!-- 프로젝트 경로 구하기 - 절대경로를 위한 코드 -->
<c:set var="root" value="${PageContext.request.contextPath}" />
<body>

<div style="margin:10px;">
	<h2 class="alert alert-info">
		<a href="${root}/" style="color:black;">
			<img src="${root}/s4.JPG" width="50">
			Spring Boot와 Mybatis를 이용한 프로젝트 
		</a>
	</h2>
	<ul class="menu">
		<li>
			<a href="${root}/">HOME</a>
		</li>
		<li>
			<a href="${root}/shop/list">상품목록</a>
		</li>
		<li>
			<a href="${root}/member/form">회원가입</a>
		</li>
		<li>
			<a href="${root}/board/list">회원게시판</a>
		</li>
		<li>
			<c:if test="${sessionScope.loginok==null}">
				<a href="${root}/login">로그인</a>
			</c:if>
			<c:if test="${sessionScope.loginok!=null}">
				<a href="${root}/logout">로그아웃</a>
			</c:if>
		</li>		
	</ul>
</div>
<hr style="clear:both;">
</body>
</html>