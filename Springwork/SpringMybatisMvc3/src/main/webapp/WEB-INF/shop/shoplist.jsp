<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>502 jsp study</title>
<link
	href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style>
body * {
	font-family: 'Jua';
}

.shopbox figure {
	float: left;
	width: 200px;
	text-align: center;
	background-color: #ffe4e1;
	border: 1px solid gray;
	border-radius: 20px;
}

.shopbox figure img {
	width: 150px;
	height: 170px;
	border: 1px solid gray;
	border-radius: 20px;
	cursor: pointer;
}

.shopbox figure figcaption {
	text-align: center;
}
</style>

</head>
<body>
<jsp:include page="../../layout/title.jsp"/>
	<div style="margin: 20px; width: 500px;">
		<h5 class="alert alert-danger">	
			총 ${totalCount}개의 상품이 있습니다.

			<button type="button" class="btn btn-success btn-sm"
				style="float: right;" onclick="location.href='./addform'">상품추가</button>
		</h5>
	</div>
	<div style="margin: 20px;" class="shopbox">
		<c:forEach var="dto" items="${list}">
			<figure>
				<a href="./detail?num=${dto.num}" style="color:black">
				<%-- <img src="../save/${dto.mainphoto }" onerror="this.src='../noimage.png'"> --%>
				<img src="${fronturl}/shop/${dto.mainphoto}${backurl}" onerror="this.src='../noimage.png'">
				</a>
				<figcaption>
					<h6>
					<c:if test="${dto.replecount>0}">
						<span class="badge bg-danger">${dto.replecount}</span>
					</c:if>
					${dto.sangpum }</h6>
					<h6> 
						<fmt:formatNumber value="${dto.sprice}" type="number"/>원
					</h6>
				</figcaption>
			</figure>
		</c:forEach>
	</div>
</body>
</html>