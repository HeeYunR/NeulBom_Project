package com.test.neulbom.client.account;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.neulbom.client.repository.AccountDTO;
import com.test.neulbom.client.repository.ClientDAO;

@WebServlet("/client/account/searchid.do")
public class SearchId extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//SearchId.java

		//공유
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/client/account/searchid.jsp");
		dispatcher.forward(req, resp);

	}
	
		

}