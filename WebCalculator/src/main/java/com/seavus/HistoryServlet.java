package com.seavus;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/history")
public class HistoryServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		HttpSession session = req.getSession();
		@SuppressWarnings("unchecked")
		ArrayList<Calculation> calculations = (ArrayList<Calculation>) session.getAttribute("calculations");
		if (calculations == null) {
			resp.getWriter().println("<h4> There aren't any calculations stored in this session. </h4>");
		} else {
			resp.getWriter().println("<h4> History of calculations in this session: </h4>");
			for (Calculation calculation : calculations) {
				resp.getWriter().println(calculation + "<br/>");
			}
		}
	}
}
