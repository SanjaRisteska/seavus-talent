import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class WebCalculator extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("com.seavus.hellowebworld.HelloWebWorldServlet.doGet");
		printMessage(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("com.seavus.hellowebworld.HelloWebWorldServlet.doPost");
		printMessage(req, resp);
	}

	private void printMessage(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		Calculation calculation = new Calculation(req.getParameter("operation"),
				Integer.parseInt(req.getParameter("firstNumber")), Integer.parseInt(req.getParameter("secondNumber")));
		int result = calculation.calculate();

		resp.setContentType("text/html");
		resp.getWriter().println("<h1> RESULT: </h1><br/>" + calculation.getFirstNumber() + " "
				+ calculation.getOperation() + " " + calculation.getSecondNumber() + " = " + result + "<br/>");
	}
}
