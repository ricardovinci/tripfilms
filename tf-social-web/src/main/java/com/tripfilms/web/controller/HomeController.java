package com.tripfilms.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@Autowired
	private Facebook mFacebook;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model pModel) {	
		String oEmail = mFacebook.userOperations().getUserProfile().getEmail();
		List<Reference> oFriends = mFacebook.friendOperations().getFriends();
		pModel.addAttribute("friends", oFriends);
		pModel.addAttribute("email", oEmail);
		return "home";
	}

}
