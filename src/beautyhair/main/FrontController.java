package beautyhair.main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import beautyhair.main.dao.BlogPostDAO;
import beautyhair.main.dao.CategoryDAO;
import beautyhair.main.dao.CompanyDAO;
import beautyhair.main.dao.MessageDAO;
import beautyhair.main.dao.PartnerDAO;
import beautyhair.main.dao.PictureDAO;
import beautyhair.main.dao.UserDAO;
import beautyhair.main.entity.BlogPost;
import beautyhair.main.entity.Message;
import beautyhair.main.entity.Picture;

@Controller
@RequestMapping("/")
public class FrontController {

	
	@Autowired
	private CompanyDAO companyDAO;
	
	@Autowired
	private MessageDAO messageDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private PictureDAO pictureDAO;
	
	@Autowired
	private BlogPostDAO blogPostDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private PartnerDAO partnerDAO;
	
	
	
	@RequestMapping({"/", "index"})
	public String getIndexPage(Model model) {
		List<BlogPost> blogPostList = blogPostDAO.getThreeImportantBlogsForIndexPage();
		List<BlogPost> recentBlogPostList = blogPostDAO.getTwoRecentBlogPosts();
		
		LocalDate dateToday = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		for(BlogPost bp : blogPostList) {
			LocalDate date = LocalDate.parse(bp.getDate(), formatter);
			bp.setDateOptionOne(Period.between(date, dateToday).getMonths() + " months ago");
		}
		
		for(BlogPost bp : recentBlogPostList) {
			LocalDate date = LocalDate.parse(bp.getDate(), formatter);
			bp.setDateOptionOne(date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
		}
		
		model.addAttribute("companyInfo", companyDAO.getCompanyInfo());
		model.addAttribute("employeeList", userDAO.getFourEmployeesForIndex());
		model.addAttribute("pictureList", pictureDAO.getThreeImportantPicturesForIndex());
		model.addAttribute("partnerList", partnerDAO.getFourImportantPartnersForIndex());
		model.addAttribute("footerPartnerList", partnerDAO.getSixPartnersForFooter());
		model.addAttribute("recentBlogPostList", recentBlogPostList);
		model.addAttribute("blogPostList", blogPostList);
		
		return "front/index-page";
	}
	
	@RequestMapping("/about")
	public String getAboutPage(Model model) {
		List<BlogPost> recentBlogPostList = blogPostDAO.getTwoRecentBlogPosts();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		for(BlogPost bp : recentBlogPostList) {
			LocalDate date = LocalDate.parse(bp.getDate(), formatter);
			bp.setDateOptionOne(date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
		}
		
		model.addAttribute("companyInfo", companyDAO.getCompanyInfo());
		model.addAttribute("employeeList", userDAO.getFourEmployeesForIndex());
		model.addAttribute("footerPartnerList", partnerDAO.getSixPartnersForFooter());
		model.addAttribute("recentBlogPostList", recentBlogPostList);
		
		return "front/about-page";
	}

	@RequestMapping("/services")
	public String getServicesPage(Model model) {
		List<BlogPost> recentBlogPostList = blogPostDAO.getTwoRecentBlogPosts();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		for(BlogPost bp : recentBlogPostList) {
			LocalDate date = LocalDate.parse(bp.getDate(), formatter);
			bp.setDateOptionOne(date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
		}
		
		model.addAttribute("companyInfo", companyDAO.getCompanyInfo());
		model.addAttribute("footerPartnerList", partnerDAO.getSixPartnersForFooter());
		model.addAttribute("recentBlogPostList", recentBlogPostList);
		
		return "front/services-page";
	}
	
	@RequestMapping("/work")
	public String getWorkPage(Model model, @RequestParam(defaultValue = "0") int pageNum) {
		List<Picture> pictureList = pictureDAO.getAllVisiblePictures();
		List<BlogPost> recentBlogPostList = blogPostDAO.getTwoRecentBlogPosts();
		
		// Blog
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		for(BlogPost bp : recentBlogPostList) {
			LocalDate date = LocalDate.parse(bp.getDate(), formatter);
			bp.setDateOptionOne(date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
		}
		
		// Pictures
		int numOfPages; 
		if(pictureList.size() % 9 == 0) {
			numOfPages = pictureList.size() / 9;
		}
		else {
			numOfPages = pictureList.size() / 9 + 1;
		}
		
		ArrayList<Picture> list = new ArrayList<Picture>();
		
		for(int i = 0; i < 9; i++ ) {
			if(pictureList.size() > pageNum * 9 + i) {
				list.add(pictureList.get(pageNum * 9 + i));
			}
			else {
				break;
			}
		}
 		
		model.addAttribute("companyInfo", companyDAO.getCompanyInfo());
		model.addAttribute("footerPartnerList", partnerDAO.getSixPartnersForFooter());
		model.addAttribute("recentBlogPostList", recentBlogPostList);
		model.addAttribute("pictureList", list);
		model.addAttribute("numberOfPages", numOfPages);
		model.addAttribute("pageNum",  pageNum);
		
		return "front/work-page";
	}
	
	@RequestMapping("/blog")
	public String getBlogPage(Model model, @RequestParam(defaultValue = "0") int pageNum) {
		List<BlogPost> blogPostList = blogPostDAO.getAllEnabledBlogPosts();
		List<BlogPost> recentBlogPostList = blogPostDAO.getTwoRecentBlogPosts();
		
		// Blog
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		for(BlogPost bp : recentBlogPostList) {
			LocalDate date = LocalDate.parse(bp.getDate(), formatter);
			bp.setDateOptionOne(date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
		}
		
		// Pictures
		int numOfPages; 
		if(blogPostList.size() % 6 == 0) {
			numOfPages = blogPostList.size() / 6;
		}
		else {
			numOfPages = blogPostList.size() / 6 + 1;
		}
		
		ArrayList<BlogPost> list = new ArrayList<BlogPost>();
		
		for(int i = 0; i < 6; i++ ) {
			if(blogPostList.size() > pageNum * 6 + i) {
				list.add(blogPostList.get(pageNum * 6 + i));
			}
			else {
				break;
			}
		}
		model.addAttribute("companyInfo", companyDAO.getCompanyInfo());
		model.addAttribute("footerPartnerList", partnerDAO.getSixPartnersForFooter());
		model.addAttribute("recentBlogPostList", recentBlogPostList);
		model.addAttribute("blogPostList", list);
		model.addAttribute("numberOfPages", numOfPages);
		model.addAttribute("pageNum",  pageNum);
		
		return "front/blog-page";
	}
	
	@RequestMapping("/blog-single")
	public String getBlogSinglePage(Model model, @RequestParam int blogId) {
		List<BlogPost> recentBlogPostList = blogPostDAO.getTwoRecentBlogPosts();
		List<BlogPost> popularBlogPostList = blogPostDAO.getThreePopularBlogPosts();
		BlogPost blog = blogPostDAO.getBlogPost(blogId);
		
		
		// BlogPost Date
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		for(BlogPost bp : recentBlogPostList) {
			LocalDate date = LocalDate.parse(bp.getDate(), formatter);
			bp.setDateOptionOne(date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
		}
	

		for(BlogPost bp : popularBlogPostList) {
			LocalDate date = LocalDate.parse(bp.getDate(), formatter);
			bp.setDateOptionTwo(date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
		}
		
		
		model.addAttribute("companyInfo", companyDAO.getCompanyInfo());
		model.addAttribute("categoryList", categoryDAO.getEightMostUsedCategories());
		model.addAttribute("footerPartnerList", partnerDAO.getSixPartnersForFooter());
		model.addAttribute("recentBlogPostList", recentBlogPostList);
		model.addAttribute("popularBlogPostList", popularBlogPostList);
		model.addAttribute("singleBlog", blog);
		
		
		return "front/blog-single-page";
	}
	
	@RequestMapping("/contact")
	public String getContactPage(Model model, @RequestParam(defaultValue = "neutral") String success) {
		List<BlogPost> recentBlogPostList = blogPostDAO.getTwoRecentBlogPosts();
 		
		// BlogPost date
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		for(BlogPost bp : recentBlogPostList) {
			LocalDate date = LocalDate.parse(bp.getDate(), formatter);
			bp.setDateOptionOne(date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
		}

		// Messages
		if(success.equalsIgnoreCase("true")) {
			model.addAttribute("success", 1);
		}
		
		
		
		model.addAttribute("companyInfo", companyDAO.getCompanyInfo());
		model.addAttribute("footerPartnerList", partnerDAO.getSixPartnersForFooter());
		model.addAttribute("recentBlogPostList", recentBlogPostList);
		model.addAttribute("message", new Message());
		
		return "front/contact-page";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/message-save")
	public String saveMessage(Model model, @Valid @ModelAttribute Message message, BindingResult result) {
		System.out.println(1);
		if(result.hasErrors()) {
			System.out.println(2);
			model.addAttribute("companyInfo", companyDAO.getCompanyInfo());
			
			return "front/contact-page";
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		message.setSeen(false);
		message.setDate(LocalDateTime.now().format(formatter));
		
		messageDAO.saveMessage(message);
		
		return "redirect:/contact?success=true";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
