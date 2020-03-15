package com.astronautfinder.whosinspace;


import com.astronautfinder.whosinspace.Model.ClientAstronautDTO;
import com.astronautfinder.whosinspace.Service.AstronautServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
public class AstronautServiceTest {
    private AstronautServiceImpl astronautService;

    public AstronautServiceTest() {
         this.astronautService = new AstronautServiceImpl();
    }

    @Test
    public void AddAstronautTest(){
      String result = astronautService.addCraft(new ClientAstronautDTO());
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
    public void getAllAstronauts(){
        String result = astronautService.addCraft(new ClientAstronautDTO());
        assertEquals("Success",result);

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
            add("Andrew Morgan");
            add("Oleg Skripochka");
            add("Jessica Meir");
        }},result);
    }
}
