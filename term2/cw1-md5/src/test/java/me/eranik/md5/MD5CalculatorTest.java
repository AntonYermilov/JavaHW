package me.eranik.md5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests MD5Calculator with one thread and with multiple thread.
 * All MD5-sums were calculated for files and directories independently using MessageDigest.
 */
class MD5CalculatorTest {

    private byte[] resDir = new byte[] {
            115, 96, 7, -125, 45, 33, 103, -70, -86, -25, 99, -3, 58, 63, 60, -15

    };
    private byte[] resResources = new byte[] {
            85, -75, 88, -57, -17, -126, 14, 110, 0, -27, -103, 59, -98, 85, -39, 59,
            115, 96, 7, -125, 45, 33, 103, -70, -86, -25, 99, -3, 58, 63, 60, -15,
            5, -51, -38, 120, -101, 1, 27, -98, -31, -60, 34, -33, 26, -26, 103, 86,
            49, 121, 105, 17, 9, -80, -66, -70, -57, -54, -5, 122, 53, 103, 20, -123
    };
    private byte[] resHello = new byte[] {
            5, -51, -38, 120, -101, 1, 27, -98, -31, -60, 34, -33, 26, -26, 103, 86
    };

    private MD5Calculator calculator;
    private MD5Calculator calculatorMultithread;


    @BeforeEach
    void init() {
        calculator = new MD5Calculator(false);
        calculatorMultithread = new MD5Calculator(true);
    }

    @Test
    void testHello() {
        byte[] result = calculator.countMD5(new File("src/test/resources/hello"));
        assertArrayEquals(resHello, result);
    }

    @Test
    void testHelloMultithread() {
        byte[] result = calculatorMultithread.countMD5(new File("src/test/resources/hello"));
        assertArrayEquals(resHello, result);
    }

    @Test
    void testDir() {
        byte[] result = calculator.countMD5(new File("src/test/resources/dir"));
        assertArrayEquals(resDir, result);
    }

    @Test
    void testDirMultithread() {
        byte[] result = calculatorMultithread.countMD5(new File("src/test/resources/dir"));
        assertArrayEquals(resDir, result);
    }

    @Test
    void testResources() {
        byte[] result = calculator.countMD5(new File("src/test/resources"));
        assertArrayEquals(resResources, result);
    }

    @Test
    void testResourcesMultithread() {
        byte[] result = calculatorMultithread.countMD5(new File("src/test/resources"));
        assertArrayEquals(resResources, result);
    }

}