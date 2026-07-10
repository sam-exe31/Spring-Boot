package org.example.workers_backend_services.DTO;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Service_requestRequestDTO {

    private Long customerId;
//    private String worker;
    private Long categoryId;
    private String title;
    private String description;
    private String address;
    private LocalDate preferredDate;
    private LocalDate preferredTime;

}
