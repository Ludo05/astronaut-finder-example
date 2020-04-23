package com.astronautfinder.whosinspace.services;

import com.astronautfinder.whosinspace.interfaces.IAstronautService;
import com.astronautfinder.whosinspace.models.AstronautsInboundDTO;
import com.astronautfinder.whosinspace.models.ClientAstronautDTO;
import com.astronautfinder.whosinspace.utils.CraftNotAvailableException;
import com.astronautfinder.whosinspace.utils.NoAstronautFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AstronautServiceImpl implements IAstronautService {

    @Value("${api.url}")
    String URL;

    @Resource
    private RestTemplate restTemplate;


    public AstronautServiceImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public AstronautsInboundDTO getAstronautObject() {
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

    public List<ClientAstronautDTO> getAstronautsArrayOrderedNames() {
        AstronautsInboundDTO astronautsInboundDTO = getAstronautObject();
        assert astronautsInboundDTO != null;
        List<ClientAstronautDTO> astronautDTOList = astronautsInboundDTO.getPeople();
        System.out.println(astronautDTOList.size());
        astronautDTOList.sort(Comparator.comparing(ClientAstronautDTO::getLastName));
        return astronautDTOList;
    }

}
