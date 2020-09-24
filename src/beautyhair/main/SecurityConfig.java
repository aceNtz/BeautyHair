package beautyhair.main;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource myDataSource;
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(myDataSource);
	}

	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/").permitAll()

		.antMatchers("/administration/company-info").hasRole("admin")
		.antMatchers("/administration/company-info-update").hasRole("admin")
		.antMatchers("/administration/message-list").hasRole("admin")
		.antMatchers("/administration/user-list").hasRole("admin")
		.antMatchers("/administration/user-form").hasRole("admin")
		.antMatchers("/administration/partner-list").hasRole("admin")
		.antMatchers("/administration/partner-form").hasRole("admin")
		.antMatchers("/administration/**").hasAnyRole("employee, admin")
			
		.and().formLogin().loginPage("/login")
		.loginProcessingUrl("/authenticateTheUser").permitAll();
		
	}
	
	
	
   
	
	
}
