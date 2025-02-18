<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>502 jsp study</title>
    <link
            href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu
            &family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap"
            rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <style>
        body * {
            font-family: 'Jua', sans-serif;
        }
    </style>
</head>
<body>
<img src="./image/mycar11.png" width="200px;">
<h2>컨트롤러로부터 포워드</h2>
<h3>메세지 : ${message}</h3>
<h3>오늘날짜 : ${today}</h3>
<h3>
    <fmt:formatDate value="${today}" pattern="yyyy-MM-dd HH:mm EEEE"/>
</h3>
<hr>
<ul>
    <li>
        <a href="./board/list">./board/list</a>
    </li>
    <li>
        <a href="./board/list.do">./board/list.do</a>
    </li>
    <li>
        <a href="./shop/list">./shop/list</a>
    </li>
    <li>
        <a href="./bitcamp/study">./bitcamp/study</a>
    </li>
    <li>
        <a href="./bitcamp/study2">./bitcamp/study2</a>
    </li>
</ul>
</body>
</html>