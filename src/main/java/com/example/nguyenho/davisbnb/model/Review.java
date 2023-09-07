package com.example.nguyenho.davisbnb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User author;
    @ManyToOne
    private Place place;
    private Integer num_star;
    private String review;
    @ElementCollection(targetClass = String.class)
    private List<String> photoList;
}
