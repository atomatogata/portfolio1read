package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DriverTest
 */
@WebServlet("/DriverTest")
public class DriverTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		response.setContentType("text/html; charset=Shift_JIS");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>データベーステスト</title>");
		out.println("</head>");
		out.println("<body>");

		String msg = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			msg = "ドライバのロードに成功しました";
		} catch (ClassNotFoundException e) {
			msg = "ドライバのロードに失敗しました";
		} catch (Exception e) {
			msg = "ドライバのロードに失敗しました";
		}

		out.println("<p>");
		out.println(msg);
		out.println("</p>");

		out.println("</body>");
		out.println("</html>");
	}
}