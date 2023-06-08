package com.test.neulbom.admin.manage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.neulbom.admin.manage.repository.EqDAO;
import com.test.neulbom.admin.manage.repository.EqDTO;

@WebServlet("/admin/manage/editEquip.do")
public class EditEquip extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// EditEquip.java
		
		String eq_seq = req.getParameter("eq_seq");
		
		EqDAO dao = new EqDAO();
		
		EqDTO eqDto = new EqDTO();
		
		eqDto = dao.detailEquip(eq_seq);

		req.setAttribute("eq_seq", eq_seq);
		req.setAttribute("eqDto", eqDto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/manage/editEquip.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		EqDAO dao = new EqDAO();
		
		String eq_seq = req.getParameter("eq_seq");
		String name = req.getParameter("name");
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		
		EqDTO eqDto = new EqDTO();
		
		eqDto.setEq_seq(eq_seq);
		eqDto.setName(name);
		eqDto.setQuantity(quantity);
		
		int result = dao.editEquip(eqDto);
		
		if (result == 1) {
			resp.sendRedirect("/neulbom/admin/manage/showEquip.do");
		} else {
			PrintWriter writer = resp.getWriter();
			writer.print("<script>alert('[Edit Equip] failed');history.back();</script>");
			writer.close();
		} 
		
	}

}












































