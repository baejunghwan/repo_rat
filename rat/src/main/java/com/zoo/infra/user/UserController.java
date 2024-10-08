package com.zoo.infra.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "/xdm/v1/infra/user/user404")
	public String user404() {
		return "/xdm/v1/infra/user/user404"; 
	}

	@RequestMapping(value = "/xdm/v1/infra/user/userAbout")
	public String userXdmForm() {
		return "/xdm/v1/infra/user/userAbout"; 
	}
	
	@RequestMapping(value = "/xdm/v1/infra/user/userAccount")
	public String userAccount() {
		return "/xdm/v1/infra/user/userAccount"; 
	}
	
	@RequestMapping(value = "/xdm/v1/infra/user/userIndex")
	public String userIndex() {
		return "/xdm/v1/infra/user/userIndex"; 
	}
	
}
