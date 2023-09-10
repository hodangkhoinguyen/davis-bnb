package com.example.nguyenho.davisbnb.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Data
@Builder
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Amenity {
    @Id
    @UuidGenerator
    private String id;
    private Integer num_bedroom;
    private Integer num_bathroom;
    private boolean hasTV;
    private boolean hasInternet;
    private boolean hasAC;
    private boolean hasHeat;
    private boolean hasParking;
}
