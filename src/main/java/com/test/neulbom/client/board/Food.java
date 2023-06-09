package com.test.neulbom.client.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.neulbom.client.repository.FoodDAO;
import com.test.neulbom.client.repository.FoodDTO;

@WebServlet("/client/board/food.do")
public class Food extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Food.java
		
		String searchType = req.getParameter("searchType");
		String keyword = req.getParameter("keyword");
		
		FoodDAO dao = new FoodDAO();
		
		List<FoodDTO> list = null; 
				
		if(searchType == null && keyword == null) {
			list = dao.list();
		}else {
			list = dao.search(searchType, keyword);
		}
		
		req.setAttribute("list", list);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/client/board/food.jsp");
		dispatcher.forward(req, resp);
	}

}
