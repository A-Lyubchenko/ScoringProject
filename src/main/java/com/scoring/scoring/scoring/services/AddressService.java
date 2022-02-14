package com.scoring.scoring.scoring.services;

import com.scoring.scoring.scoring.domain.Address;
import com.scoring.scoring.scoring.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AddressService implements Crud<Address> {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address update(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public void delete(Address address) {
        addressRepository.delete(address);
    }

    @Override
    public Address getById(UUID id) {
        Optional<Address> byId = addressRepository.findById(id);
        return byId.orElse(null);
    }
}
