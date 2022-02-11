package com.scoring.scoring.scoring.controllers;

import com.scoring.scoring.scoring.domain.ActualAddress;
import com.scoring.scoring.scoring.services.ActualAddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Controller
@Slf4j
@RequestMapping("actualAddress")
public class ActualAddressController {

    @Autowired
    private ActualAddressService actualAddressService;


    @GetMapping()
    public String read(Model model){
        model.addAttribute("actualAdds",actualAddressService.getAll());
        return "actualAddress/read";
    }

    @GetMapping("{id}")
    public String get(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("actualAdd", actualAddressService.getById(id));
        return "actualAddress/get";

    }
    @GetMapping("new")
    public String getCreatePage(@ModelAttribute("actualAdd") ActualAddress actualAddress){
        return "actualAddress/create";
    }

    @PostMapping()
    public String create(@Valid ActualAddress actualAddress, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "actualAddress/create";
        }

        actualAddressService.save(actualAddress);
        return "redirect:actualAddress";
    }

    @GetMapping("{id}/update")
    public String getUpdatePage(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("actualAdd", actualAddressService.getById(id));
        return "actualAddress/update";
    }

    @PatchMapping()
    public String update(@Valid ActualAddress actualAddress, BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return "actualAddress/update";

        actualAddressService.update(actualAddress);
        return "actualAddress/get";

    }

    @DeleteMapping("{id}/delete")
    public String delete(@PathVariable("id") UUID uuid) {
        actualAddressService.delete(actualAddressService.getById(uuid));
        return "redirect:/actualAddress";
    }
}
