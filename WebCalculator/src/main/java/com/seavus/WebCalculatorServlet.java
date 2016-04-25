package com.seavus;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calculation")
public class WebCalculatorServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet()");
		printResult(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost()");
		printResult(req, resp);
	}

	@SuppressWarnings("unchecked")
	public void printResult(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		ArrayList<Calculation> calculations;
		HttpSession session = req.getSession();

		calculations = (ArrayList<Calculation>) session.getAttribute("calculations");
		if (calculations == null) {
			calculations = new ArrayList<Calculation>();
		}

		int firstOperand = Integer.parseInt(req.getParameter("firstNumber"));
		int secondOperand = Integer.parseInt(req.getParameter("secondNumber"));
		String operator = req.getParameter("operator");

		Calculation calculation = new Calculation(firstOperand, secondOperand, operator);
		calculations.add(calculation);
		session.setAttribute("calculations", calculations);

		resp.getWriter().println(calculation);

	}

}
