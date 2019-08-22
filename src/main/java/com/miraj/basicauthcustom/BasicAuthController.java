package com.miraj.basicauthcustom;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan(basePackages = "com.miraj.basicauthcustom")
@ComponentScan(basePackages = "com.miraj.configs")
public class BasicAuthController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseEntity<OurResponse> getUser() {
		
		long start = System.currentTimeMillis();
    	logger.info("Start Method user ");
		
		Random random = new Random();
		int x =  random.nextInt(10);
	    
		if( x > 5) {
		   
		    User responseUser1 = new User("user1", "address1", 12);
		    User responseUser2 = new User("user2", "address2", 20);
		    User responseUser3 = new User("user3", "address3", 11);
		    
		    List<User> userList = new ArrayList<User>();
		    userList.add(responseUser1);
		    userList.add(responseUser2);
		    userList.add(responseUser3);
		    
		    OurResponse response = new OurResponse();
		    response.setUserList(userList);
		    response.setMessage("Success");
			response.setStatus("200");
			
			Duration duration = Duration.ofMillis(System.currentTimeMillis() - start);
	    	logger.info("End Method user | duration={}:{}:{}:{}", duration.toHours(), duration.toMinutes(), duration.getSeconds(), duration.toMillis());
	    	
	    	return new ResponseEntity<OurResponse>(response, HttpStatus.OK);
	   
		}else {
		   
			OurResponse response = new OurResponse();
			response.setMessage("error message");
			response.setStatus("500");
			
			Duration duration = Duration.ofMillis(System.currentTimeMillis() - start);
	    	logger.info("End Method user | duration={}:{}:{}:{}", duration.toHours(), duration.toMinutes(), duration.getSeconds(), duration.toMillis());
			
	    	return new ResponseEntity<OurResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		   
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ResponseEntity<OurResponse> getAdmin() {
		
		Random random = new Random();
		int x =  random.nextInt(10);
	    
		if( x > 5) {
		   
		    User responseUser1 = new User("admin1", "address1", 12);
		    User responseUser2 = new User("admin2", "address2", 20);
		    User responseUser3 = new User("admin3", "address3", 11);
		    
		    List<User> userList = new ArrayList<User>();
		    userList.add(responseUser1);
		    userList.add(responseUser2);
		    userList.add(responseUser3);
		    
		    OurResponse response = new OurResponse();
		    response.setUserList(userList);
		    response.setMessage("Success");
			response.setStatus("200");
	    	return new ResponseEntity<OurResponse>(response, HttpStatus.OK);
	   
		}else {
		   
			OurResponse response = new OurResponse();
			response.setMessage("error message");
			response.setStatus("500");
			return new ResponseEntity<OurResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		   
	}

}
