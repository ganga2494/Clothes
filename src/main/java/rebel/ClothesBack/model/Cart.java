package rebel.ClothesBack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Table
@Component
@Entity
public class Cart 
{

	@Id
	@GeneratedValue
	private int cartid;
	@Column
	private String cartuser;
	
	@Column
	private String pid;
		
	@Column
	private String itemname;
	@Column
	private int price;
	@Column
	private int qty;
	@Column
	private int total;
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public String getCartuser() {
		return cartuser;
	}
	public void setCartuser(String cartuser) {
		this.cartuser = cartuser;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
	
			
	
}