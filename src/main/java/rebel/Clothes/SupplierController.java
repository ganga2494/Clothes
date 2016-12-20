package rebel.Clothes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import rebel.ClothesBack.dao.SupplierDao;
import rebel.ClothesBack.model.Supplier;


@Controller
public class SupplierController 
{
	
	@Autowired
	SupplierDao supDAO;
	
	@RequestMapping(value="/SupplierView" , method=RequestMethod.GET )
	public ModelAndView ViewSupplier()
	{
		
		String supjsonlist=supDAO.listSupplier();
		ModelAndView mv = new ModelAndView("AdminSupplier","Supplier",new Supplier());
		int id=supDAO.sortId();
		mv.addObject("data",supjsonlist);
		mv.addObject("check", true);
		mv.addObject("supid",id);
		return mv;
		
	}
	
	@RequestMapping(value="/SupplierView" , method=RequestMethod.POST )
	public ModelAndView insertSupplier(Supplier sup)
	{
		supDAO.saveSupplier(sup);
		String supjsonlist=supDAO.listSupplier();
		ModelAndView mv = new ModelAndView("AdminSupplier","Supplier",new Supplier());
		mv.addObject("data",supjsonlist);
		mv.addObject("check",true);
		int id=supDAO.sortId();
		mv.addObject("supid",id);
		return mv;
	
	}
	
	@RequestMapping(value="/delsupplier",method = RequestMethod.GET)
	public ModelAndView deleteSupplier(@RequestParam("suppId")int sid)
	{
		supDAO.deleteSupplier(sid);
		String supjsonlist=supDAO.listSupplier();
		ModelAndView m = new ModelAndView("AdminSupplier","Supplier",new Supplier());
		m.addObject("check",true);
		m.addObject("data",supjsonlist);
		int id=supDAO.sortId();
		m.addObject("supid",id);
		return m;
		
	}
	

	@RequestMapping(value="/UpdateSupplier",method=RequestMethod.GET)
	public ModelAndView updateSupplier(@RequestParam("suppId")int sid)
	{
		Supplier sup =supDAO.DispRecord(sid);
		ModelAndView m = new ModelAndView("AdminSupplier","Supplier",sup);
		m.addObject("check",false);
		return m;
	
		
	}
	@RequestMapping(value="/UpdateSupplier",method=RequestMethod.POST)
	public ModelAndView updatesupp(Supplier s)
	{

		supDAO.UpRecord(s);
		String supjsonlist=supDAO.listSupplier();
		ModelAndView m = new ModelAndView("AdminSupplier","Supplier",new Supplier());
		m.addObject("check",true);
		m.addObject("data",supjsonlist);
		int id=supDAO.sortId();
		m.addObject("supid",id);
		return m;
		
	}

	
}
