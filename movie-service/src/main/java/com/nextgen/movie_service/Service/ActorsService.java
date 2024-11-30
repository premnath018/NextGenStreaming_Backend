package com.nextgen.movie_service.Service;

import com.nextgen.movie_service.Entity.Actors;
import com.nextgen.movie_service.Repository.ActorsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorsService {

    @Autowired
    private ActorsRepo actorsRepo;



    public Actors createActor(Actors actors) {
        return actorsRepo.save(actors);
    }


    public List<Actors> getAllActors() {
        return actorsRepo.findAll();
    }


    public Optional<Actors> getActorById(Long id) {
        return actorsRepo.findById(id);
    }


    public Actors updateActor(Long id, Actors updatedActor) {
        if (actorsRepo.existsById(id)) {
            updatedActor.setId(id);
            return actorsRepo.save(updatedActor);
        } else {
            throw new RuntimeException("Actor not found with id: " + id);
        }
    }

    public void deleteActor(Long id) {
        if (actorsRepo.existsById(id)) {
            actorsRepo.deleteById(id);
        } else {
            throw new RuntimeException("Actor not found with id: " + id);
        }
    }
}
