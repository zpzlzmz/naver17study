window.onload=function(){
	let mycar=document.querySelectorAll(".mycar"); // 배열타입으로 얻음
	//0번 이미지 이벤트
	//마우스를 올리면 ../photo/K-052.png로 변경하고 벗어나면 다시 원래 이미지로 반환\
	let oldCar ="";
	mycar[0].onmouseover=function(){
		oldCar = this.getAttribute("src");
		this.setAttribute("src","../photo/K-052.png");
	}
	mycar[0].onmouseout = function(){
		this.setAttribute("src",oldCar);
	}

	//1번 이미지 이벤트 
	//마우스를 올리면 border를 자유로 설정3하고 벗어나면 다시 없애기 

	mycar[1].onmouseover = function(){
		// this.style.borderStyle = "solid";
		// this.style.borderWidth = "10px";
		// this.style.borderColor = "green";
		this.style.border = "solid 10px green";
	}
	mycar[1].onmouseout = function(){
		this.style.border= "none";
	}

	//2번 이벤트 
	//마우스를 올리면 .happy를 적용하고 벗어나면 다시 없애기 
	//.happy는 미리 만들어 둘것 
	//내용 상관없음 

	mycar[2].onmouseover = function(){
		this.setAttribute("class","mycar happy");
	}
	mycar[2].onmouseout = function(){
		this.setAttribute("class","mycar");
	}

}