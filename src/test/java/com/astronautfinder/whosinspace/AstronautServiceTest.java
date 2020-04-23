package com.astronautfinder.whosinspace;
import com.astronautfinder.whosinspace.models.AstronautsInboundDTO;
import com.astronautfinder.whosinspace.models.ClientAstronautDTO;
import com.astronautfinder.whosinspace.services.AstronautServiceImpl;
import com.astronautfinder.whosinspace.mocks.AstronautMockObj;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AstronautServiceTest {


    @Mock
    RestTemplate restTemplate;

    private AstronautServiceImpl astronautService;

    @BeforeEach
     void beforeAllTest() {
          astronautService = new AstronautServiceImpl(restTemplate);
          ClientAstronautDTO clientAstronautDTO = new ClientAstronautDTO("TestCraft","Test Zebra");
          ClientAstronautDTO clientAstronautDTO1 = new ClientAstronautDTO("TestCraft","Test Alpha");
          ClientAstronautDTO clientAstronautDTO2 = new ClientAstronautDTO("TestCraft","Test Delta");
          List<ClientAstronautDTO> testListOfAstronauts = new ArrayList<>(Arrays.asList(clientAstronautDTO,clientAstronautDTO1,clientAstronautDTO2));

        AstronautsInboundDTO astronautsInboundDTO = new AstronautsInboundDTO(testListOfAstronauts,"Success",6);
        Mockito.when(astronautService.getAstronautObject())
                .thenReturn(astronautsInboundDTO);
    }

    @Test
    public void GetAstronautsNumberTest(){
       int result = astronautService.getNumberOfAstronauts();
       assertEquals(6,result);
    }

    @Test
    public void GetAstronautsInOrderOfNameTest(){
       List<ClientAstronautDTO> result = astronautService.getAstronautsArrayOrderedNames();
       List<String> resultNames = result.stream().map(ClientAstronautDTO::getLastName).collect(Collectors.toList());
       assertEquals(Arrays.asList("Alpha","Delta","Zebra"),resultNames);
    }
 }
