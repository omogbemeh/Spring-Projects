package icu.praise.petclinic.controllers;

import icu.praise.petclinic.services.map.MapImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({ "pets", "pets.html"})
public class PetController {
    private final MapImpl petMapServiceImpl;

    public PetController(MapImpl petMapServiceImpl) {
        this.petMapServiceImpl = petMapServiceImpl;
    }

    @GetMapping("")
    public String displayPets(Model model) {
        model.addAttribute("pets", petMapServiceImpl.findAll());
        return "pets";
    }
}
