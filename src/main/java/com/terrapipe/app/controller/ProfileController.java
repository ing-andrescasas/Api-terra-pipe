package com.terrapipe.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.terrapipe.app.model.entity.Profile;
import com.terrapipe.app.model.services.TerraPipeServiceIface;

@RestController
@RequestMapping("/profiles")
public class ProfileController {
    @Autowired
    private TerraPipeServiceIface terraService;

    @GetMapping("/all")
    public ResponseEntity<List<Profile>> allProfiles() {
        return ResponseEntity.ok(terraService.allProfiles());
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Profile> findProfile(@PathVariable Integer id){
        return ResponseEntity.ok(terraService.findProfileById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Profile> createProfile(@RequestBody Profile profile) {
        Profile profileCreated = terraService.saveProfile(profile);
        return  ResponseEntity.ok(profileCreated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Profile> deleteProfile(@PathVariable Integer id)  {

        Profile profileDelete = terraService.findProfileById(id);
        terraService.deleteProfileById(id);;
        return ResponseEntity.ok( profileDelete);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Profile> editProfile(@PathVariable Integer id, @RequestBody  Profile profile) {
        try {
            Profile profileExistente = terraService.findProfileById(id);

            if (profile.getName()!= null && !profile.getName().isEmpty())
            profileExistente.setName(profile.getName());


            profileExistente.setStatus(profile.isStatus());

            terraService.updateProfile(profileExistente);

            return ResponseEntity.ok(profileExistente);

        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
