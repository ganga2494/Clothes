package rebel.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rebel.web.dao.Blogdao;
import rebel.web.dao.JobrDao;
import rebel.web.model.Jobs;
import rebel.web.model.Jobreg;
import rebel.web.model.UserDetails;

@RestController
public class JobrController {
	
	@Autowired
	JobrDao jobrdao;
	
	//-------------------Create a Blog--------------------------------------------------------
	@RequestMapping(value="/jobr", method=RequestMethod.POST)
	
    public ResponseEntity<Void> createBlog(@RequestBody Jobreg jobr,HttpSession session) {
		UserDetails currentUser =  (UserDetails)session.getAttribute("user");
		//currentUser.setUserid(session.getAttribute(arg0));
        jobr.setUser(currentUser);
        
        Jobs job=(Jobs)session.getAttribute("jobid");
        
        jobr.setJobid(job);
        jobrdao.addJobr(jobr);
  
       
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

}
