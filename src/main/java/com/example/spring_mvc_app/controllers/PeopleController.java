package com.example.spring_mvc_app.controllers;

import com.example.spring_mvc_app.dao.PersonDAO;
import com.example.spring_mvc_app.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private PersonDAO personDAO;

    //AutoWired
    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    //Полуичм всех из dao
    @GetMapping()
    public String index(Model model){
        model.addAttribute("people",personDAO.getAll());
        return "people/index";
    }

    //Полуичм одного из dao
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id,Model model){
        model.addAttribute("person",personDAO.getPerson(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(Model model){
        model.addAttribute("person",new Person());
        return "people/new";
    }

    @PostMapping
    public String create(@ModelAttribute("person") Person person){
        personDAO.save(person);
        System.out.println(person.toString());
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model,@PathVariable("id") int id){
        model.addAttribute("person",personDAO.getPerson(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") Person person,@PathVariable("id") int id){
        personDAO.update(id,person);
        return "redirect:/people";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        personDAO.delete(id);
        return "redirect:/people";
    }
}
