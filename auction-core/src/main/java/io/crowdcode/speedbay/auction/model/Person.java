package io.crowdcode.speedbay.auction.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Entity
@Getter
@Setter
@ToString
@Accessors(chain=true)
@NamedQueries(value = @NamedQuery(name = "Person.findAll",
query = "SELECT p FROM Person p"))
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;


}
