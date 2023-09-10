package com.example.nguyenho.davisbnb.service;

import com.example.nguyenho.davisbnb.exception.NotFoundResourceException;
import com.example.nguyenho.davisbnb.exception.UserNotAuthorizedException;
import com.example.nguyenho.davisbnb.model.Place;
import com.example.nguyenho.davisbnb.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlaceService {
    private final PlaceRepository placeRepository;
    private final AuthService authService;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public void createPlace(Place place) {
        place.setOwner(authService.getCurrentUser());
        placeRepository.save(place);
        logger.info("Create place successfully");
    }

    public Optional<Place> getPlaceById(String placeId) {
        return placeRepository.findById(placeId);
    }

    public List<Place> getPlaceByUser(String userId) {
        return placeRepository.findByOwnerId(userId);
    }

    public void updatePlaceById(String placeId, Place updatePlace) {
        Optional<Place> place = placeRepository.findById(placeId);

        if (place.isEmpty()) {
            throw new NotFoundResourceException("Place ID is not found");
        }

        Place foundPlace = place.get();
        if (!foundPlace.getOwner().getId().equals(authService.getCurrentUser().getId())) {
            throw new UserNotAuthorizedException("Not authorized to update the place");
        }
        if (updatePlace.getType() != null) foundPlace.setType(updatePlace.getType());
        if (updatePlace.getDescription() != null) foundPlace.setDescription(updatePlace.getDescription());
        if (updatePlace.getPrice() != null) foundPlace.setPrice(updatePlace.getPrice());
        placeRepository.save(updatePlace);
        logger.info("Update place successfully");
    }

    public void deletePlaceById(String placeId) {
        Optional<Place> place = placeRepository.findById(placeId);
        if (place.isEmpty()) {
            throw new NotFoundResourceException("Place ID is not found");
        }

        if (!place.get().getOwner().getId().equals(authService.getCurrentUser().getId())) {
            throw new UserNotAuthorizedException("Not authorized to delete the place");
        }
        placeRepository.deleteById(placeId);
        logger.info("Delete place successfully");
    }
}
