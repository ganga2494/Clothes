package rebel.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import rebel.web.dao.JobsDao;
import rebel.web.model.Queanforum;
import rebel.web.model.Jobs;

@RestController
public class JobsRestController {
	@Autowired
	JobsDao jobsdao;
	
	  //-------------------create Users--------------------------------------------------------
	 @RequestMapping(value = "/myjob", method = RequestMethod.POST)
	    public ResponseEntity<Void> addForumData(@RequestBody Jobs jobs,    UriComponentsBuilder ucBuilder) 
	 {
	        System.out.println("job company " + jobs.getCompany());
	  
	        
	  
	        jobsdao.addJob(jobs);
	  
	        HttpHeaders headers = new HttpHeaders();
	      
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }

	 @RequestMapping(value = "/myjobs/", method = RequestMethod.GET)
	    public ResponseEntity<List<Jobs>> listForums()
	    {
	    	System.out.println("i am in rest controller");
	        List<Jobs> users = jobsdao.viewJobs();
	        System.out.println(users.toString());
	        
	        if(users.isEmpty()){
	            return new ResponseEntity<List<Jobs>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<Jobs>>(users, HttpStatus.OK);
	    }
	 //------------------- Delete a User --------------------------------------------------------
	    
	    @RequestMapping(value = "/myjobs/{id}",headers="Accept=application/json", method = RequestMethod.DELETE)
	    public void deleteUser(@PathVariable("id") int id) {
	    	System.out.println("iam in blog rest delete controller");
	        
	  
	        jobsdao.deleteJob(id);
	       
	    }
	    
 //------------------- Update a User --------------------------------------------------------
	    
	    @RequestMapping(value = "/updatejobs",headers="Accept=application/json", method = RequestMethod.PUT)
	    public void updateForum(@RequestBody Jobs job) {
	    	System.out.println("inside jobs ");
	        
	  
	        jobsdao.updateJob(job);
	       
	    }
}