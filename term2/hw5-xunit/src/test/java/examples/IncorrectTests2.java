package examples;

import me.eranik.xunit.annotations.Before;
import me.eranik.xunit.annotations.BeforeClass;
import me.eranik.xunit.annotations.Test;

public class IncorrectTests2 {
    private int beforeClassValue = 0;
    private int beforeValue = 0;

    @BeforeClass
    void beforeClass() {
        beforeClassValue = 5;
    }

    @Before
    void before() {
        beforeValue = beforeClassValue + 5;
    }

    @Test
    void test1() {
        beforeValue += 5;
        if (beforeValue != 15) {
            throw new AssertionError();
        }
    }

    @Test(expected = NullPointerException.class)
    void test2() {
        beforeValue += 10;
        if (beforeValue != 15) {
            throw new AssertionError();
        }
    }

    @Test(ignore = "Invalid test")
    void test3() {
        beforeValue += 15;
        if (beforeValue != 15) {
            throw new AssertionError();
        }
    }
}
