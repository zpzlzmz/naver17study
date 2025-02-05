<?xml version="1.0" encoding="UTF-8"?>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="ashop.data.shopDto"%>
<%@page import="java.util.List"%>
<%@page import="ashop.data.shopDao"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<data>
	
	<%
	shopDao dao = new shopDao();
	String search = request.getParameter("search");
	List<shopDto> list = dao.getAllDatas();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	for(shopDto dto:list){
		%>
		<shop idx = "<%=dto.getIdx() %>">
			<sangpum><%=dto.getSangpum() %></sangpum>
			<su><%=dto.getSu() %></su>
			<danga><%=dto.getDanga() %></danga>
			<ipgoday><%=dto.getIpgoday() %></ipgoday>
		</shop>
	<%}
	
	%>
	

</data>