package ncu.im3069.demo.app;

import org.json.*;
// TODO: Auto-generated Javadoc
/**
 * <p>
 * The Class Manager
 * Manager類別（class）具有管理員所需要之屬性與方法，並且儲存與管理員相關之商業判斷邏輯<br>
 * </p>
 * 
 * @author IPLab
 * @version 1.0.0
 * @since 1.0.0
 */

public class Manager {

	private int managers_id;
	
	private String name;
	
	private String email;
	
	private String password;
	
	private ManagerHelper mh = ManagerHelper.getHelper();
	
	public Manager(String email,String password, String name) {
        setEmail(email);
        setPassword(password);
        setName(name);
	}
	
	private void setID(int id) {
		this.managers_id=id;
	}
	
	public int getID() {
		return this.managers_id;
	}
	
    private void setEmail(String e) {
    	this.email=e;
    }

    public String getEmail() {
        return this.email;
    }
    
    private void setName(String n) {
    	this.name=n;
    }
    
    public String getName() {
        return this.name;
    }
    
    private void setPassword(String psw) {
    	this.password=psw;
    }

    public String getPassword() {
        return this.password;
    }    
    
    public JSONObject getData() {
    	JSONObject jso=new JSONObject();
        jso.put("members_id", getID());
        jso.put("name", getName());
        jso.put("email", getEmail());
        jso.put("password", getPassword());
        
        return jso;    	
    }
}
