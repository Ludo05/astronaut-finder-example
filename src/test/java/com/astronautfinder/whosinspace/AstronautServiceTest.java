package com.astronautfinder.whosinspace;
import com.astronautfinder.whosinspace.models.ClientAstronautDTO;
import com.astronautfinder.whosinspace.services.AstronautServiceImpl;
import com.astronautfinder.whosinspace.mocks.AstronautMockObj;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AstronautServiceTest {

    private AstronautMockObj astronautMockObj;

    @Mock
    private AstronautServiceImpl astronautService;


    public AstronautServiceTest(){
                astronautService = new AstronautServiceImpl();
    }

    @BeforeEach
    public void setUp() {
        astronautMockObj = new AstronautMockObj();
        Mockito.when(astronautService.getAllAstronauts()).thenReturn(astronautMockObj.returnMockedObject());
        Mockito.when(astronautService.addCraft(new ClientAstronautDTO())).thenReturn(astronautMockObj.returnMockedObject().getMessage());
        Mockito.when(astronautService.getNumberOfAstronauts()).thenReturn(astronautMockObj.returnMockedObject().getPeople().size());
        MockitoAnnotations.initMocks(AstronautServiceImpl.class);

    }


    @Test
    public void AddAstronautTest(){
        String result = astronautService.addCraft(new ClientAstronautDTO());
        assertEquals("success",result);

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
        assertEquals(3,result);

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
