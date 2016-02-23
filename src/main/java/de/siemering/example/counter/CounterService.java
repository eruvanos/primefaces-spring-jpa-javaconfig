package de.siemering.example.counter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.faces.bean.ApplicationScoped;

@Service
public class CounterService {

    public CounterService() {
        log.trace("Create CounterService");
    }

    private static final Logger log = LogManager.getLogger(CounterService.class);
    private int counter = 0;

    public int getCounter() {
        return counter;
    }

    public void incrementCounter() {
        this.counter++;
    }


}
