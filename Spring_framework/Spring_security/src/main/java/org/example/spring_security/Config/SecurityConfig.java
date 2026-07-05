
package org.example.spring_security.Config;
import jakarta.servlet.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtFilter jwtFilter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(customizer -> customizer.disable())
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/register","/login")
                        .permitAll()
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user1 = User
//                .withDefaultPasswordEncoder()
//                .username("radha")
//                .password("radha12")
//                .roles("USER")
//                .build();
//
//        UserDetails user2 = User
//                .withDefaultPasswordEncoder()
//                .username("sonu")

//                .password("sonu12")
//                .roles("ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(user1, user2);
//    }

//    instead of using old method of setuserdetailservice we do it in daoAuthntication
    @Bean
    public AuthenticationProvider authprovider(UserDetailsService userDetailsService) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService);
//        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));

//        provider.setUserDetailsPasswordService((UserDetailsPasswordService) userDetailsService);
        return provider;
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration){
        return authenticationConfiguration.getAuthenticationManager();

    }
}


























//
//
//
//package org.example.spring_security.Config;
//
//
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    // here we are instructing spring to dont go with the secrity filter default but instead use this
//    // bypassing it
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
//
////        http.csrf(customizer->customizer.disable());
////        http.authorizeHttpRequests(request->request.anyRequest().authenticated());
//////        http.formLogin(Customizer.withDefaults());  // this is only for browsers but will get a html page in postman
////        // so for this to work in postman we need to do like
////        http.httpBasic(Customizer.withDefaults());
////        http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//        //for managing sateless authetication this works in postman but not in browser as it will generate new session instnatly
//        // so we need to disable the form login which we have specified fpr the browser so it will ask us like in JS now
//        // but wokr in postman
//
////        Customizer<CsrfConfigurer<HttpSecurity>> customizer=new Customizer<CsrfConfigurer<HttpSecurity>>() {
////            @Override
////            public void customize(CsrfConfigurer<HttpSecurity> customizer) {
////                customizer.disable();
////            }
////        };
////        http.csrf(customizer);
////        thsi is what we did to make like disable things
////        these all is equal to     http.csrf(customizer->customizer.disable());
//
//        //using builder pattern
//
//        return http
//                .csrf(customizer -> customizer.disable())
//                .authorizeHttpRequests(request -> request.anyRequest().authenticated())
//                .httpBasic(Customizer.withDefaults())
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .build();
//
//    }
//
//    @Bean
//    public InMemoryUserDetailsManager userDetailsService(){
////        List<UserDetails> list_of_user=new ArrayList<>();
//
//        UserDetails user1= User
//                .withDefaultPasswordEncoder()
//                .username("radha")
//                .password("radha12")
//                .roles("user")
//                .build();
//
//        UserDetails user2= User
//                .withDefaultPasswordEncoder()
//                .username("sonu")
//                .password("sonu12")
//                .roles("ADMIN")
//                .build();
//
////        list_of_user.add(user1,user2);
//        return new InMemoryUserDetailsManager(user2,user1);
//    }
//
//    // this is also hard coded and something is like authentication provider is needed
//    @Bean
//    public AuthenticationProvider authprovider(UserDetailsService myuserDetailsService){
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
//        provider.setUserDetailsService(myuserDetailsService);
//
//        return provider;
//    }
//}
