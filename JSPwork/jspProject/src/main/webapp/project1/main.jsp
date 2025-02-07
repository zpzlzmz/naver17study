<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<title>놀고 먹자</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #f8f8f8;
}

.navbar {
	display: flex;
	justify-content: space-between;
	align-items: center;
	background-color: #ff9800;
	padding: 15px 20px;
	color: white;
}

.navbar .logo {
	font-size: 24px;
	font-weight: bold;
	cursor: pointer;
}

.navbar .user-info {
	display: flex;
	align-items: center;
}

.navbar .user-info span {
	margin-right: 15px;
}

.navbar button {
	background-color: white;
	border: none;
	padding: 8px 12px;
	cursor: pointer;
	margin-left: 10px;
}

.cart {
	display: none;
	position: absolute;
	top: 60px;
	right: 20px;
	background: white;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
	padding: 10px;
	width: 200px;
}

.grid-container {
	display: grid;
	grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
	gap: 15px;
	padding: 20px;
	align-items: center;
}

.grid-item {
	display: flex; /* 플렉스 박스를 사용해서 중앙 정렬 */
	justify-content: center; /* 가로 중앙 정렬 */
	align-items: center; /* 세로 중앙 정렬 */
	background: white;
	padding: 10px;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
	text-align: center;
	cursor: pointer;
}

.burger-container {
	display: flex;
	flex-wrap: wrap;
	gap: 20px; /* 카드들 간의 간격을 추가 */
	justify-content: center; /* 카드들을 가운데 정렬 */
}

.burger-card {
	width: 250px;
	background-color: #fff;
	border-radius: 10px;
	overflow: hidden; /* 이미지를 카드 밖으로 넘치지 않게 */
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	transition: transform 0.3s ease; /* 카드에 호버 효과 추가 */
	text-align: center;
}

.burger-card:hover {
	transform: translateY(-10px); /* 호버 시 살짝 위로 올라가는 효과 */
}

.burger-card img {
	width: 100%;
	height: 200px;
	object-fit: cover; /* 이미지를 카드의 크기에 맞게 자르기 */
	border-bottom: 2px solid #f1f1f1; /* 이미지와 텍스트 구분을 위한 선 추가 */
}

.burger-card p {
	margin: 10px;
	font-size: 16px;
	color: #333;
}

.burger-card p:first-of-type {
	font-weight: bold;
	font-size: 18px;
	color: #2c3e50;
}

.burger-card p:nth-of-type(2) {
	font-style: italic;
	color: #7f8c8d;
}

.burger-card p:last-of-type {
	font-size: 18px;
	font-weight: bold;
	color: #e74c3c; /* 가격은 빨간색으로 강조 */
}

.modal-body {
    text-align: center;
}

#modalImage {
    max-width: 100%;
    height: auto;
    margin-bottom: 15px;
}

#modalDescription {
    font-size: 1.1rem;
    color: #555;
}

#modalPrice {
    font-size: 1.5rem;
    font-weight: bold;
    color: #f00;
}
#cartDropdown {
    display: none;
    position: absolute;
    top: 60px;
    right: 20px;
    background: white;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    padding: 20px;
    width: 300px;
    max-height: 400px; /* 높이 제한 */
    overflow-y: auto; /* 내용이 넘칠 경우 스크롤 가능 */
    border-radius: 10px;
}

#cartDropdown ul {
    list-style: none;
    padding: 0;
    margin: 0;
}

#cartDropdown li {
    display: flex;
    align-items: center;
    margin-bottom: 15px;
    border-bottom: 1px solid #ddd;
    padding-bottom: 10px;
}

#cartDropdown li img {
    width: 50px;
    height: 50px;
    object-fit: cover;
    border-radius: 5px;
    margin-right: 10px;
}

#cartDropdown li p {
    margin: 0;
    font-size: 14px;
    color: #333;
    word-wrap: break-word;
}

#cartDropdown li .burger-name {
    font-weight: bold;
    color: #2c3e50;
}

#cartDropdown li .burger-price {
    font-weight: bold;
    color: #e74c3c;
    margin-left: auto;
}



</style>

<script type="text/javascript">
$(function() {
    $(".grid-item").on("click", function() {
        let category = $(this).data("category");
        
        $.ajax({
            type: "get",
            dataType: "json",
            data: { category: category },  // 카테고리를 요청 파라미터로 전달
            url: "./burgerList.jsp",  // 서버에서 데이터를 받을 JSP 파일
            success: function(res) {
                console.log("받은 데이터:", res);
                let s=""; 
               

                // $.each()를 사용하여 배열 순회
                $.each(res, function(idx, burger) {
                    let imageUrl = burger.imageUrl ? "/image/" + burger.imageUrl : 'default-image.jpg';
                    let name = burger.name || '이름 없음';
                    let description = burger.description || '설명 없음';
                    let price = burger.price || 0;

                    s += `
                    	<div class="burger-container">
                        <div class="burger-card" data-bs-toggle="modal" data-bs-target="#myModal" 
                             data-name="\${name}" data-imageurl="/jspProject\${imageUrl}" 
                             data-description="\${description}" data-price="\${price}">
                            <img src="/jspProject/\${imageUrl}" alt="\${name}">
                            <p>\${name}</p>
                            <p>\${description}</p>
                            <p>\${price}원</p>
                        </div>
                    </div>

                    `;
                });
                
                // 데이터를 html에 삽입
                $("#burger-list").html(s);  // .burger-container에 추가하기
                
                $(".burger-card").click(function() {
                    var name = $(this).data("name");
                    var imageUrl = $(this).data("imageurl");  // data-imageurl 값을 가져오기
                    var description = $(this).data("description");
                    var price = $(this).data("price");

                    console.log("클릭한 burger-card에서 데이터:", name, imageUrl, description, price); // 데이터 확인

                    // modal에 정보 설정
                    $("#modalTitle").text(name);
                    $("#modalDescription").text(description);
                    $("#modalPrice").text(price);
                    $("#modalImage").attr("src", imageUrl);
                    

                    // 모달을 띄운다
                    $("#myModal").modal("show");
                });
            }
            
        });
    });
        
    var cart = [];

    // 담기 버튼 클릭 이벤트
    $("#addToCartButton").click(function() {
    var name = $("#modalTitle").text();
    var imageUrl = $("#modalImage").attr("src");
    var description = $("#modalDescription").text();
    var price = $("#modalPrice").text(); // 원 단위 포함

    // 장바구니에 담을 데이터 객체 생성
    var burger = {
        name: name,
        imageUrl: imageUrl,
        price: price
    };
    
    
    console.log("장바구니에 담았습니다");
    updateCart();  // 장바구니 상태 갱신
    $('#myModal').modal('hide');
    // 장바구니 배열에 추가
    cart.push(burger);
    console.log("장바구니:", cart); // 확인용 로그

    // 장바구니 내용 업데이트
    updateCart();
});


 // 장바구니에 아이템 추가 후 업데이트하는 함수
    function updateCart() {
        if (cart.length === 0) {
            $("#cartDropdown").html("장바구니가 비었습니다.");
        } else {
            var cartHtml = "<ul>";
            var totalPrice = 0; // 총금액 변수 초기화

            $.each(cart,function(idx,burger) {
                totalPrice += parseInt(burger.price); // 가격 합산
                cartHtml += `
                    <li>
                        <img src="\${burger.imageUrl}" alt="\${burger.name}">
                        <div>
                            <p class="burger-name">\${burger.name}</p>
                            <p class="burger-price">\${burger.price} 원</p>
                        </div>
                    </li>
                `;
            });

            cartHtml += "</ul>";

            // 총금액을 추가
            cartHtml += `
                <div class="total-price">
                    <strong>총 금액:</strong> \${totalPrice} 원
                    <button type="button" class="btn btn-sm btn-warning check" style="float:right;" id="checkoutButton">결제</button>
                </div>
            `;
            
           	

            // 장바구니 내용 업데이트
            $("#cartDropdown").html(cartHtml);
            
         // 결제 버튼 클릭 이벤트 추가
            $("#checkoutButton").click(function() {
                // 장바구니 데이터 서버로 전송
                $.ajax({
                    type: "POST",
                    url: "./processpayment.jsp",  // 결제 처리할 JSP 페이지 (예시)
                    data: {
                        cart: JSON.stringify(cart)  // 장바구니 배열을 JSON 형식으로 변환하여 전송
                    },
                    success: function(response) {
                        console.log("결제 성공:", response);
                        // 결제 후 장바구니 비우기
                        cart = [];
                        updateCart();  // 장바구니 내용 업데이트
                        alert("결제가 완료되었습니다.");
                    },
                    error: function() {
                        alert("결제 처리에 실패했습니다. 다시 시도해 주세요.");
                    }
                });
            });



        }
    }
 
	  
	        
	      

});


</script>

</head>
<body>
	<div class="navbar">
		<div class="logo" onclick="location.href='main.jsp'">놀고 먹자</div>
		<div class="user-info">
			<span id="userWelcome">님 어서오세요!</span>
			<button onclick="toggleCart()">장바구니</button>
			<button onclick="logout()">로그아웃</button>
		</div>
	</div>
	<div class="cart" id="cartDropdown">장바구니가 비었습니다.</div>
	<div class="grid-container">
		<div class="grid-item" data-category="basic">basic 버거</div>
		<div class="grid-item" data-category="chicken">chicken 버거</div>
		<div class="grid-item" data-category="special">Special 버거</div>
	</div>

	<div id="burger-list" class="burger-container">
		<!-- 여기에 버거 리스트 들어갈 예정 -->
	</div>


	<script>
		function toggleCart() {
		    $("#cartDropdown").slideToggle('fast');
		}

        function logout() {
            alert("로그아웃 되었습니다.");
            location.href = "loginpage.jsp";
        }
    </script>

	<div class="modal" id="myModal">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title" id="modalTitle"></h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<img id="modalImage" class="img-fluid" src="" alt="Burger Image">
					<p id="modalDescription"></p>
					<p>
						<strong>가격:</strong> <span id="modalPrice"></span> 원
					</p>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
				<button type="button" class="btn btn-primary" id="addToCartButton">담기</button>
					<button type="button" class="btn btn-danger"
						data-bs-dismiss="modal">닫기</button>
				</div>

			</div>
		</div>
	</div>
</body>
</html>