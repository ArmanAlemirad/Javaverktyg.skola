import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
public class RedisInDockerExampleIT {
    private RedisBackedCache underTest;

    @Container
    GenericContainer<?> redis =
            new GenericContainer<>(DockerImageName.parse("redis:7-alpine"))
            .withExposedPorts(6379);

    @BeforeEach
    public void setUp() {
    String address = redis.getHost();
    Integer port = redis.getFirstMappedPort();
        // Assume that we have Redis running locally?
        underTest = new RedisBackedCache("localhost", 6379);
    }

    @AfterEach
    void tearDown (){underTest.close();}
    @Test
    @Disabled("Code is not implemented yet")
    public void testSimplePutAndGet() {
        underTest.put("test", "example");

        String retrieved = underTest.get("test");
        assertThat(retrieved).isEqualTo("example");
    }
}