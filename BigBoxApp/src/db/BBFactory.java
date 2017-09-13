package db;

import db.BigBoxDBArray;
import db.BBDAO;

public class BBFactory {
	public static BBDAO getBBDAO() {
		BBDAO dao = new BigBoxDBArray();
		return dao;
	}
}
