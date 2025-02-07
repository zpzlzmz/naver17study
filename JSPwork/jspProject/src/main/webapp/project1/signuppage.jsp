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
            background: linear-gradient(135deg, #4facfe, #00f2fe);
            font-family: 'Arial', sans-serif;
            overflow: hidden;
        }

        .signup-container {
            background: rgba(255, 255, 255, 0.9);
            padding: 40px;
            border-radius: 20px;
            box-shadow: 0 8px 32px rgba(0, 0, 0, 0.2);
            backdrop-filter: blur(10px);
            width: 400px;
            text-align: center;
        }

        .signup-container h2 {
            font-size: 28px;
            color: #333;
            margin-bottom: 20px;
        }

        table {
            margin: 0 auto;
            width: 100%;
        }

        td {
            padding: 10px;
            color: #333;
            font-size: 16px;
            text-align: center;
        }

        input, textarea {
            padding: 10px;
            width: 100%;
            border: none;
            border-radius: 10px;
            outline: none;
            background: rgba(0, 0, 0, 0.1);
            color: #333;
            font-size: 16px;
            margin-top: 5px;
            transition: 0.3s ease;
        }

        input::placeholder, textarea::placeholder {
            color: rgba(0, 0, 0, 0.5);
        }

        input:focus, textarea:focus {
            background: rgba(255, 255, 255, 0.8);
            box-shadow: 0 0 8px rgba(0, 0, 0, 0.2);
        }

        textarea {
            resize: vertical; /* 수직 방향으로 크기 조정 가능 */
            height: 100px; /* 기본 높이 설정 */
        }

        .button-group {
            margin-top: 20px;
            display: flex;
            justify-content: space-between;
        }

        .signup-btn, .back-btn {
            width: 48%;  /* 두 버튼이 한 줄에 나란히 배치될 수 있도록 너비 설정 */
            padding: 12px;
            border: none;
            border-radius: 20px;
            font-size: 16px;
            font-weight: bold;
            transition: 0.3s ease;
            cursor: pointer;
        }

        .signup-btn {
            background: linear-gradient(135deg, #ff9966, #ff5e62);
            color: white;
        }

        .back-btn {
            background: #cccccc;
            color: #333;
        }

        .signup-btn:hover {
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(255, 94, 98, 0.5);
        }

        .back-btn:hover {
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(204, 204, 204, 0.5);
        }
    </style>
</head>
<body>
    <div class="signup-container">
        <h2>회원가입</h2>
        <table>
            <tr>
                <td><label for="userID">아이디</label></td>
                <td><input type="text" id="userID" placeholder="아이디 입력"></td>
            </tr>
            <tr>
                <td><label for="nickname">닉네임</label></td>
                <td><input type="text" id="nickname" placeholder="닉네임 입력"></td>
            </tr>
            <tr>
                <td><label for="password">비밀번호</label></td>
                <td><input type="password" id="password" placeholder="비밀번호 입력"></td>
            </tr>
            <tr>
                <td><label for="address">주소</label></td>
                <td><textarea id="address" placeholder="주소 입력"></textarea></td>
            </tr>
        </table>
        <div class="button-group">
            <button class="signup-btn">회원가입</button>
            <button class="back-btn" onclick="history.back()">뒤로가기</button>
        </div>
    </div>
    <script type="text/javascript">
    $(".signup-btn").click(function(){
        // 각 입력 필드의 값을 가져옴
        var userID = $("#userID").val();
        var nickname = $("#nickname").val();
        var password = $("#password").val();
        var address = $("#address").val();
        
        console.log(userID, nickname, password, address);


        // 하나라도 빈 값이면 경고 메시지 출력
        if(userID === "" || nickname === "" || password === "" || address === "") {
            alert("정보를 모두 입력해주세요.");
        } else {
            // 모든 필드가 채워졌으면 AJAX 요청
            $.ajax({
                type: "get",
                dataType: "html",
                data: {
                    userID: userID,
                    nickname: nickname,
                    password: password,
                    address: address
                },
                url: "./signupaction.jsp",
                success: function() {
                    alert("정보가 추가되었습니다.");
                    location.href = "./loginpage.jsp";
                }
            });
        }
    });
</script>
</body>
</html>