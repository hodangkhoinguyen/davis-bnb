package com.example.nguyenho.davisbnb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
public class RefreshToken {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String token;
    @ManyToOne
    private User user;
}
