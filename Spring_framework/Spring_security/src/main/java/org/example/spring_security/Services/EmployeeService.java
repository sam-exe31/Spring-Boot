package org.example.spring_security.Services;

import org.example.spring_security.Entity.Employee;
import org.example.spring_security.Entity.EmployeePrincipal;
import org.example.spring_security.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
//@Primary
public class EmployeeService implements UserDetailsService {

    @Autowired

    EmployeeRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee=repository.findByEmpName(username);

        if(employee==null){
            throw new UsernameNotFoundException("not found the error");
        }
        return new  EmployeePrincipal(employee);
    }
}
