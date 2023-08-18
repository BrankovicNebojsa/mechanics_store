package com.mechanics_store.service;

import com.mechanics_store.exception.EntityNotFoundException;
import com.mechanics_store.logging.Logger;
import com.mechanics_store.model.Brand;
import com.mechanics_store.repository.BrandRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * Contains business logic for a Brand class
 *
 * Class that's used to control and manipulate data related to brand class.
 * Enables creating, reading, updating and deleting a user.
 *
 * @author Nebojsa Brankovic
 */
@Service
public class BrandService {

    private final BrandRepository brandRepository;

    private final Logger logger;

    public BrandService(BrandRepository brandRepository, Logger logger) {
        this.brandRepository = brandRepository;
        this.logger = logger;
    }

    public Brand save(Brand brand) {
        return brandRepository.save(brand);
    }

    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    public Brand update(Brand brand) {
        brandRepository.findById(brand.getId()).ifPresent(brandRepository::save);
        return brandRepository.save(brand);
    }

    public boolean delete(Long id) {
        Optional<Brand> optionalBrand = brandRepository.findById(id);
        if (optionalBrand.isPresent()) {
            brandRepository.deleteById(id);
            logger.info("Deleted a brand with an id: " + id);
            return true;
        }
        logger.error(new EntityNotFoundException("Didn't found a brand with an id: " + id));
        return false;
    }
}
