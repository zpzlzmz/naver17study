<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="memo.data.MemoDto"%>
<%@page import="memo.data.MemoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <%
    	int idx=Integer.parseInt(request.getParameter("idx"));
    	MemoDao dao = new MemoDao();
    	MemoDto dto = dao.getOneMemos(idx);
    	
    	JSONObject ob = new JSONObject();
    	ob.put("idx",dto.getIdx());
		ob.put("nickname",dto.getNickname());
		ob.put("avata",dto.getAvata());
		ob.put("message",dto.getMessage());
    %>
    
    <%=ob%>