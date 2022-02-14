package com.scoring.scoring.scoring.controllers;

import com.scoring.scoring.exception.NoSuchEntityException;
import com.scoring.scoring.scoring.domain.AdditionalContact;
import com.scoring.scoring.scoring.services.AdditionalContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AdditionalContactController {

    @Autowired
    private AdditionalContactService additionalContactService;


    @GetMapping("/contacts")
    public List<AdditionalContact> read() {
        return additionalContactService.getAll();

    }

    @GetMapping("/contacts/{id}")
    public AdditionalContact get(@PathVariable("id") UUID uuid) {
        AdditionalContact additionalContact = additionalContactService.getById(uuid);

        if (additionalContact == null) {
            throw new NoSuchEntityException("There is no additionalContact with id " + uuid + " in DataBase");
        }

        return additionalContactService.getById(uuid);

    }

    @PostMapping("/contacts")
    public AdditionalContact create(@RequestBody AdditionalContact contact) {
        return additionalContactService.save(contact);
    }


    @PatchMapping()
    public AdditionalContact update(@RequestBody AdditionalContact contact) {
        return additionalContactService.save(contact);
    }

    @DeleteMapping("/contacts/{id}")
    public String delete(@PathVariable("id") UUID uuid) {
        AdditionalContact additionalContact = additionalContactService.getById(uuid);

        if (additionalContact == null) {
            throw new NoSuchEntityException("There is no additionalContact with id " + uuid + " in DataBase");
        }

        additionalContactService.delete(additionalContactService.getById(uuid));

        return "Person with id  = " + uuid + " was deleted";
    }
}
