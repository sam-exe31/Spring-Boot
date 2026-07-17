package org.example.workers_backend_services.DTO;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Worker_profilerequestDTO {
    private int experience_years;
    private String bio;
    private String profile_image;
    private Long user_id;

    // like rating and stuff cant be modified by the user
}
