/**
 * 
 */
package com.mpandey.smart.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mpandey.smart.app.objects.User;
import com.mpandey.smart.app.service.UserService;

/**
 * @author Madhav Pandey
 * @date Sep 1, 2017
 */

@RestController
@RequestMapping("/admin")
public class AdminController
{
	
	@Autowired
	private UserService userService;
	
	/*@Autowired
	private ClassificationServices classificationServices;
	*/
	
	@RequestMapping("/hello")
	public String sayHi(){
		return "Hi";
	}
	
	@RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@RequestMapping(method =RequestMethod.POST, value="/registration")
	public void addUser(@RequestBody User user){
		this.userService.saveUser(user);
	}
	
	@RequestMapping(method =RequestMethod.GET, value="/getUsers")
	public List<User> getUsers(){
		return this.userService.getUsers();
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/quickSignin")
	public void quickSingin(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = this.userService.findUserByEmail(auth.getName());
		this.userService.authenticateUser(user);
	}
	
	
	
	/*@RequestMapping(method =RequestMethod.GET, value="/classifyTickets")
	public void buildClassificationModel(){
		this.classificationServices.buildClassificationModel();
	}
	
	@RequestMapping(method =RequestMethod.POST, value="/classifyTickets")
	public void getClassifiedCategory(@RequestBody String description){
		this.classificationServices.getClassifiedCategory(description);
	}*/
}
