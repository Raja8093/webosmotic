package com.techmunna.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.techmunna.model.Employee;

public class DataAccess {
	
	public String url="jdbc:mysql://localhost:3306/webosmotic";
	public String user="root";
	public String password="Raja@8093";
	
	public Connection con =null;
	public PreparedStatement ps=null;
	public Statement s =null;
	
	
	
	
	public  void delete(int id) {
		
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,user,password);
			
			ps=con.prepareStatement("delete from Employee where sno = ?");
			ps.setInt(1, id);
			
		    ps.executeUpdate();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			try 
			{
				 ps.close();
				 con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	
	public  void update(Employee e) {

		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 con= DriverManager.getConnection(url, user, password);
			
		 	 ps= con.prepareStatement("update Employee set sname= ?, email= ?, pass=?, mobile=? where sno= ?");
			
			ps.setString(1, e.getName());
			ps.setString(2, e.getGender());
			ps.setString(3,e.getDob());
			ps.setString(2, e.getEmail());
			ps.setString(4, e.getPhone());
			ps.setInt(5, e.getId());
			ps.executeUpdate();
		
		} 
		catch (Exception em) 
		{
			em.printStackTrace();
		}
		finally 
		{
			
			try 
			{
				ps.close();
				con.close();
			} 
			catch (SQLException em) 
			{
				em.printStackTrace();
			}
	
	
		}
	}
	
	public Employee getEmployeeById(int id) {
		
		Employee e = new Employee();
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection(url,user,password);
			
			ps = con.prepareStatement("select * from Employee where eno= ?");
			ps.setInt(1, id);
			
			ResultSet rs= ps.executeQuery();
			 while(rs.next()) {
				 
				 e.setId(id);
				 e.setName(rs.getString("name"));
				 e.setGender(rs.getString("gender"));
				 e.setDob(rs.getString("dob"));
				 e.setEmail(rs.getString("email"));
				 e.setPhone(rs.getString("phone"));
			 }
			
		} 
		catch (ClassNotFoundException | SQLException ep) {
			// TODO Auto-generated catch block
			ep.printStackTrace();
		}finally {
			
			try {
				ps.close();
				con.close();
			} catch (SQLException em) {
				// TODO Auto-generated catch block
				em.printStackTrace();
			}
			
		}
		
		return e;
	}
	
	
	
	public void insert(Employee e) {
		
		//write the  JDBC code for inserting 
		

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			 con= DriverManager.getConnection(url, user, password);
			
		 	ps= con.prepareStatement("insert into Employee(name, gender, dob, email, phone) values(?,?,?,?)");
			
			ps.setString(1, e.getName());
			ps.setString(2,e.getGender());
			ps.setString(3, e.getDob());
			ps.setString(4, e.getEmail());
			ps.setString(5, e.getPhone());
			
			ps.executeUpdate();
			System.out.println("Row is inserted");
		} catch (SQLException | ClassNotFoundException em) {
			// TODO Auto-generated catch block
			em.printStackTrace();
		}
		finally {
			
			try {
				ps.close();
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public ArrayList<Employee> getAllEmployee(){
		
		ArrayList<Employee> all= new ArrayList<Employee>();
		

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				 con= DriverManager.getConnection(url, user, password);
				 s = con.createStatement();
				
				
				ResultSet rs= s.executeQuery("select * from Employee");
				while(rs.next()) {
					int i= rs.getInt("eno");
					String n=rs.getString("name");
					String e= rs.getString("gender");
					String p= rs.getString("dob");
					String m=rs.getString("email");
					String q=rs.getString("phone");
					
					Employee emp =new Employee(i,n,e,p,m,q);
					all.add(emp);
				}
				
			} catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				
				try {
					s.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return all;
		}

}