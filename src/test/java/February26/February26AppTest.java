package February26;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class February26AppTest {


    private Filterable task;

    @BeforeEach
    void setUp() {
        this.task = new Filterable() {
            @Override
            String filter(String origin) {
                return null;
            }
        };
    }

    @Test
    void filter() {
        String origin = "Hello";
        String expected = "hll";
        String actual = task.filter(origin);
        assertEquals(expected, actual);

    }
}
