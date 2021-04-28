package cz.czechitas.java2webapps.lekce5.controller;

import cz.czechitas.java2webapps.lekce5.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Filip Jirsák
 */
@Controller
public class FamousPeopleController {
  private final List<Person> people;

  public FamousPeopleController() {
    people = new ArrayList<>();
    people.add(new Person("Angela", "Merkelová", LocalDate.of(1954, 7, 17)));
    people.add(new Person("Bill", "Gates", LocalDate.of(1955, 10, 28)));
    people.add(new Person("Greta", "Thunbergová", LocalDate.of(2003, 1, 3)));
  }

  @GetMapping("/")
  public ModelAndView list() {
    ModelAndView result = new ModelAndView("index");
    result.addObject("people", people);
    return result;
  }

  @PostMapping(value = "/", params = {"givenName", "lastName", "birthDate"})
  public String append(Person person) {
    people.add(person);

    return "redirect:/";
  }
}
