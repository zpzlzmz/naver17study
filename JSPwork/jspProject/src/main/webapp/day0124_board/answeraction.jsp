<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



	<jsp:useBean id="adao" class="simpleboard.data.SimpleAnswerDao"/>
	<jsp:useBean id="adto" class="simpleboard.data.SimpleAnswerDto"/>
	<jsp:setProperty property="*" name ="adto"/>
    <%
    	adao.insertAnswer(adto);
    response.sendRedirect("./contentdetail.jsp?num="+adto.getNum());
    %>