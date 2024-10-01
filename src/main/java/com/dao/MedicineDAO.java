package com.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import com.bean.Medicine;
import com.mysql.cj.xdevapi.Result;

public class MedicineDAO {
	Connection conn = null;

	public boolean save(Medicine med) throws ClassNotFoundException, SQLException {
		conn = ConnectionManager.getConnection();
		String query = "insert into medicines1(name,quantity,type,manufacturer,expdate,price) values(?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, med.getName());
		ps.setInt(2, med.getQuantity());
		ps.setString(3, med.getType());
		ps.setString(4, med.getManufacturer());
		ps.setString(5, med.getExpdate());
		ps.setString(6, med.getPrice());
		
		int count = ps.executeUpdate();
		if(count != 0) {
			return true;
		}
		else {
			return false;
		}
		
	}

	public void commit() throws SQLException {
		conn.commit();
		conn.close();
		
	}

	public void rollback() throws SQLException {
		conn.rollback();
		conn.close();
		
	}
	
	public List<Medicine> findByType(String option) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionManager.getConnection();
		conn.setAutoCommit(true);
		String query = "select * from medicines1 where type = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, option);
		ResultSet rs = ps.executeQuery();
List<Medicine> medicines = new ArrayList<Medicine>();
		
		while(rs.next()) {
			Medicine med = new Medicine();
			
			med.setBno(rs.getInt(1));
			med.setName(rs.getString(2));
			med.setQuantity(rs.getInt(3));
			med.setType(rs.getString(4));
			med.setManufacturer(rs.getString(5));
			med.setExpdate(rs.getString(6));
			med.setPrice(rs.getString(7));
			medicines.add(med);
			
		}
		if(conn != null) {
			conn.close();
		}
		return medicines;
	}
	

	public List<Medicine> findAll() throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionManager.getConnection();
		conn.setAutoCommit(true);
		String query = "select * from medicines1";
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		List<Medicine> medicines = new ArrayList<Medicine>();
		
		while(rs.next()) {
			Medicine med = new Medicine();
			
			med.setBno(rs.getInt(1));
			med.setName(rs.getString(2));
			med.setQuantity(rs.getInt(3));
			med.setType(rs.getString(4));
			med.setManufacturer(rs.getString(5));
			med.setExpdate(rs.getString(6));
			med.setPrice(rs.getString(7));
			medicines.add(med);
			
		}
		if(conn != null) {
			conn.close();
		}
		return medicines;
		
	}
	

	public boolean edit(Medicine med) throws ClassNotFoundException, SQLException {
		conn = ConnectionManager.getConnection();
		String query = "update medicines1 set name = ?, quantity = ?, type = ?, manufacturer = ?, expdate = ?, price = ? where id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, med.getName());
		ps.setInt(2, med.getQuantity());
		ps.setString(3, med.getType());
		ps.setString(4, med.getManufacturer());
		ps.setString(5, med.getExpdate());
		ps.setString(6, med.getPrice());
		ps.setInt(7, med.getId());
		
		int count = ps.executeUpdate();
		if(count != 0) {
			return true;
		}
		else {
			return false;
		}
		
	}

	public boolean deleteById(int id) throws ClassNotFoundException, SQLException {
		conn = ConnectionManager.getConnection();
		String query = "delete from medicines1 where id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, id);
		int count = ps.executeUpdate();
		if(count != 0)
			return true;
		else
			return false;
	}

	public Medicine findByName(String name) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionManager.getConnection();
		String query = "select * from medicines1 where name = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		Medicine med = new Medicine();
		if(rs.next()) {
			med.setBno(rs.getInt("id"));
			med.setName(rs.getString("name"));
			med.setQuantity(rs.getInt("quantity"));
			med.setType(rs.getString("type"));
			med.setManufacturer(rs.getString("manufacturer"));
			med.setExpdate(rs.getString("expdate"));
			med.setPrice(rs.getString("price"));
			
		}
		if(conn != null)
			conn.close();
		return med;
	}

	
	
}
