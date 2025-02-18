package reboard.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import reboard.data.BoardDao;

import java.io.IOException;


@WebServlet("/board/delete")
public class BoardDeleteProcessServlet extends HttpServlet {
	BoardDao dao=new BoardDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//num
		int num = Integer.parseInt(request.getParameter("num"));
		//pagenum 도 읽어야함 ㅋㅋ 
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		//passwd
		String passwd=request.getParameter("passwd");
		//비번이 맞는지 boolean으로 
		
		//true면 삭제 후 목록으로 이동(이때 pagenum 전달) redirect 
		
		//false 면 fail.jsp 로 포워드
		boolean b = dao.isCheckPass(num, passwd);
		
		if(b) {
			dao.deleteBoard(num);
			response.sendRedirect("./list?pageNum="+pageNum);
		}else {
			RequestDispatcher rd=request.getRequestDispatcher("./fail.jsp");
			rd.forward(request, response);
		}
		
	} 

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
