package com.example.nguyenho.davisbnb.model;

import jakarta.persistence.*;
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
public class RefreshToken {
    @Id
    @UuidGenerator
    private String id;

    @Column(unique = true, nullable = false)
    private String token;
    @ManyToOne
    private User user;
}
