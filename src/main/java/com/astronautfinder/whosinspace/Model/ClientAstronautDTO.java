package com.astronautfinder.whosinspace.Model;

public class ClientAstronautDTO {

    public ClientAstronautDTO(){}

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
