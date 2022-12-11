package com.example.LocationPhoto.api;

import com.example.LocationPhoto.model.LocationPhoto;
import com.example.LocationPhoto.repository.RepoLocationPhoto;
import com.example.LocationPhoto.service.ServiceLocation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ControllerLocation {

    private final ServiceLocation serviceLocation;
    private final RepoLocationPhoto repoLocationPhoto;


    public ControllerLocation(ServiceLocation serviceLocation, RepoLocationPhoto repoLocationPhoto) {
        this.serviceLocation = serviceLocation;
        this.repoLocationPhoto = repoLocationPhoto;
    }

    @GetMapping("/api/allLocations")
    public List<LocationPhoto> showAll() {
        return serviceLocation.showAll();
    }

    @GetMapping("/api/oneLocation/{locationname}")
    public LocationPhoto oneLocation(@PathVariable("locationname") String locationname) {
        for (var oneLP : serviceLocation.showAll()) {
            if (oneLP.getLocationname().equalsIgnoreCase(locationname)) {
                return oneLP;
            }
        }
        return null;
    }

    @PostMapping("/api/createLocationPhoto")
    public int createLocationPhoto(@RequestBody LocationPhoto locationPhoto) {
        if (serviceLocation.ifLPExist(locationPhoto) != 0) {
            return 0;
        }
        if (locationPhoto.getXcoor() == null || locationPhoto.getYcoor() == null) {
            return 0;
        }

        locationPhoto.setId(UUID.randomUUID());
        repoLocationPhoto.save(locationPhoto);
        return 1;
    }

    @DeleteMapping("/api/deleteLocationPhoto/{locationname}")
    public void deleteLocationPhotoById(@PathVariable("locationname") String locationname) {
        for (var oneLP : serviceLocation.showAll()) {
            if (oneLP.getLocationname().equalsIgnoreCase(locationname)) {
                repoLocationPhoto.delete(oneLP);
            }
        }
    }

    @PutMapping("/api/addPhoto/{locationname}")
    public void addPhotoToLP(@PathVariable("locationname") String locationname, @RequestBody LocationPhoto locationPhoto) {
        for (var oneLP : serviceLocation.showAll()) {
            if (oneLP.getLocationname().equalsIgnoreCase(locationname)) {
                oneLP.setImage(locationPhoto.getImage());
                repoLocationPhoto.save(oneLP);
            }
        }
    }


}
