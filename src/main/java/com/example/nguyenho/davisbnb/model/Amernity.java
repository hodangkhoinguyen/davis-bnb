package com.example.nguyenho.davisbnb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
public class Amernity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer num_bedroom;
    private Integer num_bathroom;
    private boolean hasTV;
    private boolean hasInternet;
    private boolean hasAC;
    private boolean hasHeat;
    private boolean hasParking;
}
