package org.example;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class P5Test {
//    @Test
//    public void test1() {
//        // Prepare the input and output streams
//        String input = "10 12";
//        InputStream originalIn = System.in;
//        PrintStream originalOut = System.out;
//        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//
//        try {
//            System.setIn(in);
//            System.setOut(new PrintStream(out));
//            Main.main(new String[]{});
//            assertEquals("22", out.toString());
//        } finally {
//            System.setIn(originalIn);
//            System.setOut(originalOut);
//        }
//    }
//
//    @Test
//    public void test2() {
//        // Prepare the input and output streams
//        String input = "9 6";
//        InputStream originalIn = System.in;
//        PrintStream originalOut = System.out;
//        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//
//        try {
//            System.setIn(in);
//            System.setOut(new PrintStream(out));
//            Main.main(new String[]{});
//            assertEquals("15", out.toString());
//        } finally {
//            System.setIn(originalIn);
//            System.setOut(originalOut);
//        }
//    }
    @ParameterizedTest
    @MethodSource("provideInputAndExpectedOutput")
    public void ParamTests(String input, String expectedOutput) {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            System.setIn(in);
            System.setOut(new PrintStream(out));
            P5.main(new String[]{});
            assertEquals(expectedOutput, out.toString().trim());
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }

    private static Stream<Arguments> provideInputAndExpectedOutput() {
        return Stream.of(
                Arguments.of("4 7", "4"),
                Arguments.of("1 10", "9"),
                Arguments.of("10 100", "9"),
                Arguments.of("1 10", "9"),
                Arguments.of("3 99", "16"),
                Arguments.of("8 1000000000", "74"),
                Arguments.of("666 9999", "13"),
                Arguments.of("8 88888888", "64"),
                Arguments.of("1 1", "1"),
                Arguments.of(("0 1000000000000000000"), "163")
        );
    }
    @AfterEach
    public void cleanUpEach(){
        P5.res = 0;
    }
}