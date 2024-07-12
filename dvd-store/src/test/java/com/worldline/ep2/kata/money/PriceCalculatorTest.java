package com.worldline.ep2.kata.money;

import static com.worldline.ep2.kata.TestEntityHelper.getVideo;
import static com.worldline.ep2.kata.money.PriceCalculator.computeDVDPrice;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import com.worldline.ep2.kata.entity.VideoTape;


public class PriceCalculatorTest {

    @ParameterizedTest
    @MethodSource("videos")
    public void testVideoTapePrice(VideoTape videoTape,Integer expectedPrice){
        int price = computeDVDPrice(videoTape);
        assertEquals(expectedPrice,price);
    }

    public static Stream<Arguments> videos(){
        return Stream.of(
                Arguments.of(getVideo("1234"),5),
                Arguments.of(getVideo("1232"),5)
        );
    }
}
