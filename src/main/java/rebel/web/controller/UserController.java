package rebel.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpSession;

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

import rebel.web.dao.UserDetailsDao;
import rebel.web.model.UserDetails;

@RestController
public class UserController {
	@Autowired
	UserDetailsDao userDAO;
	
	
	//get user
	@RequestMapping(value="/candidate", method=RequestMethod.GET)
	public ResponseEntity <List<UserDetails>> displayUsers(){
		List <UserDetails> users = userDAO.getUsers();
		System.out.println(users);
		if(users.isEmpty())
			return new ResponseEntity <List<UserDetails>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity <List<UserDetails>>(users,HttpStatus.ACCEPTED);		
	}
	
	//create user
	 @RequestMapping(value = "/candidatep", method = RequestMethod.POST)
	    public ResponseEntity<Void> addUserData(@RequestBody UserDetails reg,    UriComponentsBuilder ucBuilder) {
	        System.out.println("Creating User " + reg.getFullname());
	  
	        
	  
	        userDAO.addUser(reg);
	  
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(reg.getUserid()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }


		@RequestMapping(value="/logincheck", method=RequestMethod.POST)
		public ResponseEntity <?> logincheck(@RequestBody UserDetails userdetails,HttpSession session){
			System.out.println("Entering UserController : Login()");
			String userid=userdetails.getUserid();
			UserDetails validuser = userDAO.logincheck(userdetails);
			System.out.println("\n" + userdetails.getUserid());
			
			if(validuser==null){
				System.out.println("validuser is null");
				Error error = new Error("User does not exists");
				return new ResponseEntity<Error> (error,HttpStatus.UNAUTHORIZED);// 401
			}
			else{
				session.setAttribute("user", validuser);
				validuser.setIsonline(true);
				userDAO.updateUser1(validuser); // - to be uncommented after 
				System.out.print("\nlogincheck - " + validuser.getRole()); 
				System.out.println("valid user is available");
				
				
				  }
				
				
				return new  ResponseEntity<UserDetails> (validuser, HttpStatus.OK);
			}		
		
	
		@RequestMapping(value="/logout",method=RequestMethod.PUT)
		public ResponseEntity<?> logout(HttpSession session){
			UserDetails ud = (UserDetails)session.getAttribute("user");
			if(ud!=null){
				ud.setIsonline(false);
				userDAO.updateUser1(ud);
				try{
	                //change according to your workspace path and project name
					String path="F:/collab2/src/main/webapp/resources/images/users/"+ud.getUserid()+".jpg";
					File file=new File(path);
					System.out.println(file.delete());
			
			}catch(Exception e){
				e.printStackTrace();
			}
			}
			session.removeAttribute("user");		
			session.invalidate();
			return new  ResponseEntity<Void> (HttpStatus.OK);		
			
		}
		
		@RequestMapping(value="/userUpdate",method=RequestMethod.PUT)
		public ResponseEntity<?> userUpdate1(@RequestBody UserDetails userdetails,HttpSession session){
			userdetails.setIsonline(true);
			
			return new  ResponseEntity<Void> (HttpStatus.OK);		
			
		}

		@RequestMapping(value="/getUserDetails",method=RequestMethod.GET)
		public ResponseEntity<?> getUserDetails(HttpSession session){
			UserDetails ud = (UserDetails)session.getAttribute("user");
			if(ud!=null){
				List <UserDetails> data = userDAO.getUsers();
				return new ResponseEntity<List<UserDetails>> (data,HttpStatus.OK);// 401
			}
			else{
				Error error = new Error("Login required before displaying user details");
				return new ResponseEntity<Error> (error,HttpStatus.UNAUTHORIZED);// 401
			}	
			
		}
		
	
}
