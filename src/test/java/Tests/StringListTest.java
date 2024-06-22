package Tests;

import org.example.StringList;
import org.example.StringListImpl;

import static Tests.TestConstants.*;

import org.example.exceptions.BadIndexException;
import org.example.exceptions.BadItemException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringListTest {
    public static StringList out = new StringListImpl();

    public static void fillOut() {
        out = new StringListImpl(new String[]{HELLO_STRING, HELLO_STRING, WORLD_STRING, GREAT_STRING});
    }

    public static Stream<Arguments> provideParamsForAddWithoutIndex() {
        return Stream.of(
                Arguments.of(HELLO_STRING, new StringListImpl(new String[]{HELLO_STRING})),
                Arguments.of(HELLO_STRING, new StringListImpl(new String[]{HELLO_STRING, HELLO_STRING})),
                Arguments.of(WORLD_STRING, new StringListImpl(new String[]{HELLO_STRING, HELLO_STRING, WORLD_STRING})),
                Arguments.of(GREAT_STRING, new StringListImpl(new String[]{HELLO_STRING, HELLO_STRING, WORLD_STRING, GREAT_STRING}))
        );
    }

    public static Stream<Arguments> provideParamsForAddWithIndex() {
        return Stream.of(
                Arguments.of(0, WORLD_STRING, FIRST_LIST_FOR_ADD),
                Arguments.of(2, GREAT_STRING, SECOND_LIST_FOR_ADD)
        );
    }

    public static Stream<Arguments> provideParamsForSet() {
        return Stream.of(
                Arguments.of(2, GREAT_STRING),
                Arguments.of(0, WORLD_STRING)
        );
    }

    public static Stream<Arguments> provideParamsForRemoveWithItem() {
        return Stream.of(
                Arguments.of(HELLO_STRING),
                Arguments.of(WORLD_STRING),
                Arguments.of(GREAT_STRING)
        );
    }

    public static Stream<Arguments> provideParamsForRemoveWithIndex() {
        return Stream.of(
                Arguments.of(0, HELLO_STRING),
                Arguments.of(2, WORLD_STRING),
                Arguments.of(3, GREAT_STRING)
        );
    }

    public static Stream<Arguments> provideParamsForContains() {
        return Stream.of(
                Arguments.of(true, HELLO_STRING),
                Arguments.of(true, GREAT_STRING),
                Arguments.of(false, NO_USAGE_STRING)
        );
    }

    public static Stream<Arguments> provideParamsForIndexOf() {
        return Stream.of(
                Arguments.of(0, HELLO_STRING),
                Arguments.of(3, GREAT_STRING)
        );
    }

    public static Stream<Arguments> provideParamsForLastIndexOf() {
        return Stream.of(
                Arguments.of(1, HELLO_STRING),
                Arguments.of(3, GREAT_STRING)
        );
    }

    public static Stream<Arguments> provideParamsForGet() {
        return Stream.of(
                Arguments.of(0, HELLO_STRING),
                Arguments.of(1, HELLO_STRING),
                Arguments.of(3, GREAT_STRING)
        );
    }

    public static Stream<Arguments> provideParamsForEquals() {
        return Stream.of(
                Arguments.of(true, FIRST_OF_EQUAL_LISTS, SECOND_OF_EQUAL_LISTS),
                Arguments.of(false, FIRST_OF_EQUAL_LISTS, NOT_EQUAL_LIST)
        );
    }

    public static Stream<Arguments> provideParamsForSize() {
        return Stream.of(
                Arguments.of(3, FIRST_OF_EQUAL_LISTS),
                Arguments.of(2, NOT_EQUAL_LIST),
                Arguments.of(5, FIRST_LIST_FOR_ADD)
        );
    }

    public static Stream<Arguments> provideParamsForIsEmpty() {
        return Stream.of(
                Arguments.of(true, EMPTY_LIST),
                Arguments.of(false, FIRST_LIST_FOR_ADD)
        );
    }

    public static Stream<Arguments> provideParamsForClear() {
        return Stream.of(
                Arguments.of(FIRST_LIST_FOR_ADD)
        );
    }

    public static Stream<Arguments> provideParamsForToArray() {
        return Stream.of(
                Arguments.of(new String[]{WORLD_STRING, HELLO_STRING, HELLO_STRING, WORLD_STRING, GREAT_STRING}, FIRST_LIST_FOR_ADD),
                Arguments.of(new String[]{HELLO_STRING, HELLO_STRING, GREAT_STRING, WORLD_STRING, GREAT_STRING}, SECOND_LIST_FOR_ADD)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForAddWithoutIndex")
    public void add(String item) {
        Assertions.assertEquals(item, out.add(item));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForAddWithIndex")
    public void add(int index, String item) {
        fillOut();
        Assertions.assertEquals(item, out.add(index, item));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForSet")
    public void set(int index, String item) {
        fillOut();
        Assertions.assertEquals(item, out.set(index, item));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForRemoveWithItem")
    public void remove(String item) {
        fillOut();
        Assertions.assertEquals(item, out.remove(item));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForRemoveWithIndex")
    public void remove(int index, String item) {
        fillOut();
        Assertions.assertEquals(item, out.remove(index));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForContains")
    public void contains(boolean examination, String item) {
        fillOut();
        Assertions.assertEquals(examination, out.contains(item));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForIndexOf")
    public void indexOf(int index, String item) {
        fillOut();
        Assertions.assertEquals(index, out.indexOf(item));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForLastIndexOf")
    public void lastIndexOf(int index, String item) {
        fillOut();
        Assertions.assertEquals(index, out.lastIndexOf(item));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForGet")
    public void get(int index, String item) {
        fillOut();
        Assertions.assertEquals(item, out.get(index));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForEquals")
    public void equals(boolean examination, StringList firstList, StringList secondList) {
        Assertions.assertEquals(examination, firstList.equals(secondList));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForSize")
    public void size(int examination, StringList stringList) {
        Assertions.assertEquals(examination, stringList.size());
    }

    @ParameterizedTest
    @MethodSource("provideParamsForIsEmpty")
    public void isEmpty(boolean examination, StringList stringList) {
        Assertions.assertEquals(examination, stringList.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("provideParamsForClear")
    public void clear(StringList stringList) {
        stringList.clear();
        Assertions.assertTrue(stringList.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("provideParamsForToArray")
    public void toArray(String[] list, StringList stringList) {
        Assertions.assertEquals(Arrays.hashCode(list), Arrays.hashCode(stringList.toArray()));
    }

    @Test
    public void invalidAddWithOutIndex() {
        Assertions.assertThrows(NullPointerException.class,
                () -> out.add(NULL_STRING));
    }

    @Test
    public void invalidAddWithIndex() {
        fillOut();
        Assertions.assertThrows(NullPointerException.class,
                () -> out.add(2, NULL_STRING));
        Assertions.assertThrows(NullPointerException.class,
                () -> out.add(FIRST_BAD_INDEX, NULL_STRING));
        Assertions.assertThrows(BadIndexException.class,
                () -> out.add(FIRST_BAD_INDEX, HELLO_STRING));
        Assertions.assertThrows(BadIndexException.class,
                () -> out.add(SECOND_BAD_INDEX, HELLO_STRING));
    }

    @Test
    public void invalidSet() {
        fillOut();
        Assertions.assertThrows(NullPointerException.class,
                () -> out.set(2, NULL_STRING));
        Assertions.assertThrows(NullPointerException.class,
                () -> out.set(FIRST_BAD_INDEX, NULL_STRING));
        Assertions.assertThrows(BadIndexException.class,
                () -> out.set(FIRST_BAD_INDEX, HELLO_STRING));
        Assertions.assertThrows(BadIndexException.class,
                () -> out.set(SECOND_BAD_INDEX, HELLO_STRING));
    }

    @Test
    public void invalidRemoveWithItem() {
        fillOut();
        Assertions.assertThrows(NullPointerException.class,
                () -> out.remove(NULL_STRING));
        Assertions.assertThrows(BadItemException.class,
                () -> out.remove(NO_USAGE_STRING));
    }

    @Test
    public void invalidRemoveWithIndex() {
        fillOut();
        Assertions.assertThrows(BadIndexException.class,
                () -> out.remove(FIRST_BAD_INDEX));
        Assertions.assertThrows(BadIndexException.class,
                () -> out.remove(SECOND_BAD_INDEX));
    }

    @Test
    public void invalidContains() {
        Assertions.assertThrows(NullPointerException.class,
                () -> out.contains(NULL_STRING));
    }

    @Test
    public void invalidIndexOf() {
        Assertions.assertThrows(NullPointerException.class,
                () -> out.indexOf(NULL_STRING));
    }

    @Test
    public void invalidLastIndexOf() {
        Assertions.assertThrows(NullPointerException.class,
                () -> out.lastIndexOf(NULL_STRING));
    }

    @Test
    public void invalidGet() {
        Assertions.assertThrows(BadIndexException.class,
                () -> out.get(FIRST_BAD_INDEX));
        Assertions.assertThrows(BadIndexException.class,
                () -> out.get(SECOND_BAD_INDEX));
    }

    @Test
    public void invalidEquals() {
        Assertions.assertThrows(NullPointerException.class,
                () -> out.equals(NULL_LIST));
    }
}
