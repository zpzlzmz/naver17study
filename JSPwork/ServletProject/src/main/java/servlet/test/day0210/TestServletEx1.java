package servlet.test.day0210;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Servlet implementation class TestServletEx1
 */
@WebServlet("/bit/hello.do")
public class TestServletEx1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request ->set Attribute 로 저장함(각종 데이터 저장하기)
		request.setAttribute("today", new Date());
		request.setAttribute("myname", "이영자");
		request.setAttribute("myage", 19); 
		
		
		SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		request.setAttribute("today2", sdf.format(new Date()));
		
		//jsp 파일로 포워드 
		RequestDispatcher rd = request.getRequestDispatcher("../jstltest/result1.jsp");
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
