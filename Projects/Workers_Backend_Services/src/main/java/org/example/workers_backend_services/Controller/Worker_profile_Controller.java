package org.example.workers_backend_services.Controller;

import org.example.workers_backend_services.Entity.Users;
import org.example.workers_backend_services.Entity.Worker_profile;
import org.example.workers_backend_services.Service.Worker_profile_services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workers")
public class Worker_profile_Controller {

    @Autowired
    Worker_profile_services services;

    @GetMapping
    public ResponseEntity<List<Worker_profile>> getallWorkers(){
        List<Worker_profile> list=services.getallworkers();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker_profile> getWorker(@PathVariable Long id){
        Worker_profile prof=services.getWorker(id);
        if(prof!=null){
            return ResponseEntity.ok(prof);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Worker_profile> addWorker(@RequestBody Worker_profile profile){
        Worker_profile prof=services.addworker(profile);
        return new ResponseEntity<>(prof, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Worker_profile> updateWorker(@PathVariable long id,@RequestBody Worker_profile profile){
        Worker_profile prof=services.updateWorker(id,profile);
        if(prof!=null){
            return ResponseEntity.ok(prof);
        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWorker(@PathVariable long id){
        services.deleteWorker(id);
        return ResponseEntity.ok("worker_profile_not_found");
    }
}
