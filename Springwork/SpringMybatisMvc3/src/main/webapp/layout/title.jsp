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
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
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
				.logintab tbody th{
					background-color:#e0ffff;
					
				}
				img.profilephoto{
					width: 40px;
					height: 40px;
					border: 1px solid gray;
					border-radius: 100px;
					margin-right:10px;
					cursor:pointer;
				}
	</style>

</head>
<!-- 프로젝트 경로 구하기 - 절대경로를 위한 코드 -->
<c:set var="root" value="${PageContext.request.contextPath}" />
<body>

<!-- Modal login -->
<!-- The Modal -->
<div class="modal" id="myLoginModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">회원 로그인</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
      <form id="loginfrm">
      	<table class="logintab">
      		<tbody>
      			<tr>
      				<th width="80">아이디</th>
      				<td>
      					<input type="text" id="loginid" placeholder="아이디" class="form-control" required="required">
      				</td>
      			</tr>
      			<tr>
      				<th width="80">비밀번호</th>
      				<td>
      					<input type="password" id="loginpass" placeholder="비밀번호" class="form-control" required="required">
      				</td>
      			</tr>
      			<tr>
      				<td colspan="2" align="center">
      					<button type="submit" class="btn btn-sm btn-success">로그인</button>
      				</td>
      			</tr>
      		</tbody>
      	</table>
      	</form>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger btnclose" data-bs-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>

<div style="margin:10px;">
	<h2 class="alert alert-info">
		<a href="${root}/" style="color:black;">
			<img src="${root}/s4.JPG" width="50">
			Spring Boot와 Mybatis를 이용한 프로젝트 
		</a>
		<br>
		<span style="margin-left:200px; font-size:15px;">
			<c:if test="${sessionScope.loginstatus!=null}">
				<img src="${root}/save/${sessionScope.loginphoto}" class="profilephoto" onerror="this.src='${root}/noimage.png'">
				<script type="text/javascript">
					$(".profilephoto").click(function(){
						location.href='${root}/member/mypage';
					})
				</script>
				<b>${sessionScope.loginid}</b> 님이 어서오세요!
			</c:if>
	</span>
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
		<c:if test="${sessionScope.loginid=='admin'}">
			<li>
				<a href="${root}/member/list">회원목록</a>
			</li>
		</c:if>
		
		<li>
			<a href="${root}/board/list">회원게시판</a>
		</li>
		<li>
			<c:if test="${sessionScope.loginstatus==null}">
				<span data-bs-toggle="modal" data-bs-target="#myLoginModal" style="cursor:pointer">로그인</span>
			</c:if>
			<c:if test="${sessionScope.loginstatus!=null}">
				<span style="cursor:pointer" id="logout">로그아웃</span>
			</c:if>
		</li>		
	</ul>
	<script type="text/javascript">
		$("#loginfrm").submit(function(e){
			e.preventDefault();//submit의 기본 이벤트를 무효화 시킴 (action 호출)
			/* alert("submit"); */
			let loginid=$("#loginid").val();
			let loginpass=$("#loginpass").val();
			
			$.ajax({
				type:"get",
				dataType:"json",
				data:{"loginid":loginid,"loginpass":loginpass},
				url:"/member/login",
				success:function(res){
					if(res.result=='success'){
						$(".btnclose").trigger("click");
						location.reload();
					}else{
						alert("아이디나 비밀번호가 맞지 않습니다.");
						$("#loginid").val("");
						$("#loginpass").val("");
					}
				}
				
			})
		});
	
		$("#logout").click(function(){
			$.ajax({
				type:"get",
				dataType:"text",
				url:"/member/logout",
				success:function(){
					alert("로그아웃 되었습니다.");
					location.reload();
				}
			})
		});
		
	</script>
</div>
<hr style="clear:both;">
</body>
</html>