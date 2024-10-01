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

@WebServlet("/savemedicine")
public class SaveMedicine extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Medicine med = new Medicine();
		
		med.setName(request.getParameter("name"));
		med.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		med.setType(request.getParameter("type"));
		med.setManufacturer(request.getParameter("manufacturer"));
		med.setExpdate(request.getParameter("expdate"));
		med.setPrice(request.getParameter("price"));
		
		MedicineDAO dao = new MedicineDAO();
		
		try {
			boolean status = dao.save(med);
			if(status) {
				dao.commit();
				request.setAttribute("status", "Medicine Added...");
			}
			else {
				dao.rollback();
				request.setAttribute("status", "Medicine not Added....");
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("addmed.jsp");
			dispatcher.forward(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
