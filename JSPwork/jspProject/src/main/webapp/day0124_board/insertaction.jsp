<%@page import="simpleboard.data.SimpleBoardDao"%>
<%@page import="simpleboard.data.SimpleBoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 
    <%
    	//1.formdata 읽기
    	String writer=request.getParameter("writer");
    	String subject=request.getParameter("subject");
    	String content=request.getParameter("content");
    	//2. dto선언 후 데이터 넣기(생성자로)
    	SimpleBoardDto dto = new SimpleBoardDto(writer,subject,content);
    	//3. dao 선언
    	SimpleBoardDao dao = new SimpleBoardDao();
    	
    	//4. insert 메서드 호출 
    	dao.insertBoard(dto);
    	
    	//5. boardlist.jsp로 이동
    	response.sendRedirect("./boardlist.jsp");
    	
    %> --%>
    
    
    
    
    
    
    
    
    
    <jsp:useBean id="dao" class="simpleboard.data.SimpleBoardDao"/>
    <jsp:useBean id="dto" class="simpleboard.data.SimpleBoardDto"/>
    <!-- DTO와 이름이 같은 폼태그를 읽어서 자동으로 dto에 넣어준다(property *) -->
    <jsp:setProperty property="*" name="dto"/>
    
    <%
    	dao.insertBoard(dto);
    	response.sendRedirect("./boardlist.jsp");
    %>
    
    