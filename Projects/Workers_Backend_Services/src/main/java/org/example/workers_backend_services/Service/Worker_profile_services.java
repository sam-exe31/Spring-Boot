package org.example.workers_backend_services.Service;

import org.example.workers_backend_services.Entity.Worker_profile;
import org.example.workers_backend_services.Repository.Worker_profileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Worker_profile_services {

    @Autowired
    Worker_profileRepository repository;

    public List<Worker_profile> getallworkers() {
        return repository.findAll();
    }

    public Worker_profile getWorker(Long id) {
        return repository.findById(id).orElseThrow(null);
    }

    public Worker_profile addworker(Worker_profile profile) {
        return repository.save(profile);
    }

    public Worker_profile updateWorker(Long id, Worker_profile profile) {
        Worker_profile w= repository.findById(id).orElseThrow(() -> new RuntimeException("Worker profile not found with id: " + id));
        w.setExperience_years(profile.getExperience_years());
        w.setBio(profile.getBio());
        w.setProfile_image(profile.getProfile_image());
        w.setRating(profile.getRating());
        w.setCompleted_jobs(profile.getCompleted_jobs());
        if (profile.getUsers() != null) {
            w.setUsers(profile.getUsers());
        }

        return repository.save(w);
    }

    public void deleteWorker(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Cannot delete. Worker profile not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
