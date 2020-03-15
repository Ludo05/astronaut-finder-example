package com.astronautfinder.whosinspace.Service;

import com.astronautfinder.whosinspace.Interface.IAstronautService;
import com.astronautfinder.whosinspace.Model.AstronautInboundDTO;
import com.astronautfinder.whosinspace.Model.ClientAstronautDTO;
import com.astronautfinder.whosinspace.Utils.NoAstronautFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class AstronautServiceImpl implements IAstronautService {

//    @Value("http://api.open-notify.org/astros.json")
    final String URL = "http://api.open-notify.org/astros.json";
    RestTemplate restTemplate = new RestTemplate();
    List<ClientAstronautDTO> astronauts = new ArrayList<>();

    private AstronautInboundDTO getAstronautObject() {
        return restTemplate.getForObject(URL, AstronautInboundDTO.class);
    }

    public AstronautInboundDTO getAllAstronauts(){
       return this.getAstronautObject();
    }

    public int getNumberOfAstronauts() throws NoAstronautFoundException {
        AstronautInboundDTO object = getAstronautObject();
        if(object != null){
            return object.getNumber();
        } else {
            throw new NoAstronautFoundException("Object returned null");
        }
    }

    public List<ClientAstronautDTO> getAstronautsArray() {
        AstronautInboundDTO object = getAstronautObject();
        assert object != null;
        return object.getPeople();
    }

    public List<ClientAstronautDTO> getAstronautsArrayOrderedNames() {
        AstronautInboundDTO object = getAstronautObject();
        assert object != null;
        List<ClientAstronautDTO> astronautDTOList = object.getPeople();
        astronautDTOList.sort(Comparator.comparing(ClientAstronautDTO::getLastName));
        return astronautDTOList;
    }


    public List<String> getAstronautNames(){
        List<String> names = new ArrayList<>();
        AstronautInboundDTO object = getAstronautObject();
        assert object != null;
        object.getPeople().forEach(astronaut -> names.add(astronaut.getName()));
        return names;
    }

    public List<String> getAstronautCraft(){
        List<String> names = new ArrayList<>();
        AstronautInboundDTO object = getAstronautObject();
        assert object != null;
        object.getPeople().forEach(astronaut -> names.add(astronaut.getCraft()));
        return names;
    }

    public String getAstronautCraftByName(String name){
        AstronautInboundDTO object = getAstronautObject();
        assert object != null;
        AtomicReference<String> craft = new AtomicReference<>("");
        object.getPeople().forEach(astronaut -> {
            if(astronaut.getName().equals(name)){
                craft.set(astronaut.getCraft());
            }
        });
        return craft.get();
    }

        public List<String> getAstronautsByCraft(String craft){
        List<String> names = new ArrayList<>();
        AstronautInboundDTO object = getAstronautObject();
        assert object != null;
        object.getPeople().forEach(astronaut -> {
            if(astronaut.getCraft().equals(craft)){
                names.add(astronaut.getName());
            }
        });
        return names;
    }

    public String addCraft(ClientAstronautDTO astronaut) {
        astronauts.add(astronaut);
        return "Success";
    }

    public List<ClientAstronautDTO> getAstronautsFromLocal(){
        return astronauts;
    }
}
