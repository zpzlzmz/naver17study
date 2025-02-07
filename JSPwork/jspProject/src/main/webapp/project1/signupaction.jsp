<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="OneProject.SignUpDto" %>
<%@ page import="OneProject.SignUpDao" %>

<jsp:useBean id="dto" class="OneProject.SignUpDto" />
<jsp:useBean id="dao" class="OneProject.SignUpDao" />

<%
    // 폼에서 전달된 값들을 DTO에 설정
    String userID = request.getParameter("userID");
    String nickname = request.getParameter("nickname");
    String password = request.getParameter("password");
    String address = request.getParameter("address");

    // DTO 객체에 값 세팅
    dto.setUserid(userID);
    dto.setNickname(nickname);
    dto.setPasswd(password);
    dto.setAddr(address);

    // DB에 사용자 정보 저장
    dao.insertUserInfo(dto);
%>
