package com.pvr.PVRfinser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pvr.PVRfinser.Service.EmailService;
import com.pvr.PVRfinser.entity.User;
import com.pvr.PVRfinser.repository.ContactRepository;


@RestController
@RequestMapping("/cont")
@CrossOrigin("http://localhost:3000")
public class ContactController {
	
	@Autowired
	ContactRepository contrepo;
	
	@Autowired
	EmailService emailservice;
	
	@GetMapping("/user/search/{id}")
    public User getUserInfo(@PathVariable int id) {
        // Try to find the user with the given ID
        // If found, return the user; otherwise, handle the case when the user is not found
        return contrepo.findById(id);
        
    }
		
	@PostMapping("/user/add")
	public ResponseEntity<String> addNewUser(@RequestBody User u) {
	    try {
	        contrepo.save(u);

String adminEmail = "kapil2000kadu@gmail.com";
	        String subject = "New Form Submission";
	        String messageText = "A new form has been submitted:\n\n" +
	                             "First Name: " + u.getFirstname() + "\n" +
	                             "Last Name: " + u.getLastname() + "\n"+
	                             "Email: "+u.getEmail()+"\n"+
	                             "Phone: "+u.getPhone()+"\n"+
	                             "Message: "+u.getMessage()+"\n";
	                             // Include other form fields

	        emailservice.sendEmail(adminEmail, subject, messageText);
	       
	        return ResponseEntity.ok("User added successfully");
	    } catch (Exception e) {
	        e.printStackTrace(); // Log the exception for debugging purposes
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add user");
	    }
	}


}
