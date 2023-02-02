package icu.praise.petclinic.controllers;

import icu.praise.petclinic.services.map.MapService;
import icu.praise.petclinic.services.map.PetMapService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({ "pets", "pets.html"})
public class PetController {
    private final MapService petMapService;

    public PetController(MapService petMapService) {
        this.petMapService = petMapService;
    }

    @GetMapping("")
    public String displayPets(Model model) {
        model.addAttribute("pets", petMapService.findAll());
        return "pets";
    }
}
