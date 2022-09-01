import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class OnesAndFoursArrayTest {

    private final OnesAndFoursArray onesAndFoursArray = new OnesAndFoursArray();

    private static Stream<Arguments> testArraysArgumentsProvider(){
        return Stream.of(
                Arguments.of(new int[]{}, false),
                Arguments.of(new int[]{1,2,3,5,6,7}, false),
                Arguments.of(new int[]{4,5,6,7,8,10}, false),
                Arguments.of(new int[]{1,2,3,4,5,6,7}, true)
        );
    }

    @ParameterizedTest
    @MethodSource("testArraysArgumentsProvider")
    void testArrays(int[] input, boolean result){
        Assertions.assertEquals(result, onesAndFoursArray.containsOneAndFour(input));
    }
}