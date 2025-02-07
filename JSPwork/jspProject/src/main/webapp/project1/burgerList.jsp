<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="OneProject.BurgerDao, OneProject.BurgerDto, java.util.List" %>

<%
    String category = request.getParameter("category");
    System.out.println("category: " + category);  // 로그로 category 값을 확인

    BurgerDao burgerDao = new BurgerDao();
    List<BurgerDto> list = burgerDao.getBurgersByCategory(category);
    System.out.println("Burger List: " + list);  // 이 부분에서 List의 toString()이 호출됩니다.

%>
[
<% for (int i = 0; i < list.size(); i++) {
    BurgerDto burger = list.get(i);
%>
    {
        "id": <%= burger.getId() %>,
        "name": "<%= burger.getName() %>",
        "description": "<%= burger.getDescription() %>",
        "price": <%= burger.getPrice() %>,
        "imageUrl": "<%= burger.getImageUrl() %>"
    }<% if (i < list.size() - 1) { %>,<% } %>
<% } %>
]
