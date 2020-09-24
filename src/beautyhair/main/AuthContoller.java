package beautyhair.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import beautyhair.main.dao.CompanyDAO;

@Controller
public class AuthContoller {
	
	@Autowired
	private CompanyDAO companyDAO;


	@RequestMapping("/login")
	public String getLoginPage(Model model) {
		model.addAttribute("companyInfo", companyDAO.getCompanyInfo());
		
		return "login-page";
	}
	
}
