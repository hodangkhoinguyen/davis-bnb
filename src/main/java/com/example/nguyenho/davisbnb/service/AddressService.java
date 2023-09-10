package com.example.nguyenho.davisbnb.service;

import com.example.nguyenho.davisbnb.exception.NotFoundResourceException;
import com.example.nguyenho.davisbnb.exception.UserNotAuthorizedException;
import com.example.nguyenho.davisbnb.model.Address;
import com.example.nguyenho.davisbnb.model.Amenity;
import com.example.nguyenho.davisbnb.model.Place;
import com.example.nguyenho.davisbnb.repository.AddressRepository;
import com.example.nguyenho.davisbnb.repository.AmenityRepository;
import com.example.nguyenho.davisbnb.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final PlaceRepository placeRepository;
    private final AuthService authService;
    private final AddressRepository addressRepository;
    private final AmenityRepository amenityRepository;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public void updateAddress(String placeId, String addressId, Address updateAddress) {
        Optional<Place> place = placeRepository.findById(placeId);
        Optional<Address> address = addressRepository.findById(addressId);

        if (place.isEmpty() || address.isEmpty()) {
            throw new NotFoundResourceException("Place or address IDs not found");
        }

        Place foundPlace = place.get();
        Address foundAddress = address.get();

        if (!foundPlace.getAddress().getId().equals(foundAddress.getId())) {
            throw new NotFoundResourceException("Address doesn't belong to place");
        }

        if (!foundPlace.getOwner().getId().equals(authService.getCurrentUser().getId())) {
            throw new UserNotAuthorizedException("Not authorized to update the address");
        }

        if (updateAddress.getLatitude() != null) foundAddress.setLatitude(updateAddress.getLatitude());
        if (updateAddress.getLongitude() != null) foundAddress.setLongitude(updateAddress.getLongitude());
        if (updateAddress.getStreet() != null) foundAddress.setStreet(updateAddress.getStreet());
        if (updateAddress.getCity() != null) foundAddress.setCity(updateAddress.getCity());
        if (updateAddress.getState() != null) foundAddress.setState(updateAddress.getState());
        if (updateAddress.getZipcode() != null) foundAddress.setZipcode(updateAddress.getZipcode());

        addressRepository.save(foundAddress);
        logger.info("Update address successfully");
    }

    public void updateAmenity(String placeId, String amenityId, Amenity updateAmenity) {
        Optional<Place> place = placeRepository.findById(placeId);
        Optional<Amenity> amenity = amenityRepository.findById(amenityId);

        if (place.isEmpty() || amenity.isEmpty()) {
            throw new NotFoundResourceException("Place or address IDs not found");
        }

        Place foundPlace = place.get();
        Amenity foundAmenity = amenity.get();

        if (!foundPlace.getAmenity().getId().equals(foundAmenity.getId())) {
            throw new NotFoundResourceException("Amenity doesn't belong to place");
        }

        if (!foundPlace.getOwner().getId().equals(authService.getCurrentUser().getId())) {
            throw new UserNotAuthorizedException("Not authorized to update the amenity");
        }

        if (updateAmenity.getNum_bedroom() != null) foundAmenity.setNum_bedroom(updateAmenity.getNum_bedroom());
        if (updateAmenity.getNum_bathroom() != null) foundAmenity.setNum_bathroom(updateAmenity.getNum_bathroom());
        foundAmenity.setHasTV(updateAmenity.isHasTV());
        foundAmenity.setHasInternet(updateAmenity.isHasInternet());
        foundAmenity.setHasAC(updateAmenity.isHasAC());
        foundAmenity.setHasHeat(updateAmenity.isHasHeat());
        foundAmenity.setHasParking(updateAmenity.isHasParking());

        amenityRepository.save(foundAmenity);
        logger.info("Update amenity successfully");
    }
}
