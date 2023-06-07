package com.test.neulbom.client.community;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.neulbom.client.repository.ClientDAO;
import com.test.neulbom.client.repository.FreeDTO;

@WebServlet("/client/community/addfree.do")
public class AddFree extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Free.java
		
		String mode = req.getParameter("mode");
		String thread = req.getParameter("thread");
		String depth = req.getParameter("depth");
		
		req.setAttribute("mode", mode);
		req.setAttribute("thread", thread);
		req.setAttribute("depth", depth);
		
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/client/community/addfree.jsp");
		dispatcher.forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1. 데이터 가져오기
		//2. DB 작업 > insert
		//3. 결과

		//로그인 한 사람만 글 작성/수정/삭제 가능 > session에서 id 가져오기
		HttpSession session = req.getSession();
		
		
		//입력한 값 가져오기
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String pic = req.getParameter("pic");
		
		String mode = req.getParameter("mode");

		//DAO 포장
		FreeDTO dto = new FreeDTO();
		ClientDAO dao = new ClientDAO();
		
		dto.setId((String)session.getAttribute("id"));	//로그인 id 전송
		dto.setLv((Integer)session.getAttribute("lv"));	//로그인 lv 전송
		dto.setTitle(title);
		dto.setContent(content);
		dto.setFile(pic);
		
		int thread = -1;
		int depth = -1;
		
		
		//계산
		if (mode.equals("new")) {
			//새 글 쓰기
			//1. 현존하는 모든 게시물 중에서 가장 큰 thread값을 찾아서, 그 값에 +10을 한 값을 새 글의 thread값으로 넣는다.
			thread = dao.getMaxThread() + 10;
			
			
			//2. 새 글의 depth는 항상 0을 넣는다.
			depth = 0;
			
		} else {
			//답변글 쓰기
			//1. 현존하는 모든 게시물의 thread값을 대상으로, 현재 작성 중인 답변글의 부모글 thread값보다 작고(미만), 
			//이전 새글의 thread값보다 큰(초과) thread를 모두 찾아서 -1을 한다. 
			//	> 부모글의 thread와 depth를 알아내야하고, 이전 새글의 thread값 필요
			int parentThread = Integer.parseInt(req.getParameter("thread"));
			int parentDepth = Integer.parseInt(req.getParameter("depth"));
			int previousThread = (int)Math.floor((parentThread - 1) / 10) * 10;
			
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			
			map.put("parentThread", parentThread);
			map.put("previousThread", previousThread);
			
			dao.updateThread(map);
			
			
			//2. 답변글의 thread값은 부모글의 thread값 -1을 넣는다.
			thread = parentThread - 1;
			
			//3. 답변글의 depth값을 부모글의 depth값 +1을 넣는다.
			depth = parentDepth + 1;
		}
		
		
		
		dto.setThread(thread);
		dto.setDepth(depth);
		
		
		int result = dao.add(dto);
		
		if (result == 1) {
			resp.sendRedirect("/client/community/free.do");
		} else {
			PrintWriter writer = resp.getWriter();
			writer.print("<script>alert('failed');history.back();</script>");
			writer.close();
		}

		
		
		
		
	}

}