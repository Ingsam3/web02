<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.sql.*, javax.naming.*, javax.sql.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>6. DBCP 커넥션 풀로 오라클 연결</title>
</head>
<body>

<%
	//선언문
	Connection con = null; // db 연결 con
	DataSource ds = null; //DBCP 커넥션 풀 관리 ds

%>

<%
	try{
		Context ctx = new InitialContext();
		ds = (DataSource)ctx.lookup("java:comp/env/jdbc/xe");
		//JNDI 디렉토리 서비스로 커넥션 풀 관리 ds 생성
		con=ds.getConnection();
		out.println("DBCP로 오라클 연결 성공");
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(con != null)con.close();
		}catch(Exception e){e.printStackTrace();}
		
	}

%>

</body>
</html>