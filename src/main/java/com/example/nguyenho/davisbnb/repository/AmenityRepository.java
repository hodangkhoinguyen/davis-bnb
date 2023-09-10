package com.example.nguyenho.davisbnb.repository;

import com.example.nguyenho.davisbnb.model.Amenity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmenityRepository extends JpaRepository<Amenity, String> {
}
