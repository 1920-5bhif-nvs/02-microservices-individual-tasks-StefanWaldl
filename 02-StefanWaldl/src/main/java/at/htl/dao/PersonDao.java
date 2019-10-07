package at.htl.dao;

import at.htl.entity.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PersonDao {

    @Inject
    EntityManager em;

    public List<Person> getAll(){
        return em.createNamedQuery("person.findAll", Person.class).getResultList();
    }

    @Transactional
    public void persist(Person person){
        em.persist(person);
    }

    @Transactional
    public void update(Person person){
        em.merge(person);
    }
}
