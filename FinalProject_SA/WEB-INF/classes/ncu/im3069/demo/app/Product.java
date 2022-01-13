package ncu.im3069.demo.app;

import java.sql.Timestamp;

import org.json.*;

public class Product {
	
    /** index，書籍編號 */
    private int index;

    /** name，書籍名稱 */
    private String name;

    /** author，書籍作者 */
    private String author;

    /** publisher，書籍出版商 */
    private String publisher;
    
    /** publish_date，書籍出版時間 */
    private java.sql.Timestamp publish_date;
    
    /** price，書籍價格 */
    private int price;

    /** image，書籍圖片 */
    private String image;

    /** stock，書籍庫存 */
    private int stock;

    /** genre，書籍類別 */
    private String genre;
    
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
     * @param author 作者
     * @param publisher 出版者
     * @param publish_date 出版時間
     * @param stock 庫存
     * @param genre 類型
     */
	public Product(int index, String name, int price, String image, String author, String publisher, Timestamp publish_date, int stock, String genre) {
		setIndex(index);
		setName(name);
		setPrice(price);
		setImage(image);
		setAuthor(author);
		setPublisher(publisher);
		setPublish_date(publish_date);
		setStock(stock);
		setGenre(genre);
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
     * 設定author
     * 
     * 
     */
    private void setAuthor(String a) {
    	this.author=a;
    }
    
    /**
     * 取得書籍作者
     *
     * @return String 回傳書籍作者
     */
	public String getAuthor() {
		return this.author;
	}

    /**
     * 設定publisher
     * 
     * 
     */
    private void setPublisher(String p) {
    	this.publisher=p;
    }
    
    /**
     * 取得書籍出版商
     *
     * @return String 回傳書籍出版商
     */
	public String getPublisher() {
		return this.publisher;
	}

    /**
     * 設定publish_date
     * 
     * 
     */
    private void setPublish_date(java.sql.Timestamp d) {
    	this.publish_date=d;
    }
    
    /**
     * 取得書籍出版日期
     *
     * @return String 回傳書籍出版日期
     */
	public java.sql.Timestamp getPublish_date() {
		return this.publish_date;
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
     * 設定stock
     * 
     * 
     */
    private void setStock(int s) {
    	this.stock=s;
    }
    
    /**
     * 取得書籍庫存
     *
     * @return String 回傳書籍庫存
     */
	public int getStock() {
		return this.stock;
	}

    /**
     * 設定genre
     * 
     * 
     */
    private void setGenre(String g) {
    	this.genre=g;
    }
    
    /**
     * 取得書籍類別
     *
     * @return String 回傳書籍類別
     */
	public String getGenre() {
		return this.genre;
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
