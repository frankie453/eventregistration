package ca.mcgill.ecse321.eventregistration.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.mcgill.ecse321.eventregistration.dto.PersonDto;
import ca.mcgill.ecse321.eventregistration.model.Person;
import ca.mcgill.ecse321.eventregistration.service.*;

@CrossOrigin(origins = "*")
@RestController
public class EventRegistrationRestController {

  @Autowired
  private EventRegistrationService service;

  @GetMapping(value = {"/persons", "/persons/"})
  public List<PersonDto> getAllPersons() {
    return service.getAllPersons().stream().map(p -> convertToDto(p)).collect(Collectors.toList());
  }

  @PostMapping(value = {"/persons/{name}", "/persons/{name}/"})
  public PersonDto createPerson(@PathVariable("name") String name) throws IllegalArgumentException {
    Person person = service.createPerson(name);
    return convertToDto(person);
  }
}
