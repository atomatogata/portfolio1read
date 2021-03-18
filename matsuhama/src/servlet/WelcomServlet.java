package servlet;

import java.io.IOException;
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

@WebServlet("/WelcomServlet")
public class WelcomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/snowWrite.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<SnowBean> list = new ArrayList<>();
		SnowDAO2 snowDAO2 = new SnowDAO2();
		list = snowDAO2.findAll();
		HttpSession session = request.getSession();
		session.setAttribute("list", list);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/snow.jsp");
		dispatcher.forward(request, response);

	}

}
