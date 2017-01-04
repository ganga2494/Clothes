package rebel.ClothesBack.Test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import rebel.ClothesBack.config.ApplicationContextConfig;
import rebel.ClothesBack.dao.AProductDao;
import rebel.ClothesBack.dao.CategoryDao;
import rebel.ClothesBack.dao.SupplierDao;
import rebel.ClothesBack.dao.UserDao;
import rebel.ClothesBack.model.Category;
import rebel.ClothesBack.model.Supplier;
import rebel.ClothesBack.model.UserDetail;

public class TestCase
{
	
	static AnnotationConfigApplicationContext context;
	
	public TestCase()
	{
		 context= new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
		 context.scan("rebel.ClothesBack");
	}
	public static void main(String[] args) 
	{	
		try{
			System.out.println("main started..");
			TestCase tc = new TestCase();
			
			UserDetail user = new UserDetail();
			Category cat = new Category();
			Supplier supp = new Supplier();
		user.setName("gangadhar");
		user.setUserName("gangarebel"); 
		user.setPassword("prabhas");
		user.setEmail("ganga2494@gmail.com");
		user.setMobile("9515062994");
		System.out.println("done=="+user);
		//UserDao userdao = new UserDaoImpl();
		UserDao userdao = (UserDao)context.getBean("userdaoimpl");
		SupplierDao supplierdao = (SupplierDao)context.getBean("supplierdao");
		CategoryDao categoryDao = (CategoryDao)context.getBean("categoryDao");
		AProductDao aproductDao = (AProductDao)context.getBean("aproductDao");

		System.out.println("userdao="+userdao);
		userdao.saveorupdate(user);
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("main ended...");
}
}
