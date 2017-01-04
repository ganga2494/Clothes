package rebel.ClothesBack.dao;
import rebel.ClothesBack.model.Supplier;

public interface SupplierDao
{

	public int sortId();
	public void UpRecord(Supplier sup);
	public Supplier DispRecord(int sid);
	public void deleteSupplier(int sid);
	public String listSupplier();
	public void saveSupplier(Supplier supp);
	
}