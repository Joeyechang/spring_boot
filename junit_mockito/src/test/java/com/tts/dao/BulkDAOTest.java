package com.tts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.tts.service.dao.BulkDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BulkDAOTest {

	@Autowired
	private BulkDAO bulkDAO;

	@Autowired
	private DataSource ds;

	@Test
	public void testInsert() {
		long t1 = System.currentTimeMillis();
		try {
			System.out.println("total: " + bulkDAO.insert("\\\\MIKE-PC\\share\\test.csv"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		long t2 = System.currentTimeMillis();
		System.out.println("total time:" + (t2 - t1));
	}

	@Test
	public void testDs() {
		try {
			Connection conn = ds.getConnection();
			String sql = "SELECT TOP 10 * FROM TEST";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString("name"));
			}
			rs.close();
			pst.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
