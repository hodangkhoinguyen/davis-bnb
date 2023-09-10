package com.example.nguyenho.davisbnb.repository;

import com.example.nguyenho.davisbnb.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {
}
