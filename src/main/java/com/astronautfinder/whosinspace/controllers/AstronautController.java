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
    public int getNumberOfAstronauts()  {
        return astronautService.getNumberOfAstronauts();
    }

    @GetMapping("/all")
    public List<ClientAstronautDTO> getAstronautsArray() {
        return astronautService.getAstronautsArray();
    }

    @GetMapping("/all/ordered")
    public List<ClientAstronautDTO> getAstronautsArrayOrderedNames() {
        return astronautService.getAstronautsArrayOrderedNames();
    }

    @GetMapping("/names")
    public List<String> getAstronautNames() {
        return astronautService.getAstronautNames();
    }

    @GetMapping("/craft")
    public List<String> getAstronautCraft() {
        return astronautService.getAstronautCraft();
    }

    @GetMapping("/name/craft")
    public String getAstronautCraftByName(@RequestParam(value = "name") String name) {
        return astronautService.getAstronautCraftByName(name);
    }

    @GetMapping("/craft-name")
    public List<String> getAstronautsByCraft(@RequestParam(value = "craft", defaultValue = "ISS") String craft) {
        return astronautService.getAstronautsByCraft(craft);
    }

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/text")
    public String addCraft(ClientAstronautDTO astronaut){
        return astronautService.addCraft(astronaut);
    }

    @GetMapping("/load-local")
    public List<ClientAstronautDTO> getAstronautsFromLocal() {
        return astronautService.getAstronautsFromLocal();
    }
}


