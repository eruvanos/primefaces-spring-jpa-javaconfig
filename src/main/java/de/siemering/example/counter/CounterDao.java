package de.siemering.example.counter;

import de.siemering.example.common.AbstractDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by maics on 28.02.2016.
 */
@Repository
public class CounterDao extends AbstractDao{

    public Counter findOne(Long id){
        return em.find(Counter.class, id);
    }

    public List<Counter> findByName(String name){
        Query query = em.createQuery("select c from Counter c where c.name = :name");
        query.setParameter("name", name);

        return query.getResultList();
    }

    @Transactional()
    public Counter save(Counter counter){
        em.persist(counter);
        return counter;
    }

    public void delete(Counter counter){
        em.remove(counter);
    }

}
