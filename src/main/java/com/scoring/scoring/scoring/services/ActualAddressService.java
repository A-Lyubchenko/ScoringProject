package com.scoring.scoring.scoring.services;

import com.scoring.scoring.scoring.domain.ActualAddress;
import com.scoring.scoring.scoring.repositories.ActualAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ActualAddressService implements Crud<ActualAddress>{

    @Autowired
    private ActualAddressRepository actualAddressRepository;

    @Override
    public ActualAddress save(ActualAddress actualAddress) {
        return actualAddressRepository.save(actualAddress);
    }

    @Override
    public List<ActualAddress> getAll() {
        return actualAddressRepository.findAll();
    }

    @Override
    public ActualAddress update(ActualAddress actualAddress) {
        return actualAddressRepository.save(actualAddress);
    }

    @Override
    public void delete(ActualAddress actualAddress) {
        actualAddressRepository.delete(actualAddress);
    }

    @Override
    public ActualAddress getById(UUID id) {
        Optional<ActualAddress> byId = actualAddressRepository.findById(id);
        return byId.orElse(null);
    }
}
