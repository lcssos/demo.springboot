package com.hhmedic.demo;

import com.hhmedic.demo.shiro.ShiroDbRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by lcssos on 2017/6/8.
 */
@Configuration
public class ShiroConfig {

    @Bean
    public HashedCredentialsMatcher getHashedCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("SHA-1");
        return hashedCredentialsMatcher;
    }


	@Bean
	public Realm getShiroRealm(){
		ShiroDbRealm shiroDbRealm = new ShiroDbRealm();
		shiroDbRealm.setCredentialsMatcher(getHashedCredentialsMatcher());
		return shiroDbRealm;
	}


	@Bean(name = "securityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager() {
		DefaultWebSecurityManager dwsm = new DefaultWebSecurityManager();
		dwsm.setRealm(getShiroRealm());
		return dwsm;
	}


	@Bean
	public ShiroFilterFactoryBean shiroFilterFactoryBean() {

		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setLoginUrl("/login");
		shiroFilterFactoryBean.setSuccessUrl("/");

		shiroFilterFactoryBean.setSecurityManager(getDefaultWebSecurityManager());

		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
		filterChainDefinitionMap.put("/login", "authc");
		filterChainDefinitionMap.put("/logout", "logout");
		filterChainDefinitionMap.put("/failure", "anon");
		filterChainDefinitionMap.put("/**", "user");

		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}

}
