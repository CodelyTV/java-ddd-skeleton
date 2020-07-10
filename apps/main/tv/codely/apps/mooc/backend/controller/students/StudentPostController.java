package tv.codely.apps.mooc.backend.controller.students;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tv.codely.shared.domain.DomainError;
import tv.codely.shared.domain.bus.command.CommandBus;
import tv.codely.shared.domain.bus.query.QueryBus;
import tv.codely.shared.infrastructure.spring.ApiController;

import java.util.HashMap;

@RestController
public class StudentPostController extends ApiController {

    public StudentPostController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PostMapping(value = "/students/{id}")
    public ResponseEntity createStudent(@PathVariable String id, @RequestBody Request request){
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }
}

final class Request {
    private String    name;
    private String    surname;
    private String    email;

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    String name() {
        return name;
    }

    String surname() {
        return surname;
    }

    String email() {
        return email;
    }
}
