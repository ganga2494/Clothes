package rebel.ClothesBack.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import rebel.ClothesBack.model.Supplier;

@Repository("supplierdao")
public class SupplierDaoImpl implements SupplierDao
{
	@Autowired
	 SessionFactory sessionFactory;
	public void saveSupplier(Supplier supp)
	{
		Session session= sessionFactory.openSession();
		System.out.println("insert method called");
		session.beginTransaction();
		session.save(supp);
		session.getTransaction().commit();
			session.close();
		
		
	}
	@SuppressWarnings("rawtypes")
	public String listSupplier()
	{
		
		Session se= sessionFactory.openSession();
		se.beginTransaction();
		List li=se.createQuery("from Supplier").list();
			Gson gson = new Gson();
	
		String jsoncatlist=gson.toJson(li);
		se.getTransaction().commit();
		se.close();
		return jsoncatlist ;
	}
	public void deleteSupplier(int sid)
	{
		Session se=sessionFactory.openSession();
		 se.beginTransaction();
		Supplier sup=(Supplier)se.get(Supplier.class,sid);
		se.delete(sup);
		se.getTransaction().commit();
		se.close();
		
	}
	public Supplier DispRecord(int sid)
	{
		Session se=sessionFactory.openSession();
		 se.beginTransaction();
		Supplier sup=(Supplier)se.get(Supplier.class,sid);
		return sup;
		
	}
	public void UpRecord(Supplier sup)
	{
		Session se=sessionFactory.openSession();
		 se.beginTransaction();
		 int sid=sup.getSuppId();
		Supplier supobj=(Supplier)se.get(Supplier.class,sid);
		supobj.setSuppName(sup.getSuppName());
		supobj.setContactNo(sup.getContactNo());
		supobj.setSuppAdd(sup.getSuppAdd());

		 se.update(supobj);
		 se.getTransaction().commit();
	
		 se.close();
		
		
	}
	public int sortId()
	{
		
		Session session=sessionFactory.openSession();
		
		Query query = session.createQuery("from Supplier order by suppId DESC");
		query.setMaxResults(1);
		Supplier last = (Supplier) query.uniqueResult();
		int id=last.getSuppId();
		return id;
	}



}
