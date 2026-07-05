package org.example.workers_backend_services.Service;

import org.example.workers_backend_services.Entity.ServiceStatus;
import org.example.workers_backend_services.Entity.Service_request;
import org.example.workers_backend_services.Repository.Service_Request_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class Service_Request_Services implements Service_Request_interface {

    @Autowired
    Service_Request_Repository repository;

    @Override
    public Service_request createServiceRequest(Service_request serviceRequest) {
        // Set audit fields and initial status on creation
        serviceRequest.setCreatedAt(LocalDateTime.now());
        return repository.save(serviceRequest);
    }

    @Override
    public List<Service_request> getAllServiceRequests() {
        return repository.findAll();
    }

    @Override
    public Service_request getServiceRequestById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Service_request updateServiceRequest(Long id, Service_request updatedData) {
        Optional<Service_request> existingRequestOpt = repository.findById(id);

        if (existingRequestOpt.isPresent()) {
            Service_request existingRequest = existingRequestOpt.get();

            // Map incoming updates to the managed database entity
            existingRequest.setTitle(updatedData.getTitle());
            existingRequest.setDescription(updatedData.getDescription());
            existingRequest.setAddress(updatedData.getAddress());
            existingRequest.setPreferredDate(updatedData.getPreferredDate());
            existingRequest.setPreferredTime(updatedData.getPreferredTime());
            existingRequest.setStatus(updatedData.getStatus());

            // Usually, you don't overwrite createdAt or the relationships unless explicitly required
            if (updatedData.getWorker() != null) {
                existingRequest.setWorker(updatedData.getWorker());
            }

            return repository.save(existingRequest);
        }
        return null;
    }

    @Override
    public boolean deleteServiceRequest(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
