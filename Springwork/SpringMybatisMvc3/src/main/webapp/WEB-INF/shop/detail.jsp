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

img . large {
	width: 300px;
	height: 350px;
	border: 2px solid black;
}

img.small {
	cursor: pointer;
	width: 80px;
	height: 80px;
	border: 1px solid gray;
	margin: 10px;
}

.colorbox {
	display: inline-block;
	width: 30px;
	height: 20px;
	border: 1px solid black;
	border-radius: 100px;
}

#photoupload {
	display: none;
}

.addphoto {
	font-size: 1.5em;
	cursor: pointer;
	margin-left: 10px;
	margin-right: 10px;
}

.replelist {
	margin: 10px 10px;
}

.likesicon {
	cursor: pointer;
	font-size:18px;
	color: red;
}

.repledel {
	cursor: pointer;
	color: red;
}
img.mini{
	cursor:pointer;
}
</style>
<script type="text/javascript">

	$(function(){
		let file;
		replelist(); //처음 로딩시 댓글 출력 
		
		//카메라 아이콘 이벤트
		$(".addphoto").click(function(){
			$("#photoupload").trigger("click");
		})
		//파일 업로드 이벤트 
		 $("#photoupload").change(function(e){
			 file=e.target.files[0];
			 console.log(file);
		 });
		
		//추천 버튼 눌렀을때
		$(document).on("click",".likesicon",function(){
			let idx = $(this).closest("div[data-idx]").data("idx"); // 댓글 idx 가져오기
			console.log("likes를 누른 댓글의 idx :",idx);
			$.ajax({
				type:"get",
				dataType:"json",
				data:{"idx":idx},
				url:"./likes",
				success:function(res){
					location.reload();
					/* icon.next().find(".likes").text(res.likes); */
				}
			})
		})
		//삭제 버튼 눌렀을때 
		$(document).on("click", ".repledel", function(){
		let idx = $(this).closest("div[data-idx]").data("idx"); // 댓글 idx 가져오기
        console.log("삭제할 댓글 idx:", idx); // 디버깅용

        if (!idx) {
            alert("삭제할 댓글을 찾을 수 없습니다.");
            return;
        }

        if (!confirm("정말 삭제하시겠습니까?")) return; // 삭제 확인

        $.ajax({
            type: "get",
            dataType: "text",
            url: "/shop/repledelete",
            data: { idx: idx }, // 삭제할 댓글의 idx 전송
            success: function(){
                alert("삭제 성공!");
                replelist(); // 댓글 목록 새로고침
            },
            error: function(){
                alert("삭제 실패!");
            }
        });
    });

		
		//댓글 등록버튼 이벤트 
		$(".btnaddreple").click(function(){
			let m=$("#message").val();
			if(m==''){
				alert("댓글을 입력하세요");
				return;
			}
			if(file==null){
				alert("사진을 선택해주세요");
				return;
			}
			let form = new FormData()
			console.log(file);
			form.append("upload",file);
			form.append("message",m)
			form.append("num",${dto.num});
			
			$.ajax({
				type:"post",
				dataType:"text",
				url:"./addreple",
				data:form,
				processData:false,
				contentType:false,
				success:function(){
					$("#message").val("")				
					file=null;
					replelist();
				}
			});
		});
		
		//미니 댓글 사진 클릭시 원본사진 보기
		
		$(document).on("click","img.mini",function(){
			let imgSrc = $(this).attr("src");
			$("img.replelarge").attr("src",imgSrc);
		})
	});
	
	function replelist(){
	    $.ajax({
	        type: "get",
	        dataType: "json",
	        url: "./replelist",
	        data: { "num": ${dto.num} },
	        success: function(res){
	            let s = "";
	            $.each(res, function(idx, ele){
	                s += `<div style="display:flex;" data-idx="\${ele.idx}">
	                        <div><img src="${naverurl}/shop/\${ele.photo}" class="mini" style="width:50px; height:50px;" data-bs-toggle="modal" data-bs-target="#myMiniPhotoModal"></div>
	                        <div style="flex-direction:column; margin-left:20px; width:400px;">
	                            <div>
	                                <span style="font-size:0.7em">\${ele.writetime}</span>&nbsp;&nbsp;
	                                <i class="bi bi-hand-thumbs-up likesicon" style="margin-left:200px;">추천 <span class="likes" >\${ele.likes}</span></i>
	                                <i class="bi bi-trash3 repledel" style="float:right; cursor:pointer;"></i>
	                            </div>
	                            <div style="max-height:40px; overflow-y:auto;">
	                                <span>\${ele.message}</span>
	                            </div>
	                        </div>
	                    </div><hr>`;
	            });
	            $(".replelistarea").html(s);
	        }
	    });
	}
	
</script>

</head>
<body>
<jsp:include page="../../layout/title.jsp"/>

<!-- The Modal -->
<div class="modal" id="myMiniPhotoModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">원본사진</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        <img src="" class="replelarge" style="width:90%;">
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>





	<div style="margin: 20px; width: 500px;">
		<table>
			<tr>
				<td width="120">
				<c:forTokens var="photo" items="${dto.sphoto}" delims=",">
						<img src="${naverurl}/shop/${photo}" class="small" onerror="this.src='../noimage.png'">
						<script type="text/javascript">
							$("img.small").click(
									function() {
										$("img.large").attr("src",
												$(this).attr("src"));
									});
						</script>
					</c:forTokens></td>
				<td><img src="${naverurl}/shop/${dto.mainphoto}" class="large"></td>
			</tr>
			<tr>
				<td colspan="2">
					<div style="margin: 20px 100px; font-size: 17px;">
						<mark>상품명: ${dto.sangpum}</mark>
						<br> 가격:
						<fmt:formatNumber value="${dto.sprice}" type="number" />
						원<br> <span style="background-color:${dto.scolor}">색상
							: ${dto.scolor}</span>
						<div class="colorbox" style="background-color:${dto.scolor}"></div>
						<br> 입고일 : ${dto.ipgoday }<br> 등록일 :
						<fmt:formatDate value="${dto.writeday}" pattern="yyyy-MM-dd HH:mm" />

					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<div class="repleform input-group" style="width: 600px;">
						<input type="text" id="message" class="form-control"
							style="width: 400px;" placeholder="댓글입력"> <input
							type="file" id="photoupload"> <i
							class="bi bi-camera-fill addphoto"></i>
						<button type="button" class="btn btn-sm btn-info btnaddreple">등록</button>
					</div>
					<div class="replelist"></div>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="button"
						class=" btn btn-sm
						btn-outline-secondary"
						style="width: 90px;" onclick="location.href='./addform'">상품등록</button>
					<button type="" class=" btn btn-sm
						btn-outline-secondary"
						style="width: 90px;" onclick="location.href='./list'">목록</button>
					<button type="button"
						class=" btn btn-sm
						btn-outline-secondary"
						style="width: 90px;"
						onclick="location.href='./updateform?num=${dto.num}'">수정</button>
					<button type="button"
						class=" btn btn-sm
						btn-outline-secondary"
						style="width: 90px;"
						onclick="location.href='./delete?num=${dto.num}'">삭제</button>

					<button type="button" class="btn btn-sm btn-outline-secondary"
						style="width: 90px;"
						onclick="location.href='photos?num=${dto.num}'">사진수정</button>
				</td>
			</tr>

		</table>
		<div style="margin: 20px;" class="replelistarea"></div>
	
	</div>
</body>
</html>