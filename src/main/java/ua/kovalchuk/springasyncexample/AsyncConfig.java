package ua.kovalchuk.springasyncexample;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Slf4j
@EnableAsync
@Configuration
public class AsyncConfig {

    @PostConstruct
    public void setUp() {
        log.warn("Loaded AsyncConfig");
    }

}
