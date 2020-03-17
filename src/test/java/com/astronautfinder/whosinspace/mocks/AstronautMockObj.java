package com.astronautfinder.whosinspace.mocks;

import com.astronautfinder.whosinspace.models.AstronautsInboundDTO;
import com.astronautfinder.whosinspace.models.ClientAstronautDTO;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.mock;

public class AstronautMockObj {


    public AstronautsInboundDTO returnMockedObject(){
        // mock creation
        AstronautsInboundDTO mockedAstronaut = mock(AstronautsInboundDTO.class);
        List<ClientAstronautDTO> astronautDTOList = new ArrayList<>();
        astronautDTOList.add(new ClientAstronautDTO("ISS","TestOne"));
        astronautDTOList.add(new ClientAstronautDTO("ISS","TestTwo"));
        astronautDTOList.add(new ClientAstronautDTO("ISS","TestThree"));
        mockedAstronaut.setMessage("success");
        mockedAstronaut.setNumber(2);
        mockedAstronaut.setPeople(astronautDTOList);
        return mockedAstronaut;
    }
}
