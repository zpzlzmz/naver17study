<%@page import="OneProject.SignUpDao"%>
<%@page import="OneProject.SignUpDto"%>
<%@page language="java" contentType="text/plain; charset=UTF-8" pageEncoding="UTF-8"%> 

<%
    // 디버깅 로그 (서버 콘솔 확인용)
    System.out.println("로그인 시작");
    String userID = request.getParameter("userID");
    String password = request.getParameter("password");
    System.out.println("아이디: " + userID + ", 비밀번호: " + password);

    // 데이터베이스 조회
    SignUpDao dao = new SignUpDao();
    SignUpDto dto = dao.getUserById(userID);
    System.out.println("dto: " + dto);

    // 아이디와 비밀번호 검증
    if (dto != null && dto.getPasswd().equals(password)) {
        session.setAttribute("user", dto);
        out.print("success");  
    } else {
        out.print("fail");  
    }
%>

