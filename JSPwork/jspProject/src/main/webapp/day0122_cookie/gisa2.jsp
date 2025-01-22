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

<%
	boolean blogin=false;
	//현재 브라우저에 저장된 모든 쿠키값 얻기, 없을 경우 null값
	Cookie [] cookies=request.getCookies();
	if(cookies!=null){
		
		for(int i =0; i<cookies.length; i++){
			//loginok 라는 쿠키가 있는지 검사
			if(cookies[i].getName().equals("loginok")){
				blogin=true;
				break;
			}
		}
	}

%>
<body>
<%
	if(blogin){
	//로그인을 한 상태 
	%>
	<pre>
	현대모비스가 차량 운전자와 탑승객의 안전 여부를 실시간으로 알려주는 모니터링 기술을 개발했다고 22일 밝혔다. 탑승객의 자세와 생체 신호 등을 감지해 졸음 운전과 같은 위험 여부를 알려주는 방식이다.

현대모비스는 이날 이러한 기술을 담은 ‘인캐빈 모니터링 시스템’을 공개하고 올해부터 글로벌 완성차 업체를 상대로 본격적인 수주 활동에 나선다고 밝혔다. 인캐빈 모니터링 시스템은 카메라로 운전자와 탑승객 움직임을 감지한 뒤 위험하다고 판단될 경우 화면이나 소리 등으로 이를 알려주는 시스템이다.


예를 들어 졸음운전으로 눈을 감거나 고개를 떨구면 환기를 하라고 경고하는 식이다. 이밖에 휴대전화 사용, 흡연, 안전벨트 미착용, 뒷자석 유아동 방치 여부, 카시트 착용 여부 등 10가지가 넘는 위험 시나리오를 시스템이 인지하도록 했다. 현대모비스는 이 기술을 개발해 유럽 차량용 소프트웨어 표준인 ASPICE 인증을 획득했다.

현대모비스는 유럽 완성차를 대상으로 인캐빈 모니터링 시스템에 대한 본격적인 수주에 나선다는 계획이다. 글로벌 조사기관에 따르면 카메라를 이용한 운전자 모니터링 시스템(DMS)은 연평균 40% 가까이 급성장하는 분야다.

신규철 현대모비스 전자제어개발실장은 “자율주행 고도화에 따라 차량 내부의 편의 기능과 함께 안전기술 수요는 더욱 높아지고 있다”며 “탑승객마다 다른 신체 구조를 세밀하게 분석하고 정확도 높은 소프트웨어 개발에 주력하겠다”고 밝혔다.
	</pre>
	<%}else{%>
		<script type="text/javascript">
		alert("먼저 로그인을 해주세요");
		history.back();
		</script>
		<%}
%>
</body>
</html>