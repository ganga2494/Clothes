package rebel.web.Test;
import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import rebel.web.config.AppContextConfig;
import rebel.web.dao.Blogdao;
import rebel.web.dao.Queanforumdao;
import rebel.web.dao.UserDetailsDao;
import rebel.web.dao.JobsDao;
import rebel.web.model.Blog;
import rebel.web.model.Queanforum;
import rebel.web.model.UserDetails;
import rebel.web.model.Jobs;
import rebel.web.model.JobsRegistration;
public class Apptst {

	@SuppressWarnings({ "resource" })
	public static void main(String[] args) 
	{
		  @SuppressWarnings("unused")
		AbstractApplicationContext context=new AnnotationConfigApplicationContext(AppContextConfig.class);
	       
		  UserDetailsDao reg=(UserDetailsDao)context.getBean("UserDetails");
			

	      UserDetails user=new UserDetails();
	      
	      user.setAddress("Hyd");
	      user.setCity("Hyderabad");
	      user.setCountry("India");
	      user.setEmailid("abc.com");
	      
	      user.setFullname("Ahmed");
	      user.setIsonline(true);
	      user.setMobileno("8801029550");
	      user.setPassword("abc@123");
	     
	      user.setState("user");
	      
	      reg.addUser(user);
}

		      
	
		/*  Blogdao blogdao= (Blogdao) context.getBean("blogdao");
		  
		  
		  Blog blog = new Blog();
		  blog.setBlogTitle("mean stack");
		  blog.setBlogDescription("Angular js is pouplar");
		  blog.setCdate("18-jan-17");
		  blog.setCategory("ITCategory");
		  blog.setPostedBy("user");
		  blogdao.addBlog(blog);
	       System.out.println("main ended");
	        */
	/*	  Queanforumdao queanforum=(Queanforumdao) context.getBean("forumdao");
		  Queanforum forum=new Queanforum();
		  forum.setQuestDescription("dgdcgycil");
		  forum.setQuestTitle("ckdhacvkad");
		  queanforum.addQuestion(forum);  */
	

		  
		  
		  
}