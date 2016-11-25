package com.tts.service.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.tts.service.dao.BulkDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class BulkDAOImpl implements BulkDAO {

	@Autowired
	private DataSource dataSource;

	@Override
	public int insert(final String filePath) {
		final String sql = "BULK INSERT test FROM '" + filePath + "' WITH(FIELDTERMINATOR =',',ROWTERMINATOR = '\\n')";
		System.out.println(sql);
		Connection conn = null;
		PreparedStatement pst = null;
		int total = 0;
		try {
			conn = dataSource.getConnection();
			pst = conn.prepareStatement(sql);
			total = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return total;
	}

}
