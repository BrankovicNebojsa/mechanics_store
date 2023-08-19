package com.mechanics_store.service;

import com.mechanics_store.model.Brand;
import com.mechanics_store.model.Model;
import com.mechanics_store.repository.ModelRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * Contains business logic for a Model class
 *
 * Class that's used to control and manipulate data related to model class.
 * Enables creating, reading, updating and deleting a model.
 *
 * @author Nebojsa Brankovic
 */
@Service
public class ModelService {

    private final ModelRepository modelRepository;

    private final BrandService brandService;

    public ModelService(ModelRepository modelRepository, BrandService brandService) {
        this.modelRepository = modelRepository;
        this.brandService = brandService;
    }

    public Model save(Model model) {
        Optional<Brand> brand = brandService.findByName(model.getBrand().getName());
        if (brand.isEmpty()) {
            brandService.save(model.getBrand());
        } else {
            model.getBrand().setId(brand.get().getId());
        }
        return modelRepository.save(model);
    }

    public List<Model> findAll() {
        return modelRepository.findAll();
    }

    public Model update(Model model) {
        modelRepository.findById(model.getId()).ifPresent(modelRepository::save);
        return modelRepository.save(model);
    }

    public boolean delete(Long id) {
        Optional<Model> optionalModel = modelRepository.findById(id);
        if (optionalModel.isPresent()) {
            modelRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
