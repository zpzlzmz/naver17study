$(function(){
	/*
	총 클릭시 0~11 사이의 난수를 발생 시키고 그 숫자의 인형을
	사라지게 하기 
	이미 사라진 경우는 메세지 
	
	*/

	$(".gun").click(function(){
		let idx=parseInt(Math.random()*12);

		if($(".sunban img").eq(idx).is(":hidden")){
			$("#msg").html("꽝!! "+(idx+1)+"번째 인형은 없습니다");
		}else{
			$("#msg").html((idx+1)+"번째 인형을 맞췃습니다");
			// $(".sunban img").eq(idx).fadeOut('fast');
			$(".sunban img").eq(idx).hide();
		}

		let n=$(".sunban img:hidden").length;
		if(n==12){
			$("#msg").html("game Over!!");
		}
	}); 

	//돈 클릭시 돈은 사라지고 나머지는 모두 ㅊ기;화
	$(".money img").click(function(){
		$(".sunban img").show();
		$("#msg").html("")
		// $(this).css("visibility","hidden");//자리 차지
		$(this).css("display","none");//자리 차지하지않음
	})

});