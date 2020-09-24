package beautyhair.main.dao;

import java.security.Principal;
import java.util.List;

import beautyhair.main.entity.BlogPost;

public interface BlogPostDAO {

	
	public List<BlogPost> getBlogPostList();
	
	public List<BlogPost> getMyBlogPostList(Principal principal);
	
	public List<BlogPost> getAllEnabledBlogPosts();
	
	public List<BlogPost> getThreeImportantBlogsForIndexPage();
	
	public List<BlogPost> getTwoRecentBlogPosts();
	
	public List<BlogPost> getThreePopularBlogPosts();
	
	public List<BlogPost> getTwelweRecentBlogPosts();
	
	public BlogPost getBlogPost(int id);
	
	public void saveBlogPost(BlogPost blogPost);
	
	public void updateImportantBlogPost(int id);
	
	public void deleteBlogPost(int id);
	
	
	
}
