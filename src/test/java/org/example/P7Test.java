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

public class P7Test {


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
                Arguments.of("3 \n 1 2 3", "-1 -1"),
                Arguments.of("3 \n 1 3 1", "1 2")


        );
    }
}