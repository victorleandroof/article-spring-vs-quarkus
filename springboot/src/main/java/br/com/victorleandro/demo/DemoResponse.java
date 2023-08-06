package br.com.victorleandro.demo;

public class DemoResponse {

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
