package com.tts.service.dao;

public interface BulkDAO {

	/**
	 * @param filePath the full path of CSV file as like: \\\\MIKE-PC\\share\\test.csv
	 * @return the total of insert
	 */
	public int insert(final String filePath);
	
}
