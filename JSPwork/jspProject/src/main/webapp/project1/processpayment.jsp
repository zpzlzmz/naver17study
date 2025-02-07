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
    <h2>결제 처리 중...</h2>

    <%
        // 클라이언트로부터 전송된 장바구니 데이터 받기
        String cartJson = request.getParameter("cart");

        if (cartJson != null && !cartJson.isEmpty()) {
            // JSON 문자열을 파싱하여 장바구니 데이터로 변환
            // 예시에서는 JSON을 Java 객체로 변환하는 로직은 생략

            // 예시: 장바구니에서 금액 합산 (실제 결제 시스템에서는 더 복잡한 로직 필요)
            double totalAmount = 0.0;
            // 여기에 cartJson을 처리하는 코드 추가 (JSON 파싱)
            
            // 결제 시스템 API 호출 (예시로 단순히 금액만 확인하는 로직)
            boolean paymentSuccess = true; // 결제 처리 성공 여부 (실제 시스템에서는 결제 API 호출 후 처리)

            if (paymentSuccess) {
                out.println("결제가 완료되었습니다. 총 금액: " + totalAmount + " 원");
                // 장바구니 비우기, 결제 완료 후 추가 처리 (DB에 결제 기록 저장 등)
            } else {
                out.println("결제 실패. 다시 시도해 주세요.");
            }
        } else {
            out.println("장바구니 데이터가 올바르지 않습니다.");
        }
    %>
</body>
</html>