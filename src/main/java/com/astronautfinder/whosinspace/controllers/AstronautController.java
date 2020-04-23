package com.astronautfinder.whosinspace.controllers;

import com.astronautfinder.whosinspace.models.AstronautsInboundDTO;
import com.astronautfinder.whosinspace.models.ClientAstronautDTO;
import com.astronautfinder.whosinspace.services.AstronautServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/astronauts")
public class AstronautController {

    private final AstronautServiceImpl astronautService;

    public AstronautController(AstronautServiceImpl astronautService) {
        this.astronautService = astronautService;
    }


    @GetMapping("")
    public AstronautsInboundDTO getAstronauts() {
        return astronautService.getAllAstronauts();
    }

    @GetMapping("/amount")
    public int getNumberOfAstronauts() {
        return astronautService.getNumberOfAstronauts();
    }

    @GetMapping("/all/ordered")
    public List<ClientAstronautDTO> getAstronautsArrayOrderedNames() {
        return astronautService.getAstronautsArrayOrderedNames();
    }
}

