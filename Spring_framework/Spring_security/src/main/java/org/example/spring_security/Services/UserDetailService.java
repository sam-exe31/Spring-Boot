package org.example.spring_security.Services;

import org.example.spring_security.Entity.UserPrincipal;
import org.example.spring_security.Entity.Users;
import org.example.spring_security.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Primary
public class   UserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo repo;
    @Autowired
    @Lazy
    AuthenticationManager auth;


    @Autowired
    private JWTService jwtService;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        Users user=repo.findByName(name);

        if(user==null){
            throw new UsernameNotFoundException("user not found");
        }

        return new UserPrincipal(user);


    }
    @Autowired
    private UserRepo userRepo;

    private BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();

    public Users register(Users user){
        // Before launching to database
        user.setPassword(encoder.encode(user.getPassword()));
       return  repo.save(user);
    }

    public String verify(Users user) {
        Authentication authentication=auth.authenticate(new UsernamePasswordAuthenticationToken(user.getName(),user.getPassword()));

        if(authentication.isAuthenticated()){
            return jwtService.genrateToken(user.getName());
        }
        else{
            return "no login possible go home";
        }
    }

//    @Service
//    public static class UserDetails EmployeeServices implements UserDetails {
//
//        @Autowired
//        EmployeeRepository employeeRepository;
//
//        public UserDetails loadbyusername(String name){
//            Employee employee=employeeRepository.findbyname(name);
//            if(employee==null){
//                System.out.println("exception");
//                throw new UsernameNotFoundException("no username found");
//            }
//            Employee Employee;
//            return new EmployeePrincipal(employee);
//        }
//    }
}
