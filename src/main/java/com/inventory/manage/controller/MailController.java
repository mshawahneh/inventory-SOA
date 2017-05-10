/**
 * 
 */
package com.inventory.manage.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.manage.model.Item;
import com.inventory.manage.model.Mail;
import com.inventory.manage.service.item.ItemsService;
import com.inventory.manage.service.mail.MailService;

/**
 * @author Rami
 *
 */
@RestController
@RequestMapping("/mail")
public class MailController {
	
	@Autowired
	private MailService mailService;
	
	@RequestMapping(value = "/create" ,
			method = RequestMethod.POST,  
			consumes = "application/json",
            produces = "application/json")
	public ResponseEntity<Mail> sendEmail(@RequestBody  Mail mail, 
			HttpServletRequest request) {
		
		Item itemRes = mailService.sendEmail(mail);
		
		return new ResponseEntity<Item>(itemRes, HttpStatus.OK);
	}

}
