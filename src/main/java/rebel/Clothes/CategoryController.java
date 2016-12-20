package rebel.Clothes;

import org.springframework.stereotype.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import rebel.ClothesBack.dao.CategoryDao;
import rebel.ClothesBack.model.Category;

@Controller
public class CategoryController 
{
	
@Autowired	
CategoryDao categoryDao;


@RequestMapping(value="/categorygson")
@ResponseBody
public String CategoryGson()
{
	String  list=categoryDao.list();
	
	return list;
}


@RequestMapping(value = { "category"})
public ModelAndView CategoryPage(Model model) 
{
	model.addAttribute("category", new Category());
	model.addAttribute("categoryList", categoryDao.list());
	model.addAttribute("CategoryPageClicked", "true");
	
	String list=categoryDao.list();
 
	return new ModelAndView("AdminCategory","data",list);
}

@RequestMapping(value = { "addcategory", "editcategory/addcategory" }, method = RequestMethod.POST)
public String addCategory(@ModelAttribute("category") Category category) {
	categoryDao.saveOrUpdate(category);
	return "redirect:/category";
}
@RequestMapping("editcategory/{id}")
public String editCategory(@PathVariable("id") String id, Model model) {
	System.out.println("editCategory");
	model.addAttribute("category", this.categoryDao.get(id));
	model.addAttribute("categoryList", categoryDao.list());
	model.addAttribute("CategoryPageClicked", "true");
	model.addAttribute("EditCategory", "true");
	return "redirect:/category";
}
@RequestMapping(value = { "removecategory/{id}", "editcategory/removecategory/{id}" })
public String removeCategory(@PathVariable("id") String id, Model model) throws Exception {
	categoryDao.delete(id);
	model.addAttribute("message", "Successfully Deleted");
	return "redirect:/category";
}



}
