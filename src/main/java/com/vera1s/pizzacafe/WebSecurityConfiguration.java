package com.vera1s.pizzacafe;

import com.vera1s.pizzacafe.entity.SecurityAccount;
import com.vera1s.pizzacafe.repository.SecurityAccountRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.disable())
                .authorizeHttpRequests((requests) -> {
                    requests.requestMatchers(HttpMethod.DELETE, "/pizza/delete/{id}").hasRole("ADMIN");
                    requests.requestMatchers(HttpMethod.GET, "/pizza/{id}").hasAnyRole("USER", "ADMIN");
                    requests.anyRequest().permitAll();
                })
                .formLogin(formLogin -> formLogin.disable())
                .httpBasic(httpBasic -> httpBasic.init(http));

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(SecurityAccountRepository securityAccountRepository) {
        UserDetailsService userDetailsService = (username) -> {
            SecurityAccount securityAccount = securityAccountRepository.findByLogin(username);
            if (securityAccount != null) {
                return securityAccount;
            }
            else {
                throw new UsernameNotFoundException("ERROR");
            }
        };

        return userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        return bCryptPasswordEncoder;
    }


}
