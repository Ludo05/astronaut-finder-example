package com.astronautfinder.whosinspace.interfaces;

import com.astronautfinder.whosinspace.models.AstronautsInboundDTO;
import com.astronautfinder.whosinspace.models.ClientAstronautDTO;
import com.astronautfinder.whosinspace.utils.CraftNotAvailableException;
import com.astronautfinder.whosinspace.utils.NoAstronautFoundException;

import java.util.List;

public interface IAstronautService {

    AstronautsInboundDTO getAllAstronauts();
    int getNumberOfAstronauts() throws NoAstronautFoundException;
    List<ClientAstronautDTO> getAstronautsArray() throws Exception;
    List<ClientAstronautDTO> getAstronautsArrayOrderedNames();
    List<String> getAstronautNames();
    List<String> getAstronautCraft();
    String getAstronautCraftByName(String name);
    List<String> getAstronautsByCraft(String craft) throws CraftNotAvailableException;
    String addCraft(ClientAstronautDTO astronaut);
    List<ClientAstronautDTO> getAstronautsFromLocal();


}
