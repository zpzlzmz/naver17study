<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page contentType="application/json; charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>

<%
    // request 객체로 장바구니 가져오기 (request에 저장된 장바구니가 없으면 빈 리스트로 초기화)
    List<Map<String, String>> cart = (List<Map<String, String>>) request.getAttribute("cart");
    if (cart == null) {
        cart = new ArrayList<>();
        request.setAttribute("cart", cart);
    }

    // 클라이언트에서 받은 장바구니 데이터
    String name = request.getParameter("name");
    String imageUrl = request.getParameter("imageUrl");
    String price = request.getParameter("price");

    // 데이터가 있을 경우 장바구니에 추가
    if (name != null && imageUrl != null && price != null) {
        Map<String, String> burger = new HashMap<>();
        burger.put("name", name);
        burger.put("imageUrl", imageUrl);
        burger.put("price", price);
        
        cart.add(burger);  // 장바구니에 추가
    }

    // 성공 메시지 반환 (JSON 형식)
    response.setContentType("application/json");
    out.print("{\"status\": \"success\", \"message\": \"Item added to cart.\"}");
%>
