package de.siemering.example.counter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CounterService implements InitializingBean {


    @Autowired
    private CounterDao counterDao;

    public CounterService() {
        log.trace("Create CounterService");
    }

    private static final Logger log = LogManager.getLogger(CounterService.class);

    @Override
    public void afterPropertiesSet() throws Exception {
        List<Counter> byName = counterDao.findByName(Counter.GLOBAL_COUNTER_NAME);

        if (byName.size() == 0) {
            Counter counter = new Counter();
            counter.name = Counter.GLOBAL_COUNTER_NAME;
            counter.value = 0;

            counter = counterDao.save(counter);
            log.info("New global counter was created with id {}", counter.getId());
        }
    }

    @Transactional
    public int getCounter() {
        List<Counter> byName = counterDao.findByName(Counter.GLOBAL_COUNTER_NAME);

        if (byName.size() == 1)
            return byName.get(0).value;
        else
            throw new IllegalStateException("More than one global counter in DB");
    }


    @Transactional
    public void incrementCounter() {

        List<Counter> byName = counterDao.findByName(Counter.GLOBAL_COUNTER_NAME);

        if (byName.size() == 1)
            byName.get(0).value++;
        else
            throw new IllegalStateException("More than one global counter in DB");
    }
}
