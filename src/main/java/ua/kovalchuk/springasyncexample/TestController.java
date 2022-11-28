package ua.kovalchuk.springasyncexample;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @Async
    @GetMapping("/process")
    public void process() {
        testService.process();
    }
}
