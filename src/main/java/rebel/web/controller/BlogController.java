package rebel.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rebel.web.dao.Blogdao;
import rebel.web.model.Blog;
import rebel.web.model.UserDetails;

@RestController
public class BlogController {
	
	@Autowired
	Blogdao blogDAO;

	
	//-------------------Retrieve All Blogs--------------------------------------------------------
    
	@RequestMapping(value="/blog/", method=RequestMethod.GET)
    public ResponseEntity<List<Blog>> listAllBlogs() {
        List<Blog> blogs = blogDAO.listBlogs();
        if(blogs.isEmpty()){
            return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Blog>>(blogs, HttpStatus.OK);
    }
	
	//-------------------Retrieve All New Blogs--------------------------------------------------------
	@RequestMapping(value="/blog/new", method=RequestMethod.GET)
	
    public ResponseEntity<List<Blog>> listAllNewBlogs() {
        List<Blog> blogs = blogDAO.listNewBlogs();
        if(blogs.isEmpty()){
            return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Blog>>(blogs, HttpStatus.OK);
    }
	
	//-------------------Retrieve Approved New Blogs--------------------------------------------------------
	@RequestMapping(value="/blog/Approved", method=RequestMethod.GET)
	
    public ResponseEntity<List<Blog>> listApprovedBlogs() {
        List<Blog> blogs = blogDAO.listApprovedBlogs();
        if(blogs.isEmpty()){
            return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Blog>>(blogs, HttpStatus.OK);
    }


	
//	//-------------------Retrieve Single Blog--------------------------------------------------------
 @RequestMapping(value="/blog/{id}", method=RequestMethod.GET ,produces=MediaType.APPLICATION_JSON_VALUE)  
	
    public ResponseEntity<Blog> getBlog(@PathVariable("id") String id) {
        
        Blog blog = blogDAO.getBlogByBlogId(id);
        if (blog == null) {
            
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Blog>(blog, HttpStatus.OK);
    }

	
	
	//-------------------Create a Blog--------------------------------------------------------
	@RequestMapping(value="/blog", method=RequestMethod.POST)
	
    public ResponseEntity<Void> createBlog(@RequestBody Blog blog,HttpSession session) {
		UserDetails currentUser =  (UserDetails)session.getAttribute("user");
		//currentUser.setUserid(session.getAttribute(arg0));

		blog.setUser(currentUser);
        blogDAO.addBlog(blog);
  
       
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
	
	
	 //------------------- Update a User --------------------------------------------------------
	@RequestMapping(value="/blog/{id}", method=RequestMethod.PUT)
	
    public ResponseEntity<Blog> updateBlog(@PathVariable("id") String id, @RequestBody Blog blog) {
      
          
        Blog currentBlog = blogDAO.getBlogByBlogId(id);
          
        if (currentBlog==null) {
            
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
  
        currentBlog.setTitle(blog.getTitle());
        currentBlog.setDescription(blog.getDescription());
       
        
          
        blogDAO.updateBlog(currentBlog);
        return new ResponseEntity<Blog>(currentBlog, HttpStatus.OK);
    }
  
	
	//------------------- Delete a blog --------------------------------------------------------
	@RequestMapping(value="/blog/{id}", method=RequestMethod.DELETE)
	
    public ResponseEntity<Blog> deleteBlog(@PathVariable("id") String id) {
        		  
        Blog blog = blogDAO.getBlogByBlogId(id);
        if (blog == null) {
            
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
  
        blogDAO.deleteBlog(blog);
        return new ResponseEntity<Blog>(HttpStatus.NO_CONTENT);
    }
    

//-------------------Approve Blog--------------------------------------------------------
	@RequestMapping(value="/approveblog/{id}", method=RequestMethod.POST ,produces=MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Blog> approveBlog(@PathVariable("id") String id) {
        
        Blog blog = blogDAO.getBlogByBlogId(id);
        
        if (blog == null) {
            
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
        blog.setStatus("Approved");
        blogDAO.updateBlog(blog);
        return new ResponseEntity<Blog>(blog, HttpStatus.OK);
    }
	
//-------------------Reject Blog--------------------------------------------------------
	@RequestMapping(value="/rejectblog/{id}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	
    public ResponseEntity<Blog> rejectBlog(@PathVariable("id") String id) {
        
        Blog blog = blogDAO.getBlogByBlogId(id);
        
        if (blog == null) {
            
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
        blog.setStatus("Rejected");
        blogDAO.updateBlog(blog);
        return new ResponseEntity<Blog>(blog, HttpStatus.OK);
    }
}



