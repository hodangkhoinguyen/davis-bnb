package com.example.nguyenho.davisbnb.controller;

import com.example.nguyenho.davisbnb.payload.response.MessageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/place")
@RequiredArgsConstructor
public class PlaceController {

    @PostMapping("/create")
    public ResponseEntity<?> createPlace() {
        return ResponseEntity.ok(new MessageResponse("Create place successfully"));
    }
}
