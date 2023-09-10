package com.example.nguyenho.davisbnb.controller;

import com.example.nguyenho.davisbnb.model.Address;
import com.example.nguyenho.davisbnb.model.Amenity;
import com.example.nguyenho.davisbnb.model.Place;
import com.example.nguyenho.davisbnb.payload.response.MessageResponse;
import com.example.nguyenho.davisbnb.service.AddressService;
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
    private final AddressService addressService;
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
        placeService.updatePlaceById(placeId, place);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{placeId}")
    public ResponseEntity<Place> deletePlaceById(@PathVariable String placeId) {
        logger.info("Delete place by Id");
        placeService.deletePlaceById(placeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{placeId}/address/{addressId}")
    public ResponseEntity<?> updateAddress(@PathVariable String placeId, @PathVariable String addressId, @RequestBody Address address) {
        addressService.updateAddress(placeId, addressId, address);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{placeId}/amenity/{amenityId}")
    public ResponseEntity<?> updateAmenity(@PathVariable String placeId, @PathVariable String amenityId, @RequestBody Amenity amenity) {
        addressService.updateAmenity(placeId, amenityId, amenity);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
