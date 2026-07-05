package org.example.workers_backend_services.Controller;

import org.example.workers_backend_services.Entity.Service_request;
import org.example.workers_backend_services.Service.Service_Request_Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service_request")
public class Service_Request_Controller {
    @Autowired
    Service_Request_Services services;

    @PostMapping
    public ResponseEntity<Service_request> createRequest(@RequestBody Service_request serviceRequest) {
        Service_request createdRequest = services.createServiceRequest(serviceRequest);
        return new ResponseEntity<>(createdRequest, HttpStatus.CREATED);
    }

    // 2. Get all service requests
    @GetMapping
    public ResponseEntity<List<Service_request>> getAllRequests() {
        List<Service_request> requests = services.getAllServiceRequests();
        return ResponseEntity.ok(requests);
    }

    // 3. Get a specific service request by ID
    @GetMapping("/{id}")
    public ResponseEntity<Service_request> getRequestById(@PathVariable("id") Long id) {
        Service_request request = services.getServiceRequestById(id);
        if (request != null) {
            return ResponseEntity.ok(request);
        }
        return ResponseEntity.notFound().build();
    }

    // 4. Update an existing service request
    @PutMapping("/{id}")
    public ResponseEntity<Service_request> updateRequest(@PathVariable("id") Long id, @RequestBody Service_request serviceRequest) {
        Service_request updatedRequest = services.updateServiceRequest(id, serviceRequest);
        if (updatedRequest != null) {
            return ResponseEntity.ok(updatedRequest);
        }
        return ResponseEntity.notFound().build();
    }

    // 5. Delete a service request
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequest(@PathVariable("id") Long id) {
        boolean deleted = services.deleteServiceRequest(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
