package spring.sec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecuritConfig extends WebSecurityConfigurerAdapter	 {

	@Autowired
	MySimpleUrlAuthenticationSuccessHandler customSuccessHandler;

	@Autowired
	private DataSource datasource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*
		auth.inMemoryAuthentication().withUser("oumar").password("{noop}1234").roles("admin","gestionnaire");

		auth.inMemoryAuthentication().withUser("toto").password("{noop}1234").roles("locataire"); */

		/*
		auth.jdbcAuthentication().dataSource(datasource)
		.usersByUsernameQuery("Select username as principal, password as credentials, idcompte as idCompte from compte  where username=?")
		.authoritiesByUsernameQuery("Select username as principal,role as role from compte where username=?")
				.passwordEncoder(new BCryptPasswordEncoder()).rolePrefix("ROLE_");
		 */

		auth.jdbcAuthentication().dataSource(datasource)
				.usersByUsernameQuery("Select email as principal, password as credentials, id as id from user  where email=?")
				.authoritiesByUsernameQuery("Select email as principal,name as role from user,role  where user.role_id =role.id  and email=?")
				.passwordEncoder(new BCryptPasswordEncoder()).rolePrefix("ROLE_");
	}



	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/user/*",
				"/model/*","/team/*","/domain/*").hasRole("ADMINISTRATEUR").and().formLogin()
				.loginPage("/login").successHandler(customSuccessHandler)
				.and().logout();

		http.authorizeRequests().antMatchers("/demand/*")
				.hasRole("COLLABORATEUR").and().formLogin().loginPage("/login")
				.successHandler(customSuccessHandler).and().logout();

		http.authorizeRequests().antMatchers("/demand/response")
				.hasRole("INTERVENANT").and().formLogin().loginPage("/login")
				.successHandler(customSuccessHandler).and().logout();



	}

}
