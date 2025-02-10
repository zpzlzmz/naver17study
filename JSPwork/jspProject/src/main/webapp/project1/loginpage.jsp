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
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background: linear-gradient(135deg, #667eea, #764ba2);
            font-family: 'Arial', sans-serif;
            overflow: hidden;
        }

        /* 배경에 큰 타이틀 추가 */
        .background-title {
            position: absolute;
            top: 5%;
            left: 50%;
            transform: translateX(-50%);
            font-size: 80px;
            font-weight: bold;
            color: rgba(255, 255, 255, 0.2);
            text-shadow: 2px 2px 10px rgba(0, 0, 0, 0.2);
        }

        /* 반투명 로그인 박스 */
        .login-container {
            background: rgba(255, 255, 255, 0.2);
            padding: 30px;
            border-radius: 20px;
            box-shadow: 0 8px 32px rgba(0, 0, 0, 0.2);
            backdrop-filter: blur(10px);
            text-align: center;
            width: 400px;
        }

        /* 로그인 박스 안에 타이틀 스타일 */
        .login-container h2 {
            font-size: 24px;
            color: white;
            margin-bottom: 15px;
        }

        table {
            margin: 0 auto;
            width: 100%;
        }

        td {
            padding: 10px;
            color: white;
            font-size: 16px;
        }

        input {
            padding: 10px;
            width: 100%;
            border: none;
            border-radius: 10px;
            outline: none;
            background: rgba(255, 255, 255, 0.3);
            color: white;
            font-size: 16px;
            text-align: center;
            transition: 0.3s ease;
        }

        input::placeholder {
            color: rgba(255, 255, 255, 0.7);
        }

        input:focus {
            background: rgba(255, 255, 255, 0.5);
            box-shadow: 0 0 10px rgba(255, 255, 255, 0.5);
        }

        .button-group {
            margin-top: 15px;
        }

        .button-group button {
            width: 100%;
            padding: 12px;
            border: none;
            border-radius: 20px;
            cursor: pointer;
            font-size: 16px;
            transition: 0.3s;
            font-weight: bold;
            margin-top: 10px;
        }

        .login-btn {
            background: linear-gradient(135deg, #4facfe, #00f2fe);
            color: white;
        }

        .signup-btn {
            background: linear-gradient(135deg, #ff9966, #ff5e62);
            color: white;
        }

        .login-btn:hover {
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(79, 172, 254, 0.5);
        }

        .signup-btn:hover {
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(255, 94, 98, 0.5);
        }
    </style>
</head>
<body>
    
    <h1 class="background-title">놀고먹자</h1>

    <div class="login-container">
       
        <h2>로그인</h2>
        <table>
            <tr>
                <td><label for="username">아이디</label></td>
                <td><input type="text" id="username" placeholder="아이디 입력"></td>
            </tr>
            <tr>
                <td><label for="password">비밀번호</label></td>
                <td><input type="password" id="password" placeholder="비밀번호 입력"></td>
            </tr>
        </table>
        <div class="button-group">
            <button class="login-btn">로그인</button>
            <button class="signup-btn">회원가입</button>
        </div>
    </div>
    <script type="text/javascript">
    $(".login-btn").click(function() {
        
        var username = $("#username").val();
        var password = $("#password").val();

       
        if (username == "" || password == "") {
            alert("아이디와 비밀번호를 입력해주세요!");
        } else {
        	$.ajax({
        	    type: "get",
        	    dataType: "html",
        	    data: { userID: username, password: password },
        	    url: "./loginaction.jsp",
        	    success: function(res) {
        	        console.log("서버 응답:", res.trim()); 
        	        if (res.trim() === "success") {  
        	            window.location.replace("main.jsp");  
        	        } else {
        	            alert("아이디 또는 비밀번호가 잘못되었습니다");
        	        }
        	    }
        	});
        }
    });



    // 회원가입 버튼 클릭 시 이벤트
    $(".signup-btn").click(function() {
        
        window.location.href="signuppage.jsp";
        
    });
</script>
</body>
</html>