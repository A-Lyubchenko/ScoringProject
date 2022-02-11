package com.scoring.scoring.scoring.controllers;

import com.scoring.scoring.scoring.domain.Person;
import com.scoring.scoring.scoring.services.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Slf4j
@Controller
@RequestMapping("persons")
public class PersonController {

    @Autowired
    private PersonService personService;


    @GetMapping()
    public String read(Model model){
        model.addAttribute("persons",personService.getAll());
        return "person/read";
    }

    @GetMapping("{id}")
    public String get(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("person", personService.getById(id));
        return "person/get";

    }
    @GetMapping("new")
    public String getCreatePage(@ModelAttribute("person") Person person){
        return "person/create";
    }

    @PostMapping()
    public String create(@Valid Person person, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "person/create";
        }

        personService.save(person);
        return "redirect:persons";
    }

    @GetMapping("{id}/update")
    public String getUpdatePage(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("person", personService.getById(id));
        return "person/update";
    }

    @PatchMapping()
    public String update(@Valid Person person, BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return "person/update";

        personService.update(person);
        return "person/get";

    }

    @DeleteMapping("{id}/delete")
    public String delete(@PathVariable("id") UUID uuid) {
        personService.delete(personService.getById(uuid));
        return "redirect:/persons";
    }
}
