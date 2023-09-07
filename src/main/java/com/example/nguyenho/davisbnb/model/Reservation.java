package com.example.nguyenho.davisbnb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@Builder
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Place place;
    @ManyToOne
    private User host;
    @ManyToOne
    private User renter;
    private Date startDate;
    private Date endDate;
    private Double totalPrice;
}
