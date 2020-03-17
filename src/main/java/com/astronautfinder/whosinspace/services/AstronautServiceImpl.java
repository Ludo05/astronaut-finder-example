package com.astronautfinder.whosinspace.services;

import com.astronautfinder.whosinspace.interfaces.IAstronautService;
import com.astronautfinder.whosinspace.models.AstronautsInboundDTO;
import com.astronautfinder.whosinspace.models.ClientAstronautDTO;
import com.astronautfinder.whosinspace.utils.CraftNotAvailableException;
import com.astronautfinder.whosinspace.utils.NoAstronautFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class AstronautServiceImpl implements IAstronautService {

//    @Value("${api.url}")
    final String URL = "http://api.open-notify.org/astros.json";
    RestTemplate restTemplate = new RestTemplate();
    List<ClientAstronautDTO> astronauts = new ArrayList<>();

    private AstronautsInboundDTO getAstronautObject() {
        return restTemplate.getForObject(URL, AstronautsInboundDTO.class);
    }

    public AstronautsInboundDTO getAllAstronauts(){
       return this.getAstronautObject();
    }

    public int getNumberOfAstronauts() throws NoAstronautFoundException {
        AstronautsInboundDTO astronautsInboundDTO = getAstronautObject();
        if(astronautsInboundDTO != null){
            return astronautsInboundDTO.getNumber();
        } else {
            throw new NoAstronautFoundException("Object returned null");
        }
    }

    public List<ClientAstronautDTO> getAstronautsArray() throws CraftNotAvailableException {
        AstronautsInboundDTO astronautsInboundDTO = getAstronautObject();
        if(astronautsInboundDTO != null){
        return astronautsInboundDTO.getPeople();
        } else {
            throw new CraftNotAvailableException("Where is my array");
        }
    }

    public List<ClientAstronautDTO> getAstronautsArrayOrderedNames() {
        AstronautsInboundDTO astronautsInboundDTO = getAstronautObject();
        assert astronautsInboundDTO != null;
        List<ClientAstronautDTO> astronautDTOList = astronautsInboundDTO.getPeople();
        astronautDTOList.sort(Comparator.comparing(ClientAstronautDTO::getLastName));
        return astronautDTOList;
    }


    public List<String> getAstronautNames(){
        List<String> names = new ArrayList<>();
        AstronautsInboundDTO astronautsInboundDTO = getAstronautObject();
        assert astronautsInboundDTO != null;
        astronautsInboundDTO.getPeople().forEach(astronaut -> names.add(astronaut.getName()));
        return names;
    }

    public List<String> getAstronautCraft(){
        List<String> names = new ArrayList<>();
        AstronautsInboundDTO astronautsInboundDTO = getAstronautObject();
        assert astronautsInboundDTO != null;
        astronautsInboundDTO.getPeople().forEach(astronaut -> names.add(astronaut.getCraft()));
        return names;
    }

    public String getAstronautCraftByName(String name){
        AstronautsInboundDTO astronautsInboundDTO = getAstronautObject();
        assert astronautsInboundDTO != null;
        AtomicReference<String> craft = new AtomicReference<>("");
        astronautsInboundDTO.getPeople().forEach(astronaut -> {
            if(astronaut.getName().equals(name)){
                craft.set(astronaut.getCraft());
            }
        });
        return craft.get();
    }

    public List<String> getAstronautsByCraft(String craft) throws CraftNotAvailableException {
        List<String> names = new ArrayList<>();
        AstronautsInboundDTO astronautsInboundDTO = getAstronautObject();
        if(astronautsInboundDTO == null) {
            throw new CraftNotAvailableException("Craft not found.");
        } else {
            astronautsInboundDTO.getPeople().forEach(astronaut -> {
                if (astronaut.getCraft().equals(craft)) {
                    names.add(astronaut.getName());
                }
            });
            return names;
        }
    }

    public String addCraft(ClientAstronautDTO astronaut) {
        astronauts.add(astronaut);
        return "Success";
    }

    public List<ClientAstronautDTO> getAstronautsFromLocal(){
        return astronauts;
    }
}
