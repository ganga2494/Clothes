package rebel.ClothesBack.dao;

import rebel.ClothesBack.model.Category;

public interface CategoryDao 
{
	
	public void delete(String id);
	public void saveOrUpdate(Category category) ;
	public String  list();
	public Category get(String id);

}
