package com.example.nguyenho.davisbnb.controller;

import com.example.nguyenho.davisbnb.model.Place;
import com.example.nguyenho.davisbnb.payload.response.MessageResponse;
import com.example.nguyenho.davisbnb.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/place")
@RequiredArgsConstructor
public class PlaceController {
    private final PlaceService placeService;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @PostMapping("")
    public ResponseEntity<?> createPlace(@RequestBody Place place) {
        logger.info("create place");
        placeService.createPlace(place);
        return ResponseEntity.ok(new MessageResponse("Create place successfully"));
    }

    @GetMapping("/{placeId}")
    public ResponseEntity<Place> getPlaceById(@PathVariable String placeId) {
        logger.info("Get place by Id");
        Optional<Place> place = placeService.getPlaceById(placeId);
        if (place.isPresent()) {
            logger.info("{}", place.get());
            return new ResponseEntity<>(place.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getPlaceByUser(@PathVariable String userId) {
        logger.info("Get place by user");
        List<Place> places = placeService.getPlaceByUser(userId);
        return new ResponseEntity<>(places, HttpStatus.OK);
    }

    @PutMapping("/{placeId}")
    public ResponseEntity<?> updatePlaceById(@PathVariable String placeId, @RequestBody Place place) {
        logger.info("Update place by user");
        Optional<Place> updatedPlace = placeService.updatePlaceById(placeId, place);
        if (updatedPlace.isPresent()) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{placeId}")
    public ResponseEntity<Place> deletePlaceById(@PathVariable String placeId) {
        logger.info("Delete place by Id");
        Optional<Place> deletedPlace = placeService.deletePlaceById(placeId);
        if (deletedPlace.isPresent()) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
