package org.medipractice.authserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	private static final String RESOURCE_ID = "auth_server";
	private static final String ANT_MATCHERS = "/**"; 
	
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId(RESOURCE_ID).stateless(false);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
        http
        	.cors().and()
        	.anonymous().disable()
            .authorizeRequests()
            .antMatchers(ANT_MATCHERS).authenticated()
            .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
	}
}