package de.siemering.example.common;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AbstractDao {

    @PersistenceContext
    public EntityManager em;

}
