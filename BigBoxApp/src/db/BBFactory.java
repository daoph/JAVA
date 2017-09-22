package db;

import db.BigBoxDB;
import db.BBDAO;

public class BBFactory {
	public static BBDAO getBBDAO() {
		BBDAO dao = new BigBoxDB();
		return dao;
	}
}
