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

		if (list.size() == 0) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/snow.jsp");
			dispatcher.forward(request, response);
		} else {

			response.setContentType("text/html; charset=Shift_JIS");
			PrintWriter out = response.getWriter();
			for (int i = 0; i < list.size(); i++) {
				out.println(list.get(i).getName());
				out.println(list.get(i).getText());
			}

		}
	}

}
