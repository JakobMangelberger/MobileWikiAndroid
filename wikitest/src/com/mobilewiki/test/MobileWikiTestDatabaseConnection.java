package com.mobilewiki.test;

import com.mobilewiki.DatabaseController;
import com.mobilewiki.MainActivity;
import android.test.ActivityInstrumentationTestCase2;


public class MobileWikiTestDatabaseConnection extends ActivityInstrumentationTestCase2<MainActivity> {

	@SuppressWarnings("deprecation")
	public MobileWikiTestDatabaseConnection() {
		super("com.mobilewiki", MainActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		
	}
	
	public void test_DatabaseConnection() {
		String db_username = "mobilewikia";
		String db_pwd = "sewm2013";
		DatabaseController db_controller = new DatabaseController(db_username, db_pwd);
		
		assertNotNull("1. Connection is null!", db_controller.getConnection());
		assertNotNull("1. Statement is null!", db_controller.getStatement());
		
		db_username = "test";
		db_pwd =  "test";
		db_controller = new DatabaseController(db_username, db_pwd);
		
		assertNotNull("2. Connection is null!", db_controller.getConnection());
		assertNotNull("2. Statement is null!", db_controller.getStatement());		
	}
	
}
