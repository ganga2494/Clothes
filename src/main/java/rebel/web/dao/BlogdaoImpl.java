package rebel.web.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import rebel.web.model.Blog;


@Repository
@EnableTransactionManagement
@Transactional

public class BlogdaoImpl implements Blogdao {
	
	@Autowired
	 SessionFactory sessionFactory; 

	

	
	
		
	
	
	public void addBlog(Blog blog) {
		
		System.out.println("Blog dao impl" +  blog);
		blog.setBlogId(generateBlogId());
		blog.setStatus("New");
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(blog);
		
	}

	public void updateBlog(Blog blog) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(blog);
		
	}

	public void deleteBlog(Blog blog) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(blog);
		
	}

	public Blog getBlogByBlogId(String blogId) {
		Session session=sessionFactory.getCurrentSession();
		Blog blog=null;
		try{
		blog=(Blog)session.createQuery("from Blog where blogId='"+blogId+"'").getSingleResult();
		System.out.println(blog.getBlogId());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return blog;
	}

	public List<Blog> listBlogs() {
		Session session=sessionFactory.getCurrentSession();
		List<Blog> blogs=session.createQuery("from Blog").getResultList();
		
		return blogs;
	}
	
	public List<Blog> listNewBlogs() {
		Session session=sessionFactory.getCurrentSession();
		List<Blog> blogs=session.createQuery("from Blog where status='New'").getResultList();
		
		return blogs;
	}
	
	public List<Blog> listApprovedBlogs() {
		Session session=sessionFactory.getCurrentSession();
		List<Blog> blogs=session.createQuery("from Blog where status='Approved'").getResultList();
		
		return blogs;
	}

	
	
	
	
	
	
	
	@SuppressWarnings({ "deprecation", "rawtypes" })
	@Transactional
	private String generateBlogId(){
		
		String newBid="";
		Session ss = sessionFactory.openSession();			
		Transaction t=ss.beginTransaction();
		
		
		Query qq = ss.createQuery("from Blog");
		if(qq.list().isEmpty())	{
			newBid="BLOG00001";
		}
		else{	
			Query q = ss.createQuery("select max( blogId) from Blog");			
			String prevId = q.list().get(0).toString();
			//String prevId = data.get(0).toString();
			System.out.print("\nExisting : "+prevId);
			int id = Integer.parseInt(prevId.substring(4));
			System.out.print("\nExisting id : "+id);
			id=id+1;
			if(id<=9)
				newBid="BLOG0000"+id;
			else if(id<=99)
				newBid="BLOG000"+id;
			else if(id<=999)
				newBid="BLOG00"+id;
			else if(id<=9999)
				newBid="BLOG0"+id;
			else
				newBid="BLOG"+id;		
			System.out.print("\nGenerated : "+newBid);
			t.commit();			
		}
		ss.close();	
		return newBid;
	}

	
}
