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
				.tabboard thead th{
					text-align:center;
					background-color:#ccc;
					
				}
				.picon{
					color:#ccc;
					font-size:0.9em;
				}
				.profilePhoto{
				width:30px;
				height:30px;
				border:1px soild gray;
				border-radius: 100px;
				margin-right:10px;
				}
				.day{
					font-size:13px;
					color:gray;
				}
	</style>

</head>
<body>
<jsp:include page="../../layout/title.jsp"/>
<c:if test="${sessionScope.loginstatus==null }">
	<script type="text/javascript">
		alert("회원 전용 게시판입니다. \n로그인을 해주세요");
		history.back();
	</script>
</c:if>
<div style="margin:30px; width:600px;">
	<h3><b>${dto.subject}</b></h3>
	<img alt="" src="${naverurl}/member/${memberPhoto}" class="profilePhoto" align="left" onerror="this.src='../noimage.png'">
	<span>${dto.writer }</span>
	<span class="day">
		<fmt:formatDate value="${dto.writeday }" pattern="yyyy-MM-dd HH:mm"/>
		&nbsp;&nbsp;&nbsp;조회&nbsp;&nbsp;${dto.readcount}
	</span>
	<pre style="margin-top:20px; font-size:15px;">${dto.content}</pre>
	<div style="margin-top:30px;">
		<c:forEach var="photo" items="${dto.photos}">
			<img src="${naverurl}/board/${photo}" style="max-width:300px;">
		</c:forEach>
	</div>
	<div style="margin-top:30px;">
		<button type="button" class="btn btn-sm btn-success" style="width:80px;" onclick="location.href='./writeform'">
			<i class="bi bi-pencil-fill"></i>글쓰기
		</button>
		<button type="button" class="btn btn-sm btn-outline-secondary" style="width:80px;" onclick="location.href='./writeform?idx=${dto.idx}&regroup=${dto.regroup}&restep=${dto.restep}&pageNum=${pageNum}&relevel=${dto.relevel}'">
			<i class="bi bi-pencil"></i>답글
		</button>
		<c:if test="${sessionScope.loginid == dto.myid  }">
			<button type="button" class="btn btn-sm btn-outline-secondary" style="width:80px;" onclick="location.href='./updateform?idx=${dto.idx}&pageNum=${pageNum }'">
				수정
			</button>
			<button type="button" class="btn btn-sm btn-outline-secondary" style="width:80px;" onclick="location.href='./delete?idx=${dto.idx}&pageNum=${pageNum }'">
				삭제
			</button>
		</c:if>
		<button type="button" class="btn btn-sm btn-outline-secondary" style="width:80px;" onclick="location.href='./list?pageNum=${pageNum}'">
			목록
		</button>
	</div>
</div>
	
	

</body>
</html>