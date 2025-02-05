
<%-- <%@page import="shop.data.ShopDao"%>
<%@page import="shop.data.ShopDto"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <jsp:useBean id="dao" class="shop.data.ShopDao"/>
    <jsp:useBean id="dto" class="shop.data.ShopDto"/>
    <jsp:setProperty property="*" name="dto"/>
    
    <%
    	dao.insertShop(dto);
    %>
    
    <%-- <%
    	//num 필요없고 그거말고 다 필요한가 ? 
    	//시간도 필요 없음 
    	//근데 입고데이는 필요할듯 
    	
    	String sangpum = request.getParameter("sangpum");
    	String scolor = request.getParameter("scolor");
    	int scnt = Integer.parseInt(request.getParameter("scnt"));
    	int sprice = Integer.parseInt(request.getParameter("sprice"));
    	String sphoto = request.getParameter("sphoto");
    	String ipgoday = request.getParameter("ipgoday");
    	
    	ShopDto dto = new ShopDto();
    	
    	dto.setSangpum(sangpum);
    	dto.setScolor(scolor);
    	dto.setScnt(scnt);
    	dto.setSprice(sprice);
    	dto.setSphoto(sphoto);
    	dto.setIpgoday(ipgoday);
    	
    	ShopDao dao = new ShopDao();
    	dao.insertShop(dto);
    	
    %> 
    
    <data>
    	<result><%=sangpum %>의 정보가 DB에 추가되었습니다.</result>
    </data> --%>