package io.crowdcode.speedbay.auction.config;

import io.crowdcode.speedbay.auction.model.Person;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        JpaPersistenceContextConfiguration.class,
        DataSourceConfiguration.class
})
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JpaPersistenceContextConfigurationTest {

    @PersistenceContext
    private EntityManager em;

    @Test
    @Commit
    public void a_testWriteData() throws Exception {
        Person person = new Person().setName("Ingo");

        em.persist(person);

        assertThat(person.getId(), is(notNullValue()));
    }

    String ql = "SELECT a FROM Auction a LEFT JOIN " +
            "a.bids b WHERE b.email = :email";

    String ql2 = "SELECT DISTINCT v FROM Auction a LEFT JOIN " +
            "a.product p LEFT JOIN p.vendor v LEFT JOIN a.bids b" +
            "WHERE b.email = :email";

    @Test
    public void b_testReadAll() throws Exception {
//        em.find(Person.class, )
        String jpql = "SELECT p FROM Person p";


        TypedQuery<Person> query = em.createNamedQuery("Person.findAll", Person.class);
        List<Person> resultList = query.getResultList();


        String name = resultList.stream().findFirst().get().getName();
        System.out.println(name);
    }

    @Test
    public void c_testReadByName() throws Exception {
//        em.find(Person.class, )
        String jpql = "SELECT p FROM Person p WHERE p.name = :name";


        TypedQuery<Person> query = em.createQuery(jpql, Person.class);
        query.setParameter("name", "Ingo");
        Person person = query.getSingleResult();

        assertThat(person.getName(),is("Ingo"));
    }
}