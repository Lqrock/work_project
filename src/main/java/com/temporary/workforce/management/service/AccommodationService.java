package com.temporary.workforce.management.service;

import com.temporary.workforce.management.dto.AccommodationDTO;
import com.temporary.workforce.management.exception.BusinessException;
import com.temporary.workforce.management.model.Accommodation;
import com.temporary.workforce.management.model.Room;
import com.temporary.workforce.management.repository.AccommodationRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccommodationService implements AccommodationServiceInterface {

    @Autowired
    AccommodationRepository accommodationRepository;

    ModelMapper modelMapper = new ModelMapper();
    Logger logger = LoggerFactory.getLogger(AccommodationService.class);

    @Override
    public void createAccommodation(AccommodationDTO accommodationDTO) {

        logger.info("Starting accommodation creation");
        Accommodation accommodation = modelMapper.map(accommodationDTO, Accommodation.class);
        if ( accommodation.getFloors() != null) {
            accommodation.getFloors().forEach(floor -> {
                floor.setAccommodation(accommodation);
                if (floor.getRooms() != null) {
                    floor.getRooms().forEach(room -> room.setFloor(floor));
                    for (Room room:floor.getRooms()){
                        if (room.getFurniture() != null) {
                            room.getFurniture().forEach(furniture -> furniture.setRoom(room));
                            room.getFurniture().forEach(furniture -> furniture.setAccommodation(accommodation));
                        }
                    }
                }
            });
        }
        if (accommodation.getUtilities() != null) {
            accommodation.getUtilities().forEach(utility -> utility.setAccommodation(accommodation));
        }
        if (accommodation.getFurniture() != null) {
            accommodation.getFurniture().forEach(furniture -> furniture.setAccommodation(accommodation));
        }

        accommodationRepository.save(accommodation);
        logger.info("Accommodation created successfully: {}", accommodation.getId());
    }

    @Override
    public AccommodationDTO updateAccommodation(AccommodationDTO accommodationDTO) throws BusinessException {

        logger.info("Updating accommodation {}", accommodationDTO.getId());
        Optional<Accommodation> existingAccommodationOpt = accommodationRepository.findById(accommodationDTO.getId());
        throwExceptionIfAccommodationNotFound(existingAccommodationOpt, accommodationDTO.getId());
        Accommodation existingAccommodation = modelMapper.map(accommodationDTO, Accommodation.class);
        if (!existingAccommodation.getFloors().isEmpty()) {
            existingAccommodation.getFloors().forEach(floor -> {
                floor.setAccommodation(existingAccommodation);
                if (!floor.getRooms().isEmpty()) {
                    floor.getRooms().forEach(room -> room.setFloor(floor));
                }
            });
        }
        if (!existingAccommodation.getUtilities().isEmpty()) {
            existingAccommodation.getUtilities().forEach(utility -> utility.setAccommodation(existingAccommodation));
        }
        accommodationRepository.save(existingAccommodation);
        logger.info("Accommodation updated");
        return modelMapper.map(existingAccommodation, AccommodationDTO.class);

    }

    @Override
    public void deleteAccommodation(int accommodationId) throws BusinessException {
        logger.info("Deleting accommodation");
        Optional<Accommodation> accommodation = accommodationRepository.findById(accommodationId);
        throwExceptionIfAccommodationNotFound(accommodation, accommodationId);
        accommodationRepository.deleteById(accommodationId);
        logger.info("Accommodation deleted");
    }

    @Override
    public AccommodationDTO getAccommodationDTO(int accommodationId) throws BusinessException {
        logger.info("Retrieving accommodationDTO");
        Optional<Accommodation> accommodation = accommodationRepository.findById(accommodationId);
        throwExceptionIfAccommodationNotFound(accommodation, accommodationId);
        return modelMapper.map(accommodation, AccommodationDTO.class);
    }

    @Override
    public Optional<Accommodation> getAccommodation(int accommodationId) throws BusinessException {
        logger.info("Retrieving accommodation");
        Optional<Accommodation> accommodation = accommodationRepository.findById(accommodationId);
        throwExceptionIfAccommodationNotFound(accommodation, accommodationId);
        return accommodation;
    }

    @Override
    public List<AccommodationDTO> getAllAccommodations() {
        List<Accommodation> accommodations = accommodationRepository.findAll();
        List<AccommodationDTO> accommodationDTOList = new ArrayList<>();
        accommodations.forEach(accommodation -> accommodationDTOList.add(modelMapper.map(accommodation, AccommodationDTO.class)));
        return accommodationDTOList;
    }


    private void throwExceptionIfAccommodationNotFound(Optional<Accommodation> accommodation, int accommodationId) throws BusinessException {
        if (accommodation.isEmpty()) {
            throw new BusinessException("Accommodation with ID " + accommodationId + " not found.");
        }
    }


}
