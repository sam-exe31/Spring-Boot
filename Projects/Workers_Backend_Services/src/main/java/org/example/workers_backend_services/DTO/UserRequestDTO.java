package org.example.workers_backend_services.DTO;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserRequestDTO {


    private String user_name;
    private String email;
    private String phone;
    private String password;
}
