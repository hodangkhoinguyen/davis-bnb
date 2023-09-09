package com.example.nguyenho.davisbnb.repository;

import com.example.nguyenho.davisbnb.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place, String> {
    List<Place> findByOwnerId(String userId);
}
