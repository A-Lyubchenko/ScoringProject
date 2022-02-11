package com.scoring.scoring.scoring.controllers;

import com.scoring.scoring.scoring.domain.AdditionalContact;
import com.scoring.scoring.scoring.services.AdditionalContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Controller
@RequestMapping("contacts")
public class AdditionalContactController {

    @Autowired
    private AdditionalContactService additionalContactService;


    @GetMapping()
    public String read(Model model){
        model.addAttribute("contacts",additionalContactService.getAll());
        return "additionalContact/read";
    }

    @GetMapping("{id}")
    public String get(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("contact", additionalContactService.getById(id));
        return "additionalContact/get";

    }
    @GetMapping("new")
    public String getCreatePage(@ModelAttribute("contact") AdditionalContact contact){
        return "additionalContact/create";
    }

    @PostMapping()
    public String create(@Valid @ModelAttribute("contact")  AdditionalContact contact, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "additionalContact/create";
        }

        additionalContactService.save(contact);
        return "redirect:contacts";
    }

    @GetMapping("{id}/update")
    public String getUpdatePage(@PathVariable("id") UUID uuid, Model model){
        model.addAttribute("contact",additionalContactService.getById(uuid));
        return "additionalContact/update";
    }

    @PatchMapping()
    public String update(@Valid @ModelAttribute("contact") AdditionalContact contact, BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return "additionalContact/create";


        additionalContactService.save(contact);
        return "redirect:contacts";
    }

    @DeleteMapping("{id}/delete")
    public String delete(@PathVariable("id") UUID uuid) {
        additionalContactService.delete(additionalContactService.getById(uuid));
        return "redirect:/contacts";
    }
}
