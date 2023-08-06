package br.com.victorleandro;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DemoResponse {
    @JsonProperty("name")
    private String name;

    public DemoResponse(){}

    public DemoResponse(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
