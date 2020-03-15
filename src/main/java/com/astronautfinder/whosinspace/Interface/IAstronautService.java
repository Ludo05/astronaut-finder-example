package com.astronautfinder.whosinspace.Interface;

import com.astronautfinder.whosinspace.Model.AstronautInboundDTO;
import com.astronautfinder.whosinspace.Model.ClientAstronautDTO;
import com.astronautfinder.whosinspace.Utils.NoAstronautFoundException;

import java.util.List;

public interface IAstronautService {

    AstronautInboundDTO getAllAstronauts();
    int getNumberOfAstronauts() throws NoAstronautFoundException;
    List<ClientAstronautDTO> getAstronautsArray();
    List<ClientAstronautDTO> getAstronautsArrayOrderedNames();
    List<String> getAstronautNames();
    List<String> getAstronautCraft();
    String getAstronautCraftByName(String name);
    List<String> getAstronautsByCraft(String craft);
    String addCraft(ClientAstronautDTO astronaut);
    List<ClientAstronautDTO> getAstronautsFromLocal();


}
