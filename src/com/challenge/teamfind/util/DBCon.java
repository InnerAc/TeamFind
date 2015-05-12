package com.challenge.teamfind.util;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DBCon {
	public String getDriverStr() {
		return driverStr;
	}

	public void setDriverStr(String driverStr) {
		this.driverStr = driverStr;
	}

	public String getConnStr() {
		return ConnStr;
	}

	public void setConnStr(String connStr) {
		ConnStr = connStr;
	}

	public Connection getConn() {
		return Conn;
	}

	public void setConn(Connection conn) {
		Conn = conn;
	}

	public Statement getStmt() {
		return Stmt;
	}

	public void setStmt(Statement stmt) {
		Stmt = stmt;
	}

	private String driverStr="com.mysql.jdbc.Driver";
	private String ConnStr;
	private Connection Conn;
	private Statement Stmt;
	
	public DBCon()
	{
		try{
			Class.forName(driverStr).newInstance();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public ResultSet excuteQuery(String sql)
	{
		ResultSet rs=null;
		String userName = "teamfind";
		String password = "teamfind";
		String url = "jdbc:mysql://localhost/teamfindsql";
		try{
			Conn = DriverManager.getConnection(url, userName, password);	
			Stmt = Conn.createStatement();
			rs = Stmt.executeQuery(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public int excuteUpdate(String sql)
	{
		int result=0;
		
		String userName = "teamfind";
		String password = "teamfind";
		String url = "jdbc:mysql://localhost/teamfindsql";
		try{
			Conn = DriverManager.getConnection(url, userName, password);	
			Stmt = Conn.createStatement();
			result = Stmt.executeUpdate(sql);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	public void close()
	{
		try{
			Stmt.close();
			Conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
