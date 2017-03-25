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

import rebel.web.dao.Queanforumdao;
import rebel.web.model.Blog;
import rebel.web.model.Queanforum;

//-------------------------create user--------------//
@RestController
public class QueanforumController {
	@Autowired
Queanforumdao forumdao;
	
	@RequestMapping(value = "/myforum", method = RequestMethod.POST )
	public ResponseEntity<Void> addForumData(@RequestBody Queanforum  forum , UriComponentsBuilder ucBuilder)
	 { 
		System.out.println("forum title="+ forum.getQuestTitle());
		forumdao.addQuestion(forum);
		@SuppressWarnings("unused")
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	 }
////////get gorum////
	@RequestMapping(value = "/myforum", method = RequestMethod.GET)
	    public ResponseEntity<List<Queanforum>>listBlogs()
	    {
		System.out.println("am in retrive forum");
	 List<Queanforum> forum = forumdao.viewQuestions();
	 System.out.println(forum.toString());
	 
	 if(forum.isEmpty())
	 {
	 return new ResponseEntity<List<Queanforum>>(HttpStatus.NO_CONTENT);
}
	 return new ResponseEntity<List<Queanforum>>(forum, HttpStatus.OK);
	    }
	
	
	// delete forum//
	
		 @RequestMapping(value="/myforum/{QUESTID}", headers="Accept=applicaton/json",method=RequestMethod.DELETE)
		 public void deleteUser (@PathVariable ("QUESTID") int qid)
		 {
			 System.out.println("I am in blog rest delete controller");
			 forumdao.deleteQuestion(qid);
			}
                      //update//
		 @RequestMapping(value="/updateforum", method=RequestMethod.PUT)
		 public void updateQueanforum(@RequestBody Queanforum forum)
		 {
			 System.out.println("inside update forum");
			 forumdao.updateQuestion(forum);
		 }
	    }
