package March6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BracketsTest {
    private Brackets app;

    @BeforeEach
    public void setUp() {
        this.app =
                new Brackets();
    }

    @Test
    public void calc1() {
        assertEquals(1, app.calc("()()()"));
    }

    @Test
    public void calc1a() {
        assertEquals(1, app.calc("()"));
    }

    @Test
    public void calc2() {
        assertEquals(2, app.calc("()(()())()"));
    }

    @Test
    public void calc3() {
        assertEquals(3, app.calc("()(()())((()()))(())()"));
    }

}