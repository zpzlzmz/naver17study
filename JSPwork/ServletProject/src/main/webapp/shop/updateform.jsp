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
     </style>
</head>
<body>
<div style="margin: 20px;width:500px;">
	<form action="./update" method="post">
	<input type="hidden" name="num" value="${dto.num}">
		<table class="table table-bordered">
			<tr>
				<td width="100" style="background-color: lightgray;">상품사진</td>
				<td>
					<select id="sphoto" name="sphoto" class="form-select">
						  <script>
						  for(let i=1;i<=34;i++){
	                          let s="";
	                          let sphoto=`../image/photo2/\${i}.\${i==24?"gif":"jpg"}`;
	                          let dbphoto="${dto.getSphoto()}";
	                          if(sphoto==dbphoto)
	                             s=`<option value='\${sphoto}' selected>상품 \${i}</option>`;
	                          else 
	                             s=`<option value='\${sphoto}'>상품 \${i}</option>`;
	                          document.write(s);
	                       }
						  </script>
					 </select>
					 <br>
					<img src="" class="shopphoto" width="100">
					
					<script type="text/javascript">
						$(".shopphoto").attr("src",$("#sphoto").val());
						
						//이벤트
						$("#sphoto").change(function(){
							$(".shopphoto").attr("src",$(this).val());
						});
					</script>
			 </td>
			</tr>
			<tr>
				<td style="background-color: lightgray;">상품명</td>
				<td>
					<input type="text" name="sangpum" id="sangpum"
				class="form-control" value="${dto.sangpum }">	
				</td>
			</tr>
			<tr>
				<td style="background-color: lightgray;">상품색상</td>
				<td>
					<input type="color" name="scolor" id="scolor"
						 value="${dto.scolor }">
				</td>
			</tr>
			<tr>
				<td style="background-color: lightgray;">상품가격</td>
				<td>
					<input type="text" name="sprice" id="sprice" 
					  class="form-control" value=${dto.sprice }>
				</td>
			</tr>
			<tr>
				<td style="background-color: lightgray;">상품갯수</td>
				<td>
					<input type="number" name="scnt" id="scnt" 
					  class="form-control" min="1" max="10" value="${dto.scnt }">
				</td>
			</tr>
			<tr>
				<td style="background-color: lightgray;">입고일</td>
				<td>
					<input type="date" name="ipgoday" id="ipgoday" 
					  class="form-control" value="${dto.ipgoday }">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit" style=width:120px;"
					class="btn btn-sm btn-success">수정하기</button>
				</td>
			</tr>			
		</table>
	
	</form>
</div>
</body>
</html>