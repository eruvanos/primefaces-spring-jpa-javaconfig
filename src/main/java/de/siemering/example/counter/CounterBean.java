package de.siemering.example.counter;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

@ManagedBean
@RequestScoped
public class CounterBean implements Serializable{

    private static final Logger log = LogManager.getLogger(CounterBean.class);

    @ManagedProperty("#{counterService}")
    private CounterService counterService;

    public CounterBean() {
        log.trace("Counterbean created!");
    }

    public String getMessage() {
        return "Increment counter!";
    }

    public int getCounter() {
        return counterService.getCounter();
    }

    public void incrementCounter() {
        counterService.incrementCounter();
    }

    public void setCounterService(CounterService counterService) {
        this.counterService = counterService;
    }
}