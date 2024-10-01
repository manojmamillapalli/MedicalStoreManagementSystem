package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.bean.Medicine;
import com.dao.MedicineDAO;
@WebServlet("/viewmed")
public class ShowAllMedicine extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option = request.getParameter("option");
		if (option == null || option.isEmpty()) {
		    option = "All"; 
		}
		HttpSession session = request.getSession();
		if (option != null && !option.isEmpty()) {
		    session.setAttribute("selectedOption", option);
		}
		MedicineDAO dao = new MedicineDAO();
		List<Medicine> medicines = null;
		try {
			if ( option.equals("All")) {
				medicines = dao.findAll();
			} else {
				medicines = dao.findByType(option);
			}
			request.setAttribute("medicines", medicines);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace(); 
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("viewmed.jsp");
		dispatcher.forward(request, response);
	}
}
