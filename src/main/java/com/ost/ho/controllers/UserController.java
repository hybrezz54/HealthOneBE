package com.ost.ho.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ost.ho.config.daos.UserDAO;
import com.ost.ho.pojo.User;

@RestController
public class UserController {
	
	@Autowired
	UserDAO userDAO; 
	
	@RequestMapping(value="user", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addUser(@RequestBody User user) {
		ResponseEntity<?> entity = null;
		//<Drug> drugList = null;
		try {
			userDAO.addUser(user);
			entity = new ResponseEntity<User>(user, HttpStatus.OK);
			System.out.println(entity);
		}catch(Exception ex) {
			System.out.println(ex);
			entity = new ResponseEntity<String>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		
		//return new ResponseEntity<List<Drug>>(drugList, HttpStatus.OK);
		return entity;
	}
	
	@RequestMapping(value="authenticate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> authenticateUser(@RequestBody User user) {
		ResponseEntity<?> entity = null;
		//<Drug> drugList = null;
		try {
			
			User authenticateUser = userDAO.authenticate(user);
			boolean isValidUser= false;
			if(authenticateUser.getEmail().equalsIgnoreCase(user.getEmail())) {
				isValidUser = true;
			}
			boolean isValidPass= false;
			if(authenticateUser.getPassword().equals(user.getPassword()) && isValidUser) {
				isValidPass = true;
			}
			if(isValidUser && isValidPass) {
				entity = new ResponseEntity<User>(authenticateUser, HttpStatus.OK);
			} else {
				entity = new ResponseEntity<String>("User is not Authenticated", HttpStatus.UNAUTHORIZED);
			}
			System.out.println(entity);
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
		
		
		//return new ResponseEntity<List<Drug>>(drugList, HttpStatus.OK);
		return entity;
	}
}
