<%@page import="shop.data.ShopDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <%
    	//1.num 읽기
    	int num = Integer.parseInt(request.getParameter("num"));
    	//2. dao 선언
    	ShopDao dao = new ShopDao();
    	//3. 삭제메서드 호출 (dao에서 만들어야함 deleteShop(int num))
    	dao.deleteShop(num);
    	//4. 삭제를 했으니 목록으로 보내는것도 나쁘지 않을듯 ? 하려고 했으나, ajax 함수를 사용할려고 하기 때문에 .
    			
    %>