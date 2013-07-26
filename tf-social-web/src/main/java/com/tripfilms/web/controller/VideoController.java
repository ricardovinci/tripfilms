package com.tripfilms.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VideoController {
	@RequestMapping(value = "/video-page")
	public ModelAndView preferencesFormPage() {
		return new ModelAndView("video-form");
	}

}
