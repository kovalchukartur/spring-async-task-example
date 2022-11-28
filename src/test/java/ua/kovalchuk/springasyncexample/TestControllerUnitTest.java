package ua.kovalchuk.springasyncexample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TestController.class)
class TestControllerUnitTest {

    @MockBean
    private TestService testService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void process() throws Exception {
        this.mockMvc.perform(
                get("/process")
            )
            .andDo(print())
            .andExpect(status().isOk());

        verify(testService).process();
    }
}