package org.example.workers_backend_services.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Worker_categoryrequestDTO {
    private double min_price;
    private double max_price;

    private Long worker_id;
    private Long cat_id;

}
