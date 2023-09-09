package com.example.nguyenho.davisbnb.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Place {
    @Id
    @UuidGenerator
    private String id;

    @ManyToOne
    private User owner;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    @OneToOne(cascade = CascadeType.ALL)
    private Amenity amenity;
    private String type;
    private String description;
    private Double price;
    @ElementCollection(targetClass = String.class)
    private List<String> photoList;
}
