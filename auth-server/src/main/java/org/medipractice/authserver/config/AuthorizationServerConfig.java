package org.medipractice.authserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	@Value("${oauth2.client.id}") private String CLIENT_ID;
	@Value("${oauth2.client.secret}") private String CLIENT_SECRET;
	
	static final String GRANT_TYPE_PASSWORD = "password";
	static final String AUTHORIZATION_CODE = "authorization_code";
	static final String REFRESH_TOKEN = "refresh_token";
	static final String IMPLICIT = "implicit";
	static final String CLIENT_CREDENTIALS = "client_credentials";
	static final String SCOPE_READ = "read";
	static final String SCOPE_WRITE = "write";
	static final String SCOPE_TRUST = "trust";
	static final int ACCESS_TOKEN_VALIDITY_SECONDS = 1*60*60;
    static final int REFRESH_TOKEN_VALIDITY_SECONDS = 6*60*60;

	@Autowired
	private TokenStore tokenStore;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Override
	public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {
		configurer
				.inMemory()
				.withClient(CLIENT_ID)
				.secret(CLIENT_SECRET)
				.authorizedGrantTypes(GRANT_TYPE_PASSWORD, AUTHORIZATION_CODE, REFRESH_TOKEN, IMPLICIT )
				//.authorizedGrantTypes(CLIENT_CREDENTIALS)
				.scopes(SCOPE_READ, SCOPE_WRITE, SCOPE_TRUST)
				.accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_SECONDS)
				.refreshTokenValiditySeconds(REFRESH_TOKEN_VALIDITY_SECONDS);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
	    Map<String, CorsConfiguration> corsConfigMap = new HashMap<>();
	    CorsConfiguration config = new CorsConfiguration();
	    config.setAllowCredentials(true);
	    //TODO: Make configurable
	    config.setAllowedOrigins(Collections.singletonList("*"));
	    config.setAllowedMethods(Collections.singletonList("*"));
	    config.setAllowedHeaders(Collections.singletonList("*"));
	    corsConfigMap.put("/oauth/token", config);
	    endpoints.getFrameworkEndpointHandlerMapping()
	            .setCorsConfigurations(corsConfigMap);
	            		
		endpoints
			.tokenStore(tokenStore)
			.authenticationManager(authenticationManager)
			.allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST)
			;
	}
	
	  @Override
	  public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
	    oauthServer.allowFormAuthenticationForClients();
	  }
}