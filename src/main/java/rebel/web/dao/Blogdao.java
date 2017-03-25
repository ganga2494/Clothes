package rebel.web.dao;

import java.util.List;

import rebel.web.model.Blog;

public interface Blogdao {
	public void addBlog(Blog blog);
	public void updateBlog(Blog blog);
	public void deleteBlog(Blog blog);
	public Blog getBlogByBlogId(String blogId);
	public List<Blog> listBlogs();
	public List<Blog> listNewBlogs();
	public List<Blog> listApprovedBlogs();
	
}
