package com.scoring.scoring.scoring.controllers;

import com.scoring.scoring.exception.NoSuchEntityException;
import com.scoring.scoring.scoring.domain.Address;
import com.scoring.scoring.scoring.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/address")
    public List<Address> read() {
        return addressService.getAll();

    }

    @GetMapping("/address/{id}")
    public Address get(@PathVariable("id") UUID uuid) {
        Address address = addressService.getById(uuid);

        if (address == null) {
            throw new NoSuchEntityException("There is no address with id " + uuid + " in DataBase");
        }

        return addressService.getById(uuid);

    }

    @PostMapping("/address")
    public Address create(@RequestBody Address address) {
        return addressService.save(address);
    }


    @PatchMapping("/address")
    public Address update(@RequestBody Address address) {
        return addressService.save(address);
    }

    @DeleteMapping("/address/{id}")
    public String delete(@PathVariable("id") UUID uuid) {
        Address address = addressService.getById(uuid);

        if (address == null) {
            throw new NoSuchEntityException("There is no address with id " + uuid + " in DataBase");

        }

        addressService.delete(addressService.getById(uuid));

        return "Address with id  = " + uuid + " was deleted";
    }
}
