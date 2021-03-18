package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SnowUpdateControll")
public class SnowUpdateControll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		int alterId = 0;

		try {
			alterId = Integer.parseInt(request.getParameter("alterId"));
			request.setAttribute("alterId", alterId);
		} catch (NumberFormatException e) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println(e + "未選択です"
					+ "<a href=\"/matsuhama/\">戻る</a>");
		}

		if (alterId > 0) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/snowAlter.jsp");
			dispatcher.forward(request, response);
		}

	}

}
