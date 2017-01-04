package rebel.ClothesBack.dao;

import java.util.List;
import rebel.ClothesBack.model.AdminProduct;
import rebel.ClothesBack.model.Cart;
import rebel.ClothesBack.model.UserDetail;

public interface CartDao {
	
	public void insertCart(Cart c1);
	public List<Cart>get(String id);
	public List<AdminProduct>getparticulerProd(int id);
	public List<UserDetail>
	getUser(String id);
	

}

