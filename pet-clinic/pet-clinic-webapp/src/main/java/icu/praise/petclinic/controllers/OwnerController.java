package icu.praise.petclinic.controllers;

import icu.praise.petclinic.services.map.MapImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("owners")
public class OwnerController {

    private final MapImpl ownerMapServiceImpl;

    public OwnerController(MapImpl ownerMapServiceImpl) {
        this.ownerMapServiceImpl = ownerMapServiceImpl;
    }

    @GetMapping("")
    public String displayOwnerPage(Model model) {
        model.addAttribute("owners", ownerMapServiceImpl.findAll());
        return "owner";
    }

}
