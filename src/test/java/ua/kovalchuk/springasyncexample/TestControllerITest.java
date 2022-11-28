package ua.kovalchuk.springasyncexample;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;

import static org.mockito.Mockito.verify;

@SpringBootTest(
    classes = SpringAsyncExampleApplication.class,
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class TestControllerITest {

    @LocalServerPort
    int port;
    @MockBean
    private TestService testService;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Test
    void process() {
        RestAssured.given()
            .get("/process")
            .then()
            .assertThat()
            .statusCode(200);

        verify(testService).process();
    }
}