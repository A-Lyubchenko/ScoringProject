package com.scoring.scoring.scoring.services;

import com.scoring.scoring.scoring.domain.AdditionalContact;
import com.scoring.scoring.scoring.repositories.AdditionalContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AdditionalContactService implements Crud<AdditionalContact>{

    @Autowired
    private AdditionalContactRepository additionalContactRepository;
    @Override
    public AdditionalContact save(AdditionalContact additionalContact) {
        return additionalContactRepository.save(additionalContact);
    }

    @Override
    public List<AdditionalContact> getAll() {
        return additionalContactRepository.findAll();
    }

    @Override
    public AdditionalContact update(AdditionalContact additionalContact) {
        return additionalContactRepository.save(additionalContact);
    }

    @Override
    public void delete(AdditionalContact additionalContact) {
        additionalContactRepository.delete(additionalContact);
    }

    @Override
    public AdditionalContact getById(UUID id) {
        Optional<AdditionalContact> byId = additionalContactRepository.findById(id);
        return byId.orElse(null);
    }
}
