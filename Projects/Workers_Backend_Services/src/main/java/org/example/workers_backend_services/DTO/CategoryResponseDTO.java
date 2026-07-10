package org.example.workers_backend_services.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CategoryResponseDTO {

    private Long cat_id;
    private String cat_name;
    private String description;
}
