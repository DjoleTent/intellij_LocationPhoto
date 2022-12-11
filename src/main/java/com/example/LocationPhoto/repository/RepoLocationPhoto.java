package com.example.LocationPhoto.repository;

import com.example.LocationPhoto.model.LocationPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RepoLocationPhoto extends JpaRepository<LocationPhoto, UUID> {

    List<LocationPhoto> findAll();

    @Query(value = "SELECT COUNT(*) FROM LOCATIONPHOTO WHERE locationname = :locationname", nativeQuery = true)
    int ifLocationExists(String locationname);


}
