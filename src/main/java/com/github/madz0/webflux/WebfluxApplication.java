package com.github.madz0.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.SecurityWebFilterChain;

@SpringBootApplication
public class WebfluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebfluxApplication.class, args);
	}
	
	@EnableWebFluxSecurity
	@EnableReactiveMethodSecurity
	public class SecurityConfig {

		@Bean
		SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity http) throws Exception {
			return http
				// Demonstrate that method security works
				// Best practice to use both for defense in depth
				.authorizeExchange()
					.anyExchange().permitAll()
					.and()
				.httpBasic().and()
				.build();
		}

		@Bean
		public MapReactiveUserDetailsService userDetailsService() {
			
			User.UserBuilder userBuilder = User.builder();
			UserDetails rob = userBuilder.username("rob").password("rob").roles("USER").build();
			UserDetails admin = userBuilder.username("admin").password("admin").roles("USER", "ADMIN").build();
			return new MapReactiveUserDetailsService(rob, admin);
		}

	}
}
