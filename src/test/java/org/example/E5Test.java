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

public class E5Test {

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
            E5.main(new String[]{});
            assertEquals(expectedOutput, out.toString().trim());
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }

    private static Stream<Arguments> provideInputAndExpectedOutput() {
        return Stream.of(
                Arguments.of("5\n3 2 3 5\n1 4\n0\n0\n1 3","3\r\n2 3 4\r\n2 2 5\r\n1 1"),
                Arguments.of("6\n1 2\n1 3\n1 4\n1 5\n1 6\n0","6\r\n1 6\r\n1 5\r\n1 4\r\n1 3\r\n1 2\r\n1 1"),
                Arguments.of("6\n5 2 3 4 5 6\n0\n0\n0\n0\n0","2\r\n5 2 3 4 5 6\r\n1 1"),
                Arguments.of("3\n0\n0\n0", "1\r\n3 1 2 3")
        );
    }
}
