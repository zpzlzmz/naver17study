<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="memo.data.MemoDto"%>
<%@page import="java.util.List"%>
<%@page import="memo.data.MemoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	MemoDao dao=new MemoDao();
    	List<MemoDto> list = dao.getAllMemos();
    	
    	JSONArray arr = new JSONArray();
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    	
    	for(MemoDto dto:list){
    		JSONObject ob = new JSONObject();
    		
    		ob.put("idx",dto.getIdx());
    		ob.put("nickname",dto.getNickname());
    		ob.put("avata",dto.getAvata());
    		ob.put("message",dto.getMessage());
    		ob.put("writeday",sdf.format(dto.getWriteday()));
    		
    		arr.add(ob);
    		
    	}
    	
    %>
    
    <%=arr%>