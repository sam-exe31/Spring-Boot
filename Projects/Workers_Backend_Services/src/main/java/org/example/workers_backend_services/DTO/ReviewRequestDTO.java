package org.example.workers_backend_services.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewRequestDTO {


    private Long serviceRequestId;
    private Long customerId;
    private Long workerId;
    private Integer rating;
    private String reviewText;

}
