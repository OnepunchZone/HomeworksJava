import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.otus.java.basic.junithw.MainTestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TestMainTestMethod {
    private MainTestMethod test;

    public static Stream<Arguments> getArrTrue () {
        List<Arguments> lst = new ArrayList<>();
        lst.add(Arguments.of(new int[] {1, 2, 1, 2}));
        lst.add(Arguments.of(new int[] {1, 2, 1, 1, 1, 2}));
        lst.add(Arguments.of(new int[] {2, 2, 2, 1, 2}));
        lst.add(Arguments.of(new int[] {1, 1, 1, 2}));

        return lst.stream();
    }

    public static Stream<Arguments> getArrFalse () {
        List<Arguments> lst = new ArrayList<>();
        lst.add(Arguments.of(new int[] {1, 2, 3, 1, 2}));
        lst.add(Arguments.of(new int[] {2, 2, 2, 2, 2}));
        lst.add(Arguments.of(new int[] {1, 1, 1, 1, 1}));
        lst.add(Arguments.of(new int[] {18, 9, 3, 7, 5}));
        lst.add(Arguments.of(new int[] {}));

        return lst.stream();
    }

    @BeforeEach
    public void init() {
        test = new MainTestMethod();
    }

    @Test
    public void testAfterOne() {
        Assertions.assertAll(
                () -> {
                    Assertions.assertArrayEquals(new int[]{3, 3}, test.afterOne(new int[]{2, 1, 2, 1, 3, 3}));
                },
                () -> {
                    Assertions.assertArrayEquals(new int[]{2}, test.afterOne(new int[]{1, 1, 3, 1, 1, 1, 2}));
                },
                () -> {
                    Assertions.assertArrayEquals(new int[]{12, 11}, test.afterOne(new int[]{1, 1, 3, 1, 1, 12, 11}));
                },
                () -> {
                    Assertions.assertThrows(RuntimeException.class, () -> test.afterOne(new int[]{}));
                },
                () -> {
                    Assertions.assertThrows(RuntimeException.class, () -> test.afterOne(new int[]{2, 3, 4, 5}));
                }
        );
    }

    @ParameterizedTest
    @MethodSource("getArrTrue")
    public void testOneAndTowTrue(int[] arr) {
        Assertions.assertTrue(test.justOneAndTow(arr));
    }


    @ParameterizedTest
    @MethodSource("getArrFalse")
    public void testOneAndTowFalse(int[] arr) {
        Assertions.assertFalse(test.justOneAndTow(arr));
    }
}
