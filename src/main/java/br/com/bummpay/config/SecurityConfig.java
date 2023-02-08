/*
package br.com.bummpay.config;

import br.com.bummpay.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public UsuarioServiceImpl usuarioService;


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    };

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.
                userDetailsService(usuarioService)
                .passwordEncoder(passwordEncoder());

*/
/*        try {
            auth.inMemoryAuthentication()
                    .passwordEncoder(passwordEncoder())
                    .withUser("fulano")
                    .password(passwordEncoder().encode("123"))
                    .roles("USER","ADMIN");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }*//*

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                    .authorizeRequests()
                        .antMatchers("/api/clientes/**")
                            .hasAnyRole("USER","ADMIN")
                        .antMatchers("/api/pedidos/**")
                            .hasAnyRole("USER","ADMIN")
                        .antMatchers("/api/produtos/**")
                            .hasRole("ADMIN")
                        .antMatchers(HttpMethod.POST,"/api/usuarios/**")
                            .permitAll()
                        .anyRequest().authenticated()
                    .and()
                        .httpBasic()
        ;
    }
}
*/
