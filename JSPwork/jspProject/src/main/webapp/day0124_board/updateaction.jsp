<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>\
    
    <%-- 자바 빈즈를 이용해서 처리하기  --%>

    <jsp:useBean id="dao" class="simpleboard.data.SimpleBoardDao"/>
    <jsp:useBean id="dto" class="simpleboard.data.SimpleBoardDto"/>
    <jsp:setProperty property="*" name ="dto"/>
    
    
    <%
    dao.updateBoard(dto);
    response.sendRedirect("./contentdetail.jsp?num="+dto.getNum());
    	
    	
    %>