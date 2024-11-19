package org.sid.inventoryservice.security;

import lombok.AllArgsConstructor;
import org.sid.inventoryservice.security.filters.JwtAuthenticationFilter;
import org.sid.inventoryservice.security.filters.JwtAuthorizationFilter;
import org.sid.inventoryservice.security.sec_service.UserDetailesServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private UserDetailesServiceImpl userDetailesService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailesService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().disable();
        http.csrf().disable();
        http.headers().frameOptions().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        //http.headers().frameOptions().disable();
        http.authorizeRequests().antMatchers("/h2-console/**","/refreshToken/**","/category/listcatcham/**","/category/listcatmenu/**","/chambre/**","/menu/listmenu/**","/menu/listmenByCat/**","/photoCategMenu/**","/photoMenu/**","/photoCategCham/**","/photoChambre/**","/users/**","/user/getone/**","/login/**","/logout/**","/register/**","/addRoleByCustomer/**","/chambreItem/getByChambre/**","/swagger-ui/**").permitAll();
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(new JwtAuthenticationFilter(authenticationManagerBean()));// INTEGRE LE FILTRE DANS FICHER DE CONFIGURATION
        http.addFilterBefore(new JwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);//filtre requette

       /*http.cors().disable();
        http.headers().frameOptions().disable();//desactive la protection de frames

        http.authorizeRequests().antMatchers("/h2-console/**", "/refreshToken/**", "/login/**", "/register/**").permitAll().antMatchers(HttpMethod.OPTIONS, "/**");
        //http.authorizeRequests().antMatchers("/webjar/**").permitAll(); //permet tout le ressource accede
        //http.formLogin(); http.formLogin().logingPage("/loging");//Statefull controler par le server
        //http.authorizeRequests().anyRequest().permitAll();//tous les requette ne nessecite pas une authentification
        //http.authorizeRequests().antMatchers(HttpMethod.POST,"/users/**").hasAuthority("ADMIN");// premier methode
        //http.authorizeRequests().antMatchers(HttpMethod.GET,"/users/**").hasAuthority("USER");//premier methode
        http.authorizeRequests().anyRequest().authenticated();// APPART /h2-console/** TU DOIT TOUT AUTHENTIFIER
        http.addFilter(new JwtAuthenticationFilter(authenticationManagerBean()));// INTEGRE LE FILTRE DANS FICHER DE CONFIGURATION
        http.addFilterBefore(new JwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);//filtre requette


        http.csrf().disable();
        http.authorizeRequests().antMatchers("/h2-console/**","/refreshToken/**","/login/**","/register/**").permitAll().anyRequest().authenticated();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);//session controler par les client http
        http.addFilter(new JwtAuthenticationFilter(authenticationManagerBean()));// INTEGRE LE FILTRE DANS FICHER DE CONFIGURATION
        http.addFilterBefore(new JwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);//filtre requette
*/


    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}

