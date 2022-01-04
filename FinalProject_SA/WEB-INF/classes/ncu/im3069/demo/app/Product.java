package ncu.im3069.demo.app;

import org.json.*;

public class Product {
	
    /** index，產品編號 */
    private int index;

    /** name，產品名稱 */
    private String name;

    /** price，產品價格 */
    private int price;

    /** image，產品圖片 */
    private String image;

    /** description，產品描述 */
//	private String description;

    /**
     * 實例化（Instantiates）一個新的（new）Product 物件<br>
     * 採用多載（overload）方法進行，此建構子用於新增產品時
     *
     * @param id 產品編號
     */
	public Product(int index) {
		setIndex(index);
	}

    /**
     * 實例化（Instantiates）一個新的（new）Product 物件<br>
     * 採用多載（overload）方法進行，此建構子用於新增產品時
     *
     * @param name 產品名稱
     * @param price 產品價格
     * @param image 產品圖片
     */
	public Product(String name, int price, String image) {
		setName(name);
		setPrice(price);
		setImage(image);
	}

    /**
     * 實例化（Instantiates）一個新的（new）Product 物件<br>
     * 採用多載（overload）方法進行，此建構子用於修改產品時
     *
     * @param id 產品編號
     * @param name 產品名稱
     * @param price 產品價格
     * @param image 產品圖片
     * @param describe 產品敘述
     */
	public Product(int index, String name, int price, String image, String description) {
		setIndex(index);
		setName(name);
		setPrice(price);
		setImage(image);
//		this.description = description;
	}

    /**
     * 設定Index
     * 
     * 
     */
    private void setIndex(int i) {
    	this.index=i;
    } 

    /**
     * 取得產品編號S
     *
     * @return int 回傳產品編號
     */
	public int getIndex() {
		return this.index;
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
     * 取得產品名稱
     *
     * @return String 回傳產品名稱
     */
	public String getName() {
		return this.name;
	}

    /**
     * 設定Price
     * 
     * 
     */
    private void setPrice(int p) {
    	this.price=p;
    }
    
    /**
     * 取得產品價格
     *
     * @return double 回傳產品價格
     */
	public int getPrice() {
		return this.price;
	}

    /**
     * 設定Image
     * 
     * 
     */
    private void setImage(String im) {
    	this.image=im;
    }
    
    /**
     * 取得產品圖片
     *
     * @return String 回傳產品圖片
     */
	public String getImage() {
		return this.image;
	}

    /**
     * 設定description
     * 
     * 
     */
//    private void setDescription(String d) {
//    	this.description=d;
//    }
//    
//    /**
//     * 取得產品敘述
//     *
//     * @return String 回傳產品敘述
//     */
//	public String getDescription() {
//		return this.description;
//	}

    /**
     * 取得產品資訊
     * 
     * @return JSONObject 回傳產品資訊
     */
	public JSONObject getData() {
        /** 透過JSONObject將該項產品所需之資料全部進行封裝*/
        JSONObject jso = new JSONObject();
        jso.put("index", getIndex());
        jso.put("name", getName());
        jso.put("price", getPrice());
        jso.put("image", getImage());
//        jso.put("description", getDescription());

        return jso;
    }
}
