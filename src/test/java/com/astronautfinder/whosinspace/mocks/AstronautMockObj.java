package com.astronautfinder.whosinspace.mocks;

import com.astronautfinder.whosinspace.models.AstronautsInboundDTO;
import com.astronautfinder.whosinspace.models.ClientAstronautDTO;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.mock;
// Mock an astronaut object and return it.
public class AstronautMockObj {
    private AstronautsInboundDTO astronautsInboundDTO;

    public AstronautMockObj(){
        this.astronautsInboundDTO = createMockedObject();
    }
    // mock creation
    public AstronautsInboundDTO createMockedObject(){
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

    public AstronautsInboundDTO getAstronautsInboundDTO() {
        return astronautsInboundDTO;
    }
}
