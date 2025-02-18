package reboard.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import reboard.data.BoardDao;

import java.io.IOException;


@WebServlet("/board/deletepassform")
public class BoardDeletePassFormServlet extends HttpServlet {
	BoardDao dao=new BoardDao();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String num=request.getParameter("num");
		String pageNum = request.getParameter("pageNum");
		
		request.setAttribute("num", num);
		request.setAttribute("pageNum", pageNum);
		
		RequestDispatcher rd=request.getRequestDispatcher("./deletepassform.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
