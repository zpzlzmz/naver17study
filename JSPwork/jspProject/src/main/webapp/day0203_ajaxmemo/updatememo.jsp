<%@page import="memo.data.MemoDao"%>
<%@page import="memo.data.MemoDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    int idx=Integer.parseInt(request.getParameter("idx"));
	String avata=request.getParameter("avata");
	String nickname=request.getParameter("nickname");
	String message=request.getParameter("message");
	
	 MemoDto dto=new MemoDto();
	 dto.setAvata(avata);
	 dto.setNickname(nickname);
	 dto.setMessage(message);
	 dto.setIdx(idx);

	
	 MemoDao dao = new MemoDao();
	 dao.updateMemo(dto);

	

%>