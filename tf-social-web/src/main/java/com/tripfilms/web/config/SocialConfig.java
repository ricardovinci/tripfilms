package com.tripfilms.web.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.connect.web.ProviderSignInController;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;

import com.tripfilms.web.be.User;
import com.tripfilms.web.social.bo.SecurityContextBO;
import com.tripfilms.web.social.bo.SimpleConnectionSignUpBO;
import com.tripfilms.web.social.bo.SimpleSignInAdapterBO;


@Configuration
public class SocialConfig {

	@Autowired
	private Environment mEnvironment;

	@Autowired
	private DataSource mDataSource;
	
	@Bean
	public ConnectionFactoryLocator connectionFactoryLocator() {
		ConnectionFactoryRegistry oRegistry = new ConnectionFactoryRegistry();
		oRegistry.addConnectionFactory(new FacebookConnectionFactory(mEnvironment.getProperty("facebook.clientId"),
				mEnvironment.getProperty("facebook.clientSecret")));
		return oRegistry;
	}

	@Bean
	public UsersConnectionRepository usersConnectionRepository() {
		JdbcUsersConnectionRepository oRepository = new JdbcUsersConnectionRepository(mDataSource,
				connectionFactoryLocator(), Encryptors.noOpText());
		oRepository.setConnectionSignUp(new SimpleConnectionSignUpBO());
		return oRepository;
	}

	@Bean
	@Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)
	public ConnectionRepository connectionRepository() {
	    User oUser = SecurityContextBO.getCurrentUser();
	    return usersConnectionRepository().createConnectionRepository(oUser.getId());
	}

	@Bean
	@Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)	
	public Facebook facebook() {
	    return connectionRepository().getPrimaryConnection(Facebook.class).getApi();
	}
	
	@Bean
	public ProviderSignInController providerSignInController() {
		return new ProviderSignInController(connectionFactoryLocator(), usersConnectionRepository(),
				new SimpleSignInAdapterBO());
	}

}
