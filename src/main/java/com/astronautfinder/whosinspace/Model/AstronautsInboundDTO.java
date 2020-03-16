package com.astronautfinder.whosinspace.Model;

import java.util.List;

public class AstronautsInboundDTO {

    public AstronautsInboundDTO(){}

    private List<ClientAstronautDTO> astronauts;
    private String message;
    private int number;


    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public List<ClientAstronautDTO> getPeople() {
        return astronauts;
    }

    public void setPeople(List<ClientAstronautDTO> astronauts) {
        this.astronauts = astronauts;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
