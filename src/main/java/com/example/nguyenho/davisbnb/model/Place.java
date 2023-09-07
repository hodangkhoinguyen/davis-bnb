package com.example.nguyenho.davisbnb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @OneToOne
    private Address address;
    @OneToOne
    private Amernity amernity;
    private String type;
    private String description;
    private Double price;
    @ElementCollection(targetClass = String.class)
    private List<String> photoList;

}
