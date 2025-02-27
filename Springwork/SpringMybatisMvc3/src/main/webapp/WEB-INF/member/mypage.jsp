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
				.profilelargephoto{
					width: 100px;
					height:100px;
					border:1px solid gray;
					border-radius: 100px;
				}
				.changecamera{
					position:relative;
					cursor:pointer;
					font-size:1.5em;
					left:-20px;
					top:50px;
					
				}
	</style>

</head>
<body>
<jsp:include page="../../layout/title.jsp"/>

<!-- The Modal -->
<div class="modal" id="myUpdateModal">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">회원정보 수정</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
        <!--  -->
      </div>

      <!-- Modal body -->
      <div class="modal-body">
      	<h6>회원명 수정</h6>
       	<input type="text" class="form-control" id="mname" value="${dto.mname }">
       	<h6>회원 핸드폰 수정</h6>
       	<input type="text" class="form-control" id="mhp" value="${dto.mhp }">
       	<h6>회원 주소 수정</h6>
       	<input type="text" class="form-control" id="maddr" value="${dto.maddr }" >
       	<br>
       	<button type="button" class="btn btn-sm btn-success" id="btnupdate" data-bs-dismiss="modal">수정</button>
       	
       	<script type="text/javascript">
       		$("#btnupdate").click(function(){
       			$.ajax({
       				type:"post",
       				dataType:"text",
       				data:{"mname":$("#mname").val(),"mhp":$("#mhp").val(),"maddr":$("#maddr").val(),"num":${dto.num}},
       				url:"./update",
       				success:function(){
       					location.reload()
       				}
       			})
       		});
       	</script>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>

<div style="margin:30px 100px;">
	<!-- 네이버 storage 에 있는 사진으로 출력 -->
	<img src="${naverurl }/member/${dto.mphoto}" class="profilelargephoto" onerror="this.src='${root}/noimage.png'">
	
	<input type="file" id="fileupload" style="display:none;">
	
	<i class="bi bi-camera2 changecamera"></i>
	<script type="text/javascript">
		$(".changecamera").click(function(){
			$("#fileupload").trigger("click");
		});
		
		//사진 변경 이벤트 
		$("#fileupload").change(function(e){
			let form=new FormData();
			form.append("upload",e.target.files[0]);
			form.append("num",${dto.num});
			
			$.ajax({
				type:"post",
				dataType:"text",
				data:form,
				url:"./changephoto",
				processData:false,
				contentType:false,
				success:function(){
					location.reload();
				}
			})
		})
	</script>
	<div style="display:inline-block; margin:20px 50px;">
		<h6>회원명 : ${dto.mname }</h6>
		<h6>아이디 : ${dto.myid }</h6>
		<h6>핸드폰 : ${dto.mhp }</h6>
		<h6>주소 : ${dto.maddr }</h6>
		<h6>가입일 :
		<fmt:formatDate value="${dto.gaipday }" pattern="yyyy-MM-dd HH:mm"/>
		</h6>
		<br><br>
		<button type="button" class="btn btn-sm btn-danger" onclick="memberdel(${dto.num})">회원 탈퇴</button>
		<script type="text/javascript">
			function memberdel(num){
				let ans=confirm('정말 탈퇴하시겠습니까?');
				if(ans){
					
					$.ajax({
						type:"get",
						dataType:"text",
						data:{"num":num},
						url:"./mypagedel",
						success:function(){
							location.href='../';
						}
					})
				}
			}
			
		</script>
		<!-- 문제 : 아이디를 제외한 너무지 정보 (mname,mhp, maddr) 수정 (modal) 수정 후 reload 할거니까 @responseBody로 메서드 구현  -->
		<button type="button" class="btn btn-sm btn-success" data-bs-toggle="modal" data-bs-target="#myUpdateModal">회원 정보 수정</button>
		
		<!-- 내가 쓴 게시글 -->
		
	</div>
	<div style="margin-top:30px; width:650px;">
			<h5>내가 쓴 게시글</h5>
			<table class="table table-bordered tabmyboard">
				<thead>
					<tr>
						<th width="60">번호</th>
						<th width="450">제 목</th>
						<th width="100">작성일</th>
						<th width="30">조회</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="dto" items="${list}" varStatus="i">
						<tr>
							<td align="center">${i.count}</td>
							<td>
								<a href="../board/detail?idx=${dto.idx}" style="color:black; text-decoration:none">
								<c:if test="${dto.relevel!=0}"><mark>[답글]</mark></c:if>${dto.subject}
								</a>
							</td>
							<td align="center">
								<span style="font-size:0.8em;">
									<fmt:formatDate value="${dto.writeday}" pattern="yyyy-MM-dd"/>
								</span>
							</td>
							<td align="center">${dto.readcount}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	
</div>
</body>
</html>