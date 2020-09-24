package beautyhair.main;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import beautyhair.main.entity.ChangePassword;
import beautyhair.main.dao.BlogPostDAO;
import beautyhair.main.dao.CategoryDAO;
import beautyhair.main.dao.CompanyDAO;
import beautyhair.main.dao.MessageDAO;
import beautyhair.main.dao.PartnerDAO;
import beautyhair.main.dao.PictureDAO;
import beautyhair.main.dao.RoleDAO;
import beautyhair.main.dao.UserDAO;
import beautyhair.main.entity.Company;
import beautyhair.main.entity.Partner;
import beautyhair.main.entity.Picture;
import beautyhair.main.entity.User;
import beautyhair.main.entity.BlogPost;
import beautyhair.main.entity.Category;

@Controller
@RequestMapping("/administration")
public class AdministrationController {

	@Autowired
	private CompanyDAO companyDAO;
	
	@Autowired
	private UserDAO userDAO;

	@Autowired
	private RoleDAO roleDAO;

	@Autowired
	private MessageDAO messageDAO;

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private BlogPostDAO blogPostDAO;
	
	@Autowired
	private PictureDAO pictureDAO;
	
	@Autowired
	private PartnerDAO partnerDAO;
	
	
	
	
	
	// FRONT REDIRECT
	@RequestMapping("/front-index")
	public String getIndexPageRedirect() {
		
		return "redirect:/index";
	}
	
	
	
	// KOMPANIJA
	
	@RequestMapping("/company-info")
	public String getCompanyInfoPage(Model model) {
		model.addAttribute("companyInfo", companyDAO.getCompanyInfo());
		model.addAttribute("unreadCounter", messageDAO.getNotSeenMessages().size());
		
		return "company-info-page";
	}
	
	@RequestMapping("/company-info-update")
	public String updateCompanyInfo(Model model, Principal principal) {
		model.addAttribute("companyInfo", companyDAO.getCompanyInfo());
		model.addAttribute("company", companyDAO.getCompanyInfo());
		model.addAttribute("principal", userDAO.getPrincipal(principal));
		model.addAttribute("unreadCounter", messageDAO.getNotSeenMessages().size());
		
		return "company-info-form-page";
	}
	
	@RequestMapping("/company-info-save")
	public String saveCompanyInfo(Model model,@Valid @ModelAttribute Company company, BindingResult result, Principal principal) {
		if(result.hasErrors()) {
			model.addAttribute("companyInfo", companyDAO.getCompanyInfo());
			model.addAttribute("principal", userDAO.getPrincipal(principal));
			model.addAttribute("unreadCounter", messageDAO.getNotSeenMessages().size());
			
			return "company-info-form-page";
		}
		companyDAO.updateCompanyInfo(company);
		
		return "redirect:/administration/company-info";
	}
	
	
	
	// KORISNICI
	
	@RequestMapping("/user-list")
	public String getUserListPage(Model model, Principal principal) {
		model.addAttribute("userList", userDAO.getUserList());
		model.addAttribute("companyInfo", companyDAO.getCompanyInfo());
		model.addAttribute("principal", userDAO.getPrincipal(principal));
		model.addAttribute("unreadCounter", messageDAO.getNotSeenMessages().size());
		
		return "user-list-page";
	}
	
	@RequestMapping("/user-add")
	public String addUser(Model model, Principal principal) {
		model.addAttribute("user", new User());
		model.addAttribute("roles", roleDAO.getRolesList());
		model.addAttribute("companyInfo", companyDAO.getCompanyInfo());
		model.addAttribute("principal", userDAO.getPrincipal(principal));
		model.addAttribute("unreadCounter", messageDAO.getNotSeenMessages().size());
		
		return "user-add-page";
	}
	
	@RequestMapping("/user-save")
	public String saveUser(@Valid @ModelAttribute User user, BindingResult result, Model model, Principal principal) {
		if(result.hasErrors()) {
			model.addAttribute("companyInfo", companyDAO.getCompanyInfo());
			model.addAttribute("roles", roleDAO.getRolesList());
			model.addAttribute("principal", userDAO.getPrincipal(principal));
			model.addAttribute("unreadCounter", messageDAO.getNotSeenMessages().size());
			
			return "user-add-page";
		}
		user.setDateJoined(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
		user.setEnabled(true);
		
		String passwordEncode = new BCryptPasswordEncoder().encode(user.getPassword());
		user.setPassword("{bcrypt}" + passwordEncode);
		
		userDAO.saveOrUpdateUser(user);
		
		return "redirect:/administration/user-list";
	}
	
	@RequestMapping("/user-status-update")
	public String updateUserStatus(@RequestParam String username) {
		userDAO.enableDisableUser(username);
		
		return "redirect:/administration/user-list";
	}
	
	@RequestMapping("/user-authorities-update")
	public String userAuthoritiesUpdate(@RequestParam String username, Model model, Principal principal) {
		model.addAttribute("user", userDAO.getUserByUsername(username));
		model.addAttribute("roles", roleDAO.getRolesList());
		model.addAttribute("companyInfo", companyDAO.getCompanyInfo());
		model.addAttribute("principal", userDAO.getPrincipal(principal));
		model.addAttribute("unreadCounter", messageDAO.getNotSeenMessages().size());
		
		return "user-authorities-edit-page";
	}

	@RequestMapping("/user-authorities-save")
	public String saveNewUserAuthorities(@ModelAttribute User user, Model model) {
		userDAO.saveOrUpdateUser(user);
		
		return "redirect:/administration/user-list";
	}
	
	@RequestMapping("/user-delete")
	public String deleteUser(@RequestParam String username) {
		userDAO.deleteUser(username);
		
		return "redirect:/administration/user-list";
	}
	
	@RequestMapping("/user-edit-profile")
	public String editUserProfile(Principal principal, Model model) {
		model.addAttribute("user", userDAO.getUserByUsername(principal.getName()));
		model.addAttribute("principal", userDAO.getPrincipal(principal));
		model.addAttribute("companyInfo", companyDAO.getCompanyInfo());
		model.addAttribute("unreadCounter", messageDAO.getNotSeenMessages().size());
		
		return "user-profile-page";
	}
	
	@RequestMapping("/user-update-profile")
	public String saveProfileChanges(@Valid @ModelAttribute User user, BindingResult result, Model model, Principal principal) {
		if(result.hasErrors()) {
			model.addAttribute("companyInfo", companyDAO.getCompanyInfo());
			model.addAttribute("principal", userDAO.getPrincipal(principal));
			model.addAttribute("unreadCounter", messageDAO.getNotSeenMessages().size());
			
			return "user-profile-page";
		}
		userDAO.saveOrUpdateUser(user);
		
		return "redirect:/administration/user-edit-profile";
	}
	
	@RequestMapping("/user-image-delete")
	public String deleteImageForUser(Principal principal) {
		User user = userDAO.getPrincipal(principal);
		
		user.setImage("");
		userDAO.saveOrUpdateUser(user);
		
		return "redirect:/administration/user-edit-profile";
	}
	
	@RequestMapping("/user-password-change")
	public String changeUserPassword(Model model, Principal principal) {
		model.addAttribute("changePassword", new ChangePassword());
		model.addAttribute("companyInfo", companyDAO.getCompanyInfo());
		model.addAttribute("principal", userDAO.getPrincipal(principal));
		
		return "user-password-change-page";
	}
	
	
	@RequestMapping("/user-password-change-action")
	public String changeUserPasswordAction(@Valid @ModelAttribute ChangePassword changePassword, BindingResult result, Principal principal, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("companyInfo", companyDAO.getCompanyInfo());
			
			return "user-password-change-page";
		}
		if(changePassword.getNewPassword().equals(changePassword.getConfirmPassword())) {
			User user = userDAO.getPrincipal(principal);
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			
			if(encoder.matches(changePassword.getOldPassword(), user.getPassword().replace("{bcrypt}", ""))) {
				user.setPassword("{bcrypt}" + encoder.encode(changePassword.getNewPassword()));
				userDAO.saveOrUpdateUser(user);
			}
			// Not correct old password
			else {
				model.addAttribute("changePassword", new ChangePassword());
				model.addAttribute("companyInfo", companyDAO.getCompanyInfo());
				model.addAttribute("passwordError", new String("The old password you have entered is incorrect!"));
				
				return "user-password-change-page";
			}
		}
		// New password does not match confirm password
		else {
			model.addAttribute("changePassword", new ChangePassword());
			model.addAttribute("companyInfo", companyDAO.getCompanyInfo());
			model.addAttribute("passwordError", new String("New password does't match the confirm password!"));
			
			return "user-password-change-page";
		}
		
		return "redirect:/administration/user-edit-profile";
	}
	
	
	// PORUKE
	
	@RequestMapping("/message-list")
	public String getMessageList(Model model, @RequestParam(defaultValue = "-1") String pageId, Principal principal) {
		if(pageId.equalsIgnoreCase("0")) {
			model.addAttribute("messageList", messageDAO.getNotSeenMessages());
			model.addAttribute("pageId", 0);
		}
		else if(pageId.equalsIgnoreCase("1")) {
			model.addAttribute("messageList", messageDAO.getSeenMessages());
			model.addAttribute("pageId", 1);
		}
		else {
			model.addAttribute("messageList", messageDAO.getAllMessages());
			model.addAttribute("pageId", -1);
		}
		
		model.addAttribute("unreadCounter", messageDAO.getNotSeenMessages().size());
		model.addAttribute("companyInfo", companyDAO.getCompanyInfo());
		model.addAttribute("principal", userDAO.getPrincipal(principal));
		
		return "message-list-page";
	}
	
	
	@RequestMapping("/message-seen-update")
	public String changeMessageStatus(Model model, @RequestParam int id) {
		messageDAO.updateStatus(id);
		
		return "redirect:/administration/message-list";
	}
	
	
	@RequestMapping("/message-delete")
	public String deleteMessage(Model model, @RequestParam int id) {
		messageDAO.deleteMessage(id);
		
		return "redirect:/administration/message-list?pageId=-1";
	}
	
	
	// KATEGORIJA
	

	@RequestMapping("/category-list")
	public String getCategoryList(Model model, Principal principal) {
		model.addAttribute("companyInfo", companyDAO.getCompanyInfo());
		model.addAttribute("categoryList", categoryDAO.getCategoryList());
		model.addAttribute("unreadCounter", messageDAO.getNotSeenMessages().size());
		model.addAttribute("principal", userDAO.getPrincipal(principal));

		return "category-list-page";
	}

	@RequestMapping("category-form")
	public String addCategory(Model model, Principal principal) {
		Category category = new Category();
		model.addAttribute("category", category);
		model.addAttribute("unreadCounter", messageDAO.getNotSeenMessages().size());
		model.addAttribute("principal", userDAO.getPrincipal(principal));
		model.addAttribute("companyInfo", companyDAO.getCompanyInfo());

		return "category-form-page";
	}

	@RequestMapping("/category-save")
	public String saveCategory(@Valid @ModelAttribute Category category, BindingResult result, Model model, Principal principal) {
		if(result.hasErrors()) {
			model.addAttribute("unreadCounter", messageDAO.getNotSeenMessages().size());
			model.addAttribute("principal", userDAO.getPrincipal(principal));
			model.addAttribute("companyInfo", companyDAO.getCompanyInfo());
			
			return "category-form-page";
		}
		
		if(category.getDate() == null || category.getDate() == "") {
			category.setDate(LocalDate.now().toString());
		}
		categoryDAO.saveCategory(category);

		return "redirect:/administration/category-list";
	}

	@RequestMapping("/category-update")
	public String updateCategory(@RequestParam int id, Model model, Principal principal) {
		model.addAttribute("category", categoryDAO.getCategory(id));
		model.addAttribute("principal", userDAO.getPrincipal(principal));
		model.addAttribute("companyInfo", companyDAO.getCompanyInfo());
		model.addAttribute("unreadCounter", messageDAO.getNotSeenMessages().size());

		return "category-form-page";
	}

	@RequestMapping("/category-delete")
	public String deleteCategory(@RequestParam int id) {
		categoryDAO.deleteCategory(id);

		return "redirect:/administration/category-list";
	}

	
	// BLOGOVI
	

	@RequestMapping({"/blog-post-list", "/"})
	public String getBlogPostList(@RequestParam(defaultValue = "0") String pageId, Model model, Principal principal) {
		if(pageId.equalsIgnoreCase("0")) {
			model.addAttribute("blogPostList", blogPostDAO.getMyBlogPostList(principal));
			model.addAttribute("pageId", 0);
		}
		else if(pageId.equalsIgnoreCase("1")){
			model.addAttribute("blogPostList", blogPostDAO.getBlogPostList());
			model.addAttribute("pageId", 1);
		}
		
		model.addAttribute("unreadCounter", messageDAO.getNotSeenMessages().size());
		model.addAttribute("companyInfo", companyDAO.getCompanyInfo());
		model.addAttribute("principal", userDAO.getPrincipal(principal));

		return "blog-post-list-page";
	}


	@RequestMapping("/blog-post-form")
	public String createBlogPost(Model model, Principal principal) {
		BlogPost bp = new BlogPost();

		model.addAttribute("blogPost", bp);
		model.addAttribute("categoryList", categoryDAO.getCategoryList());
		model.addAttribute("unreadCounter", messageDAO.getNotSeenMessages().size());
		model.addAttribute("principal", userDAO.getPrincipal(principal));
		model.addAttribute("companyInfo", companyDAO.getCompanyInfo());

		return "blog-post-form-page";
	}

	@RequestMapping("/blog-post-update")
	public String updateBlogPost(@RequestParam int id, Model model, Principal principal) {

		model.addAttribute("blogPost", blogPostDAO.getBlogPost(id));
		model.addAttribute("unreadCounter", messageDAO.getNotSeenMessages().size());
		model.addAttribute("categoryList", categoryDAO.getCategoryList());
		model.addAttribute("principal", userDAO.getPrincipal(principal));
		model.addAttribute("companyInfo", companyDAO.getCompanyInfo());

		return "blog-post-form-page";
	}

	@RequestMapping("/blog-post-important-update")
	public String updateImportantBlogPost(@RequestParam int id) {
		blogPostDAO.updateImportantBlogPost(id);

		return "redirect:/administration/blog-post-list?pageId=1";
	}

	@RequestMapping("/blog-post-save")
	public String saveBlogPost(@Valid @ModelAttribute BlogPost blogPost, BindingResult result, Principal principal, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("unreadCounter", messageDAO.getNotSeenMessages().size());
			model.addAttribute("principal", userDAO.getPrincipal(principal));
			model.addAttribute("companyInfo", companyDAO.getCompanyInfo());
			model.addAttribute("categoryList", categoryDAO.getCategoryList());
			
			return "blog-post-form-page";
		}
		if(blogPost.getDate() == null || blogPost.getDate() == "") {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			blogPost.setDate(LocalDateTime.now().format(formatter));
		}

		// Setujemo autora
		User author = userDAO.getUserByUsername(principal.getName());
		blogPost.setAuthor(author);

		// TODO Proveriti da li radi
		// Povecavamo broj koriscenja izabrane kategorije za +1
		blogPost.getCategory().setTimesUsed(blogPost.getCategory().getTimesUsed() + 1);

		blogPostDAO.saveBlogPost(blogPost);

		return "redirect:/administration/blog-post-list";
	}

	@RequestMapping("/blog-post-delete")
	public String deleteBlogPost(@RequestParam int id, @RequestParam int pageId) {
		blogPostDAO.deleteBlogPost(id);

		if (pageId == 1) {
			return "redirect:/administration/blog-post-list?pageId=1";
		} else {
			return "redirect:/administration/blog-post-list";
		}

	}

	
	// SLIKA
	
	@RequestMapping("/picture-list")
	public String getPictureListPage(Model model, Principal principal) {
		model.addAttribute("pictureList", pictureDAO.getPictureList());
		model.addAttribute("unreadCounter", messageDAO.getNotSeenMessages().size());
		model.addAttribute("principal", userDAO.getPrincipal(principal));
		model.addAttribute("companyInfo", companyDAO.getCompanyInfo());
		
		
		return "picture-list-page";
	}
	

	@RequestMapping("picture-form")
	public String addPicture(Model model, Principal principal) {
		Picture picture = new Picture();
		model.addAttribute("picture", picture);
		model.addAttribute("unreadCounter", messageDAO.getNotSeenMessages().size());
		model.addAttribute("principal", userDAO.getPrincipal(principal));
		model.addAttribute("companyInfo", companyDAO.getCompanyInfo());

		return "picture-form-page";
	}

	@RequestMapping("/picture-save")
	public String savePicture(@Valid @ModelAttribute Picture picture, BindingResult result, Model model, Principal principal) {
		if(result.hasErrors()) {
			model.addAttribute("unreadCounter", messageDAO.getNotSeenMessages().size());
			model.addAttribute("principal", userDAO.getPrincipal(principal));
			model.addAttribute("companyInfo", companyDAO.getCompanyInfo());
			return "picture-form-page";
		}
		
		if(picture.getDate() == null || picture.getDate() == "") {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			picture.setDate(LocalDateTime.now().format(formatter));
		}
		pictureDAO.saveOrUpdatePicture(picture);

		return "redirect:/administration/picture-list";
	}

	@RequestMapping("/picture-update")
	public String updatePicture(@RequestParam int id, Principal principal, Model model) {
		model.addAttribute("picture", pictureDAO.getPicture(id));
		model.addAttribute("principal", userDAO.getPrincipal(principal));
		model.addAttribute("companyInfo", companyDAO.getCompanyInfo());
		model.addAttribute("unreadCounter", messageDAO.getNotSeenMessages().size());

		return "picture-form-page";
	}

	@RequestMapping("/picture-delete")
	public String deletePicture(@RequestParam int id) {
		pictureDAO.deletePicture(id);

		return "redirect:/administration/picture-list";
	}
	
	
	// PARTNERI
	
	
	@RequestMapping("/partner-list")
	public String getPartnerListPage(Model model, Principal principal) {
		model.addAttribute("partnerList", partnerDAO.getPartnerList());
		model.addAttribute("principal", userDAO.getPrincipal(principal));
		model.addAttribute("companyInfo", companyDAO.getCompanyInfo());
		model.addAttribute("unreadCounter", messageDAO.getNotSeenMessages().size());
		
		
		return "partner-list-page";
	}
	
	
	@RequestMapping("/partner-form")
	public String addPartner(Model model, Principal principal) {
		model.addAttribute("partner", new Partner());
		model.addAttribute("principal", userDAO.getPrincipal(principal));
		model.addAttribute("companyInfo", companyDAO.getCompanyInfo());
		model.addAttribute("unreadCounter", messageDAO.getNotSeenMessages().size());
		
		return "partner-form-page";
	}
	
	
	
	@RequestMapping("/partner-save")
	public String savePartner(Model model, Principal principal, @Valid @ModelAttribute Partner partner, BindingResult result) {
		if(result.hasErrors()) {
			model.addAttribute("principal", userDAO.getPrincipal(principal));
			model.addAttribute("companyInfo", companyDAO.getCompanyInfo());
			model.addAttribute("unreadCounter", messageDAO.getNotSeenMessages().size());
			
			return "partner-form-page";
		}
		partnerDAO.saveOrUpdatePartner(partner);
		
		return "redirect:/administration/partner-list";
	}
	
	
	@RequestMapping("/partner-update")
	public String updatePartner(Model model, Principal principal, @RequestParam int id) {
		model.addAttribute("partner", partnerDAO.getPartner(id));
		model.addAttribute("principal", userDAO.getPrincipal(principal));
		model.addAttribute("companyInfo", companyDAO.getCompanyInfo());
		model.addAttribute("unreadCounter", messageDAO.getNotSeenMessages().size());
		
		return "partner-form-page";
	}
	
	
	@RequestMapping("/partner-delete")
	public String deletePartner(Model model, @RequestParam int id) {
		partnerDAO.deletePartner(id);
		
		return "redirect:/administration/partner-list";
	}
	
	
	
	
	
	
	
}
