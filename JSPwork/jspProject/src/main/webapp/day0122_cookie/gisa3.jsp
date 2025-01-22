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
	일본 방송사 후지TV 간부가 연루된 연예인 성 상납 의혹이 불거지면서 도요타자동차 등 일본 대기업이 후지TV에서 방영 중인 광고(CM)를 잇따라 중단하고 있다. 기업 이미지에 타격을 줄 가능성이 있다는 판단에서다.

20일 니혼게이자이신문에 따르면 이날까지 도요타, 닛폰생명, NTT동일본, 카오, 세븐&아이, 닛산자동차 등 최소 15개 기업 이상이 후지TV에서 방영 중인 CM을 중단했다. 모두 일본 남성 아이돌 스마프 출신이자 배우인 나카이 마사히로의 성 상납 문제를 둘러싸고 ‘후지TV 직원이 개입했다’는 보도가 나온 데 대한 대응이다.


CM를 중단한 일본 맥도날드는 “일련의 보도와 후지TV 측의 발표를 종합적으로 감안해 판단했다”고 설명했다. 니혼게이자이는 “CM을 계속할 경우 기업 이미지에 타격을 줄 수 있다고 판단한 것으로 보인다”고 분석했다.

최근 후지TV 한 여성 아나운서는 주간지 슈칸분슌에 “나도 편성부장 A씨를 통해 (다른 남성 연예인에게) 성 상납을 당할 뻔했다”고 폭로했다. 앞서 슈칸분슌은 후지TV 한 여성 스텝이 나카이에게 성 상납을 당했다고 보도했다. 여성 스텝이 후지TV 측에 항의하자 나카이에게 9000만엔을 받았다는 내용이다.

나카이는 이후 공식 사이트를 통해 “트러블이 있었던 것은 사실이다. 모두 제 부족함 때문이다”는 사과문을 발표했다. 보도 내용에 대해선 “사실과 다른 것도 있다”며 일부 부인했다.
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

</body>
</html>