import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalcTests {

    Calculator  sut;

    @Test
    @BeforeEach
    public void beforeEach() {
        sut = new Calculator();
    }

    @Test
    public void testAddition () {
        //given:
        int a = 1, b = 2, expected = 3;

        //when:
        int actual = sut.plus.apply(a, b);

        //then
        Assertions.assertEquals(expected, actual);

    }

    @ParameterizedTest
    @MethodSource("substractWithData")
    public void testSubstraction (int a, int b, int expected) {

        //when:
        int actual = sut.minus.apply(a, b);

        //then
        Assertions.assertEquals(expected, actual);

    }

    public static Stream<Arguments> substractWithData () {
        return Stream.of(Arguments.of(10, 6, 4));
    }

    @Test
    public void testMultiply () {
        //given:
        int a = 5, b = 10, expected = 50;

        //when:
        int actual = sut.multiply.apply(a, b);

        //then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDivide () {
        //given:
        int a = 10, b = 5, expected = 2;

        //when:
        int actual = sut.divide.apply(a, b);

        //then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDivideByZero () {
        //given:
        int a = 5, b = 0;

        //when:
        Executable ex = () -> sut.divide.apply(a, b);
//        Executable ex = (Executable) new ArithmeticException();

        //then
        Assertions.assertThrowsExactly(ArithmeticException.class, (Executable) ex);
    }

}
