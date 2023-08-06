package br.com.victorleandro;

import com.github.javafaker.Faker;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/demo")
public class DemoResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<DemoResponse> demoResponsesList = this.generateList();
        return Response.ok(demoResponsesList).build();
    }

    private List<DemoResponse> generateList() {
        Faker faker = new Faker();
        List<DemoResponse> demoList = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            demoList.add(new DemoResponse(faker.name().fullName()));
        }
        return demoList;
    }
}
