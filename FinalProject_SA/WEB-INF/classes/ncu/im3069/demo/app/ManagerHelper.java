package ncu.im3069.demo.app;

import java.sql.*;

import ncu.im3069.demo.util.DBMgr;
public class ManagerHelper {

	private ManagerHelper() {
		
	}

	private static ManagerHelper mh;
	
	private Connection conn = null;
	
	private PreparedStatement pres = null;
	
	public static ManagerHelper getHelper() {
		if(mh==null) {
			mh=new ManagerHelper();
		}
		return mh;
	}
	
	public JSONObject create(Manager m) {
		long start_time=System.nanoTime();
		int row=0;
		
		String name=m.getName();
		String email=m.getEmail();
		String password=m.getPassword();
		
		CallableStatement cs;
		try {	
            /** 取得資料庫之連線 */
            conn = DBMgr.getConnection();
		    // 設定 CallableStatement
		    cs = conn.prepareCall("sp name");
		    // 設定 IN 參數的 Index 及值
		    cs.setString(1, name);
		    cs.setString(2, email);
		    cs.setString(3, password);
		    
		    // 執行 CallableStatement
		    cs.execute();
		    } catch (SQLException e) {
		}
		long end_time=System.nanoTime();
		
		long duration=(end_time-start_time);
        
		JSONObject response =new JSONOoject();
		
		return response;
	}
}
