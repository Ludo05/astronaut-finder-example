package com.astronautfinder.whosinspace;
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
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void AddAstronautTest(){
        ClientAstronautDTO clientAstronautDTO = new ClientAstronautDTO("TestCraft","TestName");
        Mockito
                .when(restTemplate.getForEntity("http://localhost:9090/astronaut/add", ClientAstronautDTO.class))
                .thenReturn(new ResponseEntity(clientAstronautDTO, HttpStatus.OK));

       String result = astronautService.getNumberOfAstronauts();
       System.out.println(result);
       assertEquals("Success",result);
    }

    @Test
    public void GetAstronautCraftTest(){
        List<String> result = astronautService.getAstronautCraft();
        assertEquals(new ArrayList<String>(){{
            add("ISS");
            add("ISS");
            add("ISS");
        }}
        ,result);
    }

    @Test
    public void getNumberOfAstronauts(){
        int result = astronautService.getNumberOfAstronauts();
        assertEquals(2,result);

    }

    @Test
    public void getAstronautsArrayOrderedNames(){
        List<ClientAstronautDTO> result = astronautService.getAstronautsArrayOrderedNames();;
        assertEquals(3,result.size());

    }

    @Test
    public void getAstronautNames(){
        List<String> result = astronautService.getAstronautNames();
        assertEquals(new ArrayList<String>(){{
            add("TestOne");
            add("TestTwo");
            add("TestThree");
        }},result);
    }

//    @Test
//    public void getAstronautsByCraftNameException() {
//        List<String> result = astronautService.getAstronautsByCraft("NOCRAFT");
//        Assertions.assertThrows(CraftNotAvailableException.class, (Executable) result);
//    }
//
 }
