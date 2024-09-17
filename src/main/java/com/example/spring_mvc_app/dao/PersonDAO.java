package com.example.spring_mvc_app.dao;

import com.example.spring_mvc_app.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    private static int count=1;
    private List<Person> people;
    {
        people = new ArrayList<>();
        people.add(new Person(count++,"Gadjilav"));
        people.add(new Person(count++,"Maga"));
        people.add(new Person(count++,"Abdul"));
    }

    public List<Person> getAll(){
        return people;
    }

    public Person getPerson(int id) {
        return people.stream().filter(person -> person.getId()==id).findAny().orElse(null);
    }
    public void save(Person person){
        person.setId(++count);
        people.add(person);
    }
    public void update(int id,Person person){
         getPerson(id).setName(person.getName());
    }
    public void delete(int id){
        people.removeIf(person->person.getId()==id);
    }
}
