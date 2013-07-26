package com.tripfilms.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tripfilms.core.be.Preferences;
import com.tripfilms.core.be.UserConnection;
import com.tripfilms.core.dao.IPreferencesDAO;
import com.tripfilms.core.dao.IUserConnectionDAO;

@Controller
public class PreferencesController {
	
	@Autowired 
	private IPreferencesDAO mPreferencesDao;
	
	@Autowired
	private IUserConnectionDAO mUserConnectionDAO;
	
	@Autowired
	private Facebook mFacebook;

	@RequestMapping(value = "/preferences-page")
	public ModelAndView preferencesFormPage() {
		
		UserConnection oUserConnection = mUserConnectionDAO.findBymUserId( mFacebook.userOperations().getUserProfile().getId());
		Preferences oPreferences = mPreferencesDao.findByUserConnection(oUserConnection);
		
		if(oPreferences==null){oPreferences = new Preferences();}
		
		return new ModelAndView("preferences-form", "preferences",oPreferences);
	}

	@RequestMapping(value = "/preferences-result")
	public ModelAndView processPreferences(@ModelAttribute Preferences pPreferences) {
		
		UserConnection oUserConnection = mUserConnectionDAO.findBymUserId( mFacebook.userOperations().getUserProfile().getId());
		Preferences oPreferences = mPreferencesDao.findByUserConnection(oUserConnection);
		
		if(oPreferences==null){
			oPreferences = pPreferences;
			oPreferences.setUserConnection(oUserConnection);
		}else{
			oPreferences.setPostOnFBTimeline(pPreferences.isPostOnFBTimeline());
			oPreferences.setSendEmail(pPreferences.isSendEmail());
		}
		
		mPreferencesDao.save(oPreferences);
		ModelAndView oModelAndView = new ModelAndView("home");
		String oEmail = mFacebook.userOperations().getUserProfile().getEmail();
		oModelAndView.addObject("email", oEmail);
		
		return oModelAndView;
	}
}