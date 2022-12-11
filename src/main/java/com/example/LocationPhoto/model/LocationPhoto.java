package com.example.LocationPhoto.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "LOCATIONPHOTO")
public class LocationPhoto {

    @Id
    private UUID id;
    private String locationname;
    private String xcoor;
    private String ycoor;
    private String image;

    public LocationPhoto(@JsonProperty String image) {
        this.image = image;
    }

}
