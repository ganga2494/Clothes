package rebel.ClothesBack.dao;

import rebel.ClothesBack.model.AdminProduct;

public interface AProductDao
{
	public void addProdSave(AdminProduct adprod);
	public String listAdProd();
	public void deleteAdProd(int apid);
	public void upAdProd(AdminProduct apd);
	public AdminProduct DispRecord(int apid);
	public int sortId();
	public String lisCatWise(String cat);

}
