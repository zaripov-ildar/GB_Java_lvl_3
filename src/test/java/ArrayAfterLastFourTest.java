
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

class ArrayAfterLastFourTest {
    private final ArrayAfterLastFour lastFour = new ArrayAfterLastFour();

    private static Stream<Arguments> testArraysArgumentsProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, new int[]{1, 7}),
                Arguments.of(new int[]{1, 2, 4}, new int[]{})
        );
    }

    @ParameterizedTest
    @MethodSource("testArraysArgumentsProvider")
    void testArrays(int[] input, int[] output) {
        Assertions.assertArrayEquals(output, lastFour.getArray(input));
    }


    @Test
    void testNoFoursException() {
        int[] array = new int[]{1, 6, 9, 6};
        Exception exception = Assertions.assertThrows(RuntimeException.class,
                () -> lastFour.getArray(array));
        Assertions.assertEquals("The array " + Arrays.toString(array) +
                "\n contains no one 4", exception.getMessage());
    }
}