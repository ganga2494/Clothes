package rebel.Clothes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import rebel.ClothesBack.dao.AProductDao;
import rebel.ClothesBack.dao.CategoryDao;
import rebel.ClothesBack.dao.UserDao;
import rebel.ClothesBack.model.UserDetail;

@Controller
public class HomeController 
{
	
	@Autowired
	UserDao userdao;

	@RequestMapping("/")
	public ModelAndView Home()
	{
		return new ModelAndView("LandingPage");
	}
	
	
	@RequestMapping("/reg")
	public ModelAndView SignUp()
	{
		UserDetail userDetail=new UserDetail();
		return new ModelAndView("RegisterPage","UserDetails",userDetail);
	}
	
	@RequestMapping("/register")
	public ModelAndView Reg(@ModelAttribute("UserDetails") UserDetail user , BindingResult result)
	{
		System.out.println("i am in reg controller");
		if(result.hasErrors())
		{
		return new ModelAndView("RegisterPage");
		}
		
		userdao.saveorupdate(user);
		return new ModelAndView("RegisterPage");
	}
	
	@RequestMapping("contactme")
	public ModelAndView Contact()
	{
		return new ModelAndView("ContactUs");
	}
	
	@RequestMapping("/Admin")
	public ModelAndView AdminPage()
	{
		return new ModelAndView("AdminHomePage");
	}
	
	@Autowired
	CategoryDao catdao;
	
	@Autowired
	AProductDao apdao;
	
	@RequestMapping("/userproducts")
	public String ShowProduct(Model m)
	{
		String prod = apdao.listAdProd();
		m.addAttribute("pdata",prod);
		System.out.println("Userproductdetails");
		return "UserProductPage";
	}
	
}
