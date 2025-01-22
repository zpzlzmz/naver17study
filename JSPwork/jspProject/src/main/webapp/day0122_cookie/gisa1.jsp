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
	고위공직자범죄수사처(공수처)가 22일 윤석열 대통령에 대한 3차 강제 구인 시도에 나섰다. 공수처는 구인이 어려울 경우 무리하게 추진하기보다는 구치소 내부에서 방문 조사를 시도하는 방안도 고려하고 있다.

공수처 차량은 이날 오전 10시 20분께 경기도 의왕시 서울구치소 정문을 통과해 내부로 진입했다.

오동운 공수처장은 이날 오전 출근길에 "(윤 대통령이) 소환에 불응하고 있어 불가피하게 강제구인에 나서고 있다"며 "오늘 강제구인을 시도하겠다"고 말했다.

공수처 관계자는 이날 브리핑에서 "강제구인이라기보다는 강제구인과 현장조사를 포함한 조사를 위해서 오늘 (시도) 할 예정"이라고 밝혔다.

이 관계자는 "강제구인에만 집중하는 것은 아니고 체포와 구속은 조사를 위한 단계이기 때문에 조사를 위해 여러 가지 시도 중"이라며 "대면조사를 위해서 최선을 다하고 있다고 이해해달라"고 했다.
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