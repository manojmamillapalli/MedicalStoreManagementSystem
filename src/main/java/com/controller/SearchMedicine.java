package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Medicine;
import com.dao.MedicineDAO;

@WebServlet("/searchmedicine")
public class SearchMedicine extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = (request.getParameter("name"));
		MedicineDAO dao = new MedicineDAO();
		
		try {
			Medicine medicine = dao.findByName(name);
			request.setAttribute("medicine", medicine);
			RequestDispatcher dispatcher = request.getRequestDispatcher("findmed.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
