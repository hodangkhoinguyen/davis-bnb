package com.example.nguyenho.davisbnb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
public class Review {
    @Id
    @UuidGenerator
    private UUID id;
    @ManyToOne
    private User author;
    @ManyToOne
    private Place place;
    private Integer num_star;
    private String review;
    @ElementCollection(targetClass = String.class)
    private List<String> photoList;
}
