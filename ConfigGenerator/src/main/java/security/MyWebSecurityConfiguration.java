package security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.security.config.annotation.web.configuration;

import chritzman.config.model.User;

@Configuration
@EnableWebMvc
public class MyWebSecurityConfiguration {

       @Bean
       public WebSecurityCustomizer webSecurityCustomizer() {
               return (web) -> web.ignoring()
               // Spring Security should completely ignore URLs starting with /resources/
                               .requestMatchers("/resources/**");
       }

       @Bean
       public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
               http.authorizeHttpRequests().requestMatchers("/public/**").permitAll().anyRequest()
                               .hasRole("USER").and()
                               // Possibly more configuration ...
                               .formLogin() // enable form based log in
                               // set permitAll for all URLs associated with Form Login
                               .permitAll();
               return http.build();
       }

       @Bean
       public UserDetailsService userDetailsService() {
               UserDetails user = User.withDefaultPasswordEncoder()
                       .username("user")
                       .password("password")
                       .roles("USER")
                       .build();
               UserDetails admin = User.withDefaultPasswordEncoder()
                       .username("admin")
                       .password("password")
                       .roles("ADMIN", "USER")
                       .build();
               return new InMemoryUserDetailsManager(user, admin);
       }

       // Possibly more bean methods ...
}
