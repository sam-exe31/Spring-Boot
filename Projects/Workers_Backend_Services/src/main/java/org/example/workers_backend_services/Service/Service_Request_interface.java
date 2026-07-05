package org.example.workers_backend_services.Service;

import org.example.workers_backend_services.Entity.Service_request;

import java.util.List;

public interface Service_Request_interface {
    Service_request createServiceRequest(Service_request serviceRequest);

    List<Service_request> getAllServiceRequests();

    Service_request getServiceRequestById(Long id);

    Service_request updateServiceRequest(Long id, Service_request updatedData);

    boolean deleteServiceRequest(Long id);
}
