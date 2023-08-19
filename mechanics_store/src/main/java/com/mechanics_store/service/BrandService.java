package com.mechanics_store.service;

import com.mechanics_store.model.Brand;
import com.mechanics_store.repository.BrandRepository;
import java.sql.SQLIntegrityConstraintViolationException;
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

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public Brand save(Brand brand) {
        return brandRepository.save(brand);
    }

    public Optional<Brand> findById(Long id) {
        return brandRepository.findById(id);
    }

    public Optional<Brand> findByName(String name) {
        return brandRepository.findByName(name);
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
            return true;
        }
        return false;
    }
}
