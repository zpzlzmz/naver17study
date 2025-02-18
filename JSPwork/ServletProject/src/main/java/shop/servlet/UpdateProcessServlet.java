package shop.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import shop.data.ShopDao;
import shop.data.ShopDto;

import java.io.IOException;


@WebServlet("/shop/update")
public class UpdateProcessServlet extends HttpServlet {
	 
	ShopDao dao=new ShopDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShopDto dto = new ShopDto();
		
		String sangpum=request.getParameter("sangpum");
		String scolor=request.getParameter("scolor");
		String sphoto=request.getParameter("sphoto");
		String ipgoday= request.getParameter("ipgoday");
		
		int sprice=Integer.parseInt(request.getParameter("sprice"));
		int scnt = Integer.parseInt(request.getParameter("scnt"));
		int num = Integer.parseInt(request.getParameter("num"));
		
		dto.setSangpum(sangpum);
		dto.setScolor(scolor);
		dto.setSphoto(sphoto);
		dto.setIpgoday(ipgoday);
		dto.setScnt(scnt);
		dto.setSprice(sprice);
		dto.setNum(num);
		
		dao.updateShop(dto);
		
		response.sendRedirect("./detail?num="+num);	
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
