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
public class Address {
    @Id
    @UuidGenerator
    private String id;
    private Double latitude;
    private Double longitude;
    private String street;
    private String city;
    private String state;
    private String zipcode;
}
