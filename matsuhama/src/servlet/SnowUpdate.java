package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SnowDAO2;
import model.SnowBean;

/**
 * Servlet implementation class SnowUpdate
 */
@WebServlet("/SnowUpdate")
public class SnowUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		int primaryId = (int) session.getAttribute("primaryId");
		request.setCharacterEncoding("UTF-8");
		SnowDAO2 snowDAO2 = new SnowDAO2();
		snowDAO2.delete(primaryId);
		List<SnowBean> list = new ArrayList<>();
		list = snowDAO2.findAll();
		session.setAttribute("list", list);

		if (primaryId > 0) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/snow.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int primaryId = (int) session.getAttribute("primaryId");
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String text = request.getParameter("text");
		SnowDAO2 snowDAO2 = new SnowDAO2();
		snowDAO2.update(name, text, primaryId);

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(name);
		out.println(text);
		out.println(primaryId);
	}

}
