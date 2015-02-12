package org.kay.zoo.sheep;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

public class TestSQL {
	public static void main(String args[]) {
		Connection conn = null;
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:test.db");
			
			// load file
			InputStream is = new FileInputStream("F:\\dog.jpg");
			byte[] buffer = new byte[is.available()];
			is.read(buffer);
			
			String sql = "insert into gameInfo(gameName, bookSize, createTime, coverImage) values (?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "彩虹岛");
			pstmt.setInt(2, 1000);
			pstmt.setDate(3, new Date(System.currentTimeMillis()));
			pstmt.setBytes(4, buffer);
			pstmt.executeUpdate();
			pstmt.close();
			
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Opened database successfully");
	}
}
