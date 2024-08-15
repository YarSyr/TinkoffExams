package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P6Test {


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
            P6.main(new String[]{});
            assertEquals(expectedOutput, out.toString().trim());
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }

    private static Stream<Arguments> provideInputAndExpectedOutput() {
        return Stream.of(
                Arguments.of("4 \n 2 1 4 6", "-1 -1"),
                Arguments.of("2 \n 1 2", "-1 -1"),
                Arguments.of("2 \n 2 1", "1 2"),
                Arguments.of("4 \n 101 1000000 888 999", "3 4"),
                Arguments.of("4 \n 102 1000002 999 997", "1 4"),
                Arguments.of("4 \n 2 1 333 8888888888", "1 2"),
                Arguments.of("4 \n 2 1 4 6", "-1 -1"),
                Arguments.of("8 \n 4 3 3 8 7 6 8 9", "-1 -1"),
                Arguments.of("8 \n 3 4 8 3 7 6 9 8", "3 4"),
                Arguments.of("4 \n 1 2 4 7", "3 4"),
                Arguments.of("4 \n 2 1 4 6", "-1 -1")

        );
    }
}