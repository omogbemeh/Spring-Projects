package icu.praise.petclinic.controllers;

import icu.praise.petclinic.model.Owner;
import icu.praise.petclinic.services.map.MapService;
import icu.praise.petclinic.services.map.OwnerMapService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("owners")
public class OwnerController {

    private final MapService ownerMapService;

    public OwnerController(MapService ownerMapService) {
        this.ownerMapService = ownerMapService;
    }

    @GetMapping("")
    public String displayOwnerPage(Model model) {
        model.addAttribute("owners", ownerMapService.findAll());
        return "owner";
    }

}
