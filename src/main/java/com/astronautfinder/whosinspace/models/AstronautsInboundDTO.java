package com.astronautfinder.whosinspace.models;

import java.util.List;

public class AstronautsInboundDTO {

    public AstronautsInboundDTO(){}

    private List<ClientAstronautDTO> astronauts;
    private String message;

    public AstronautsInboundDTO(List<ClientAstronautDTO> astronauts, String message, int number) {
        this.astronauts = astronauts;
        this.message = message;
        this.number = number;
    }

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
