package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SnowDAO2;

/**
 * Servlet implementation class SnowUpdate
 */
@WebServlet("/SnowUpdate")
public class SnowUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		int deleteId = Integer.parseInt(request.getParameter("deleteId"));
		SnowDAO2 snowDAO2 = new SnowDAO2();
		snowDAO2.delete(deleteId);

		if (deleteId > 0) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WelcomServlet");
			dispatcher.forward(request, response);
		}

	}

}
