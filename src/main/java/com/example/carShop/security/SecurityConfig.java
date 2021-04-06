package com.example.carShop.security;

import com.intersalonica.security.config.InterSecurityJWTFilter;
import com.intersalonica.security.config.JWTConfigurer;
import com.intersalonica.security.config.TokenProvider;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Arrays;


@EnableWebMvc
@Configuration
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final TokenProvider tokenProvider;
    private final InterSecurityJWTFilter interSecurityJWTFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .cors()
                .and()
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/register").permitAll()
                .anyRequest().authenticated()
                .and()
                .apply(new JWTConfigurer(this.tokenProvider, this.interSecurityJWTFilter));
    }

    // AUTH-TOKEN -> Replace the AUTH-TOKEN with your custom JWT token name

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "TRACE", "OPTIONS", "PATCH"));
        configuration.setAllowedHeaders(Arrays.asList("CAR-SHOP-TOKEN", "X-LOGIN-SUCCESS", "X-LOGOUT-SUCCESS", "Content-type", "Access-Control-Allow-Origin", "X-VALIDATION-ERROR"));
        configuration.setExposedHeaders(Arrays.asList("CAR-SHOP-TOKEN", "X-LOGIN-SUCCESS", "X-LOGOUT-SUCCESS", "X-VALIDATION-ERROR"));
        source.registerCorsConfiguration("/**", configuration);
        return new CorsFilter(source);
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

}
