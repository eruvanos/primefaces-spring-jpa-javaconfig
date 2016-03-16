package de.siemering.example.counter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Counter {

    public static String GLOBAL_COUNTER_NAME = "GLOBAL";

    @Id
    @GeneratedValue
    private Long id;

    public String name;

    public int value;

    public Long getId() {
        return id;
    }

}
