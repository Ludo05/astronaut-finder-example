package com.astronautfinder.whosinspace;
import com.astronautfinder.whosinspace.models.ClientAstronautDTO;
import com.astronautfinder.whosinspace.services.AstronautServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


@ExtendWith(MockitoExtension.class)
public class AstronautServiceTest {


    @Mock
    RestTemplate restTemplate;

    private AstronautServiceImpl astronautService;

    @BeforeEach
     void beforeAllTest() {
          astronautService = new AstronautServiceImpl(restTemplate);
    }

    @Test
    public void getAstronautsArrayOrderedNames(){
        ClientAstronautDTO one = new ClientAstronautDTO("ISS","Alpha");
        ClientAstronautDTO two = new ClientAstronautDTO("ISS","Delta");
        ClientAstronautDTO three = new ClientAstronautDTO("ISS","Bravo");
        ClientAstronautDTO four = new ClientAstronautDTO("ISS","Zulu");

        List<ClientAstronautDTO> list = Arrays.asList(one,three,two,four);
                Mockito
                .when(restTemplate.getForEntity("http://localhost:9090/astronauts/all/ordered", ClientAstronautDTO.class))
                .thenReturn(new ResponseEntity(list, HttpStatus.OK));

        List<ClientAstronautDTO> result = astronautService.getAstronautsArrayOrderedNames();

    }



//    @Test
//    public void getAstronautsByCraftNameException() {
//        List<String> result = astronautService.getAstronautsByCraft("NOCRAFT");
//        Assertions.assertThrows(CraftNotAvailableException.class, (Executable) result);
//    }
//
 }
