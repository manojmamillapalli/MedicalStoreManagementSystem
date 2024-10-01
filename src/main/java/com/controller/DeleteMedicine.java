package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dao.MedicineDAO;

@WebServlet("/deletemed")
public class DeleteMedicine extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		MedicineDAO dao = new MedicineDAO();
		
		try {
			boolean status = dao.deleteById(id);
			if(status) {
				dao.commit();
			}
			else {
				dao.rollback();
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("viewmed");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
