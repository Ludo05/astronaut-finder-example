package com.astronautfinder.whosinspace.models;

public class ClientAstronautDTO {

    public ClientAstronautDTO(){}

    public ClientAstronautDTO(String craft, String name) {
        this.craft = craft;
        this.name = name;
    }

    public String getCraft() {
        return craft;
    }

    public void setCraft(String craft) {
        this.craft = craft;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return name.split(" ")[1];
    }

    public void setName(String name) {
        this.name = name;
    }

    private String craft;
    private String name;

}
