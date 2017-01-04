package rebel.ClothesBack.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import rebel.ClothesBack.model.AdminProduct;

@Repository("aproductDao")
public class AdminProductDao implements AProductDao 
{

	@Autowired
	 SessionFactory sessionFactory;
	
	
	
	public void addProdSave(AdminProduct adprod)
	{
		System.out.println("Product Dao");
		Session session= sessionFactory.openSession();
		System.out.println("insert method called");
		session.beginTransaction();
		System.out.println(adprod.getAproductId());
		System.out.println(adprod.getAprice());
		System.out.println(adprod.getAdesciption());
		System.out.println(adprod.getAprodName());
		session.save(adprod);
		
		
		session.getTransaction().commit();
		session.close();
	
	}
	@SuppressWarnings("rawtypes")
	public String listAdProd()
	{
		System.out.println("in adProduct listttttproduct1");
		Session se= sessionFactory.openSession();
		se.beginTransaction();
		List li=se.createQuery("from AdminProduct").list();
			Gson gson = new Gson();
	
		String jsonprodlist=gson.toJson(li);
		se.getTransaction().commit();
		se.close();
		System.out.println("in list of products");
		return jsonprodlist ;
	}
	
	public void deleteAdProd(int apid)
	{
		Session se=sessionFactory.openSession();
		 se.beginTransaction();
		AdminProduct adp=(AdminProduct)se.get(AdminProduct.class,apid);
		se.delete(adp);
		se.getTransaction().commit();
		se.close();
		
	}
	public void upAdProd(AdminProduct apd)
	{
		Session se=sessionFactory.openSession();
		 se.beginTransaction();
		 int apid=apd.getAproductId();
		AdminProduct adobj=(AdminProduct)se.get(AdminProduct.class,apid);
		adobj.setAdesciption(apd.getAdesciption());
		adobj.setAprodName(apd.getAprodName());
		adobj.setAprice(apd.getAprice());
		adobj.setAcategoryId(apd.getAcategoryId());
		adobj.setAstock(apd.getAstock());
		adobj.setAsupplierId(apd.getAsupplierId());
		

		 se.update(adobj);
		 se.getTransaction().commit();
	
		 se.close();
		
		
	}
	public AdminProduct DispRecord(int apid)
	{
		Session se=sessionFactory.openSession();
		 se.beginTransaction();
		AdminProduct adpd=(AdminProduct)se.get(AdminProduct.class,apid);
		return adpd;
		
	}
	public int sortId()
	{
		
		
		Session session=sessionFactory.openSession();

		Query query = session.createQuery("from AdminProduct order by aproductId DESC");
		query.setMaxResults(1);
		AdminProduct last = (AdminProduct) query.uniqueResult();
		int id=last.getAproductId();
		System.out.println("last column product id "+id);
		return id;
	}
	
	@SuppressWarnings("rawtypes")
	public String lisCatWise(String cat)
	{
		System.out.println("in adProduct listttttproduct1");
		Session se= sessionFactory.openSession();
		se.beginTransaction();
		
		
		Criteria cr = se.createCriteria(AdminProduct.class);
		cr.add(Restrictions.like("aprodName", "+cat+"+"%"));
		List li = cr.list();
		//List li=se.createQuery("from AdminProduct where aprodName = "+ "'"+cat+"'").list();
			Gson gson = new Gson();
	
		String jsonprodlist=gson.toJson(li);
		se.getTransaction().commit();
		se.close();
		System.out.println("in adProduct listttttproduct2");
		return jsonprodlist ;
	}	


	
}
