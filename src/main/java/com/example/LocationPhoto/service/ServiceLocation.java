package com.example.LocationPhoto.service;

import com.example.LocationPhoto.model.LocationPhoto;
import com.example.LocationPhoto.repository.RepoLocationPhoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ServiceLocation {

    private final RepoLocationPhoto repoLocationPhoto;

    @Autowired
    public ServiceLocation(RepoLocationPhoto repoLocationPhoto) {
        this.repoLocationPhoto = repoLocationPhoto;
    }

    public List<LocationPhoto> showAll() {
        return repoLocationPhoto.findAll();
    }

    public int ifLPExist(LocationPhoto locationPhoto) {
        return repoLocationPhoto.ifLocationExists(locationPhoto.getLocationname());
    }


}