package com.testParameter;

import com.sun.org.apache.xpath.internal.objects.XString;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class TestPara {
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    public void testWithValueSource(int argument){
        assertTrue(argument > 0 && argument <4,"不符合条件");
    }

    @ParameterizedTest
    //@NullSource、@EmptySource、@ValueSource(strings = {" ","   ","\t","\n"})都为不可见字符，可以判断为null
    @NullSource
    @EmptySource
    @ValueSource(strings = {" ","   ","\t","\n"})
    public void nullEmptyAndBlankStrings(String text){
        assertTrue(text == null || text.trim().isEmpty(),"不符合条件");
    }

    @ParameterizedTest
    @EnumSource(ChronoUnit.class)
    public void testWithEnumSource(TemporalUnit unit){
        assertNotNull(unit);
    }

    @ParameterizedTest
    @MethodSource("stringProvider")
    void testWithExplicitLocalMethodSource(String argument){
        System.out.println(argument);
        assertNotNull(argument);
    }
    static Stream<String> stringProvider(){
        return Stream.of("apple","banana");
    }

    @ParameterizedTest
    //@MethodSource如果不指定方法，就会去找与传参方法同名的没有参数的static方法
    @MethodSource
    void testWithDefaultLocalMethodSource(String argument){
        assertNotNull(argument);
    }
    static Stream<String> testWithDefaultLocalMethodSource(){
        return Stream.of("apple","banana","orange");
    }

    @ParameterizedTest
    @MethodSource("stringIntAndListProvider")
    void testWithMultiArgMethodSource(String str, int num, List<String> list){
        assertEquals(5,str.length());
        assertTrue(num >= 1 && num <=2);
        assertEquals(2,list.size());
    }
    static Stream<Arguments> stringIntAndListProvider(){
        return Stream.of(
                arguments("apple",1, Arrays.asList("a","b")),
                arguments("lemon",2, Arrays.asList("x","y"))
        );
    }

    @ParameterizedTest
    @CsvSource({
            "apple,1",
            "banana,2",
            "'lemon,lime',0xF1"
    })
    void testWithCsvSource(String fruit,int rank){
        assertNotNull(fruit);
        assertNotEquals(0,rank);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/two-column.csv",numLinesToSkip = 1)
    void testWithCsvFileSource(String country,int reference){
        assertNotNull(country);
        assertNotEquals(0,reference);
    }
}
