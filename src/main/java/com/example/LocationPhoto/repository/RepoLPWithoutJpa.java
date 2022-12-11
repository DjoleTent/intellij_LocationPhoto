package com.example.LocationPhoto.repository;


import com.example.LocationPhoto.model.LocationPhoto;

import java.util.List;

public interface RepoLPWithoutJpa {

    List<LocationPhoto> findAll();
}
