package ncu.im3069.demo.app;

import org.json.*;
import java.util.Calendar;

// TODO: Auto-generated Javadoc
/**
 * <p>
 * The Class Member
 * Member類別（class）具有會員所需要之屬性與方法，並且儲存與會員相關之商業判斷邏輯<br>
 * </p>
 * 
 * @author IPLab
 * @version 1.0.0
 * @since 1.0.0
 */

public class Member {
    
    /** members_id，會員編號 */
    private int members_id;
    
    /** email，會員電子郵件信箱 */
    private String email;
    
    /** name，會員姓名 */
    private String name;
    
    /** password，會員密碼 */
    private String password;
    
    /** modified，修改時間*/
    private java.sql.Timestamp modified;
    
    /** login_times，更新時間的分鐘數 */
    private int login_times=0;
    
    /** status，會員之組別 */
    private int status;
    
    
    /** mh，MemberHelper之物件與Member相關之資料庫方法（Sigleton） */
    private MemberHelper mh =  MemberHelper.getHelper();
    
    /**
     * 實例化（Instantiates）一個新的（new）Member物件<br>
     * 採用多載（overload）方法進行，此建構子用於建立會員資料時，產生一名新的會員
     *
     * @param email 會員電子信箱
     * @param password 會員密碼
     * @param name 會員姓名
     */
    public Member(String name,String email, String password) {
    	setName(name);
        setEmail(email);
        setPassword(password);
        update();
    }

    /**
     * 實例化（Instantiates）一個新的（new）Member物件<br>
     * 採用多載（overload）方法進行，此建構子用於更新會員資料時，產生一名會員同時需要去資料庫檢索原有更新時間分鐘數與會員組別
     * 
     * @param members_id 會員編號
     * @param email 會員電子信箱
     * @param password 會員密碼
     * @param name 會員姓名
     */
    public Member(int members_id, String email, String password, String name) {
    	setID(members_id);
    	setEmail(email);
    	setPassword(password);
    	setName(name);
        /** 取回原有資料庫內該名會員之更新時間分鐘數與組別 */
//        getLoginTimesStatus();
        /** 計算會員之組別 */
//        calcAccName();
    }
    
    /**
     * 實例化（Instantiates）一個新的（new）Member物件<br>
     * 採用多載（overload）方法進行，此建構子用於查詢會員資料時，將每一筆資料新增為一個會員物件
     *
     * @param members_id 會員編號
     * @param email 會員電子信箱
     * @param password 會員密碼
     * @param name 會員姓名
     * @param login_times 更新時間的分鐘數
     * @param status the 會員之組別
     */
    public Member(int members_id, String email, String password, String name, int login_times, int status) {
        setID(members_id);
        setEmail(email);
        setPassword(password);
        setName(name);
        setLoginTimes(login_times);
        setStatus(status);
    }
    
    public Member(String email, String password) {
        setEmail(email);
        setPassword(password);
    }
    
    /**
     * 設定ID
     * 
     * 
     */
    private void setID(int id) {
    	this.members_id=id;
    }
    
    /**
     * 取得會員之編號
     *
     * @return the members_id 回傳會員編號
     */
    public int getID() {
        return this.members_id;
    }
    
    /**
     * 設定email
     * 
     * 
     */
    private void setEmail(String e) {
    	this.email=e;
    }

    /**
     * 取得會員之電子郵件信箱
     *
     * @return the email 回傳會員電子郵件信箱
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * 設定name
     * 
     * 
     */
    private void setName(String n) {
    	this.name=n;
    }

    /**
     * 取得會員之姓名
     *
     * @return the name 回傳會員姓名
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * 設定password
     * 
     * 
     */
    private void setPassword(String psw) {
    	this.password=psw;
    }

    /**
     * 取得會員之密碼
     *
     * @return the password 回傳會員密碼
     */
    public String getPassword() {
        return this.password;
    }
    
    /**
     * 設定logintimes 
     * 
     * 
     */
    private void setLoginTimes(int lt) {
    	this.login_times=lt;
    }
    
    /**
     * 取得更新資料時間之分鐘數
     *
     * @return the login times 回傳更新資料時間之分鐘數
     */
    public int getLoginTimes() {
        return this.login_times;
    }
    
    /**
     * 設定status
     * 
     * 
     */
    private void setStatus(int s) {
    	this.status=s;
    }
    
    /**
     * 取得會員資料之會員組別
     *
     * @return the status 回傳會員組別
     */
    public int getStatus() {
        return this.status;
    }
    
    /**
     * 更新會員資料
     *
     * @return the JSON object 回傳SQL更新之結果與相關封裝之資料
     */
    public JSONObject update() {
        /** 新建一個JSONObject用以儲存更新後之資料 */
        JSONObject data = new JSONObject();
        /** 取得更新資料時間（即現在之時間）之分鐘數 */
//        Calendar calendar = Calendar.getInstance();
//        this.login_times = calendar.get(Calendar.MINUTE);
        /** 計算帳戶所屬之組別 */
//        calcAccName();
        this.login_times+=1;
        /** 檢查該名會員是否已經在資料庫 */
        if(this.members_id != 0) {
            /** 若有則將目前更新後之資料更新至資料庫中 */
            mh.updateLoginTimes(this);
            /** 透過MemberHelper物件，更新目前之會員資料置資料庫中 */
            data = mh.update(this);
        }
        
        return data;
    }
    
    /**
     * 取得該名會員所有資料
     *
     * @return the data 取得該名會員之所有資料並封裝於JSONObject物件內
     */
    public JSONObject getData() {
        /** 透過JSONObject將該名會員所需之資料全部進行封裝*/ 
        JSONObject jso = new JSONObject();
        jso.put("members_id", getID());
        jso.put("name", getName());
        jso.put("email", getEmail());
        jso.put("password", getPassword());
        jso.put("login_times", getLoginTimes());
        jso.put("status", getStatus());
        
        return jso;
    }
    
    /**
     * 取得資料庫內之更新資料時間分鐘數與會員組別
     *
     */
//    private void getLoginTimesStatus() {
//        /** 透過MemberHelper物件，取得儲存於資料庫的更新時間分鐘數與會員組別 */
//        JSONObject data = mh.getLoginTimesStatus(this);
//        /** 將資料庫所儲存該名會員之相關資料指派至Member物件之屬性 */
//        this.login_times = data.getInt("login_times");
//        this.status = data.getString("status");
//    }
    
    /**
     * 計算會員之組別<br>
     * 若為偶數則為「偶數會員」，若為奇數則為「奇數會員」
     */
//    private void calcAccName() {
//        /** 計算目前分鐘數為偶數或奇數 */
//        String curr_status = (this.login_times % 2 == 0) ? "偶數會員" : "奇數會員";
//        /** 將新的會員組別指派至Member之屬性 */
//        this.status = curr_status;
//        /** 檢查該名會員是否已經在資料庫，若有則透過MemberHelper物件，更新目前之組別狀態 */
//        if(this.members_id != 0) mh.updateStatus(this, curr_status);
//    }
}