package com.astronautfinder.whosinspace.Interface;

import com.astronautfinder.whosinspace.Model.AstronautsInboundDTO;
import com.astronautfinder.whosinspace.Model.ClientAstronautDTO;
import com.astronautfinder.whosinspace.Utils.CraftNotAvailableException;
import com.astronautfinder.whosinspace.Utils.NoAstronautFoundException;

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
