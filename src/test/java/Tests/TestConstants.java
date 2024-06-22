package Tests;

import org.example.StringList;
import org.example.StringListImpl;

public class TestConstants {
    public static String HELLO_STRING = "Hello";
    public static String WORLD_STRING = "World";
    public static String GREAT_STRING = "Great";
    public static String NO_USAGE_STRING = "This is no usage!";
    public static String NULL_STRING = null;
    public static int FIRST_BAD_INDEX = 100;
    public static int SECOND_BAD_INDEX = -1;
    public static StringList EMPTY_LIST = new StringListImpl();
    public static StringList NULL_LIST = null;
    public static StringList FIRST_OF_EQUAL_LISTS = new StringListImpl(new String[]{WORLD_STRING, HELLO_STRING, GREAT_STRING});
    public static StringList SECOND_OF_EQUAL_LISTS = new StringListImpl(new String[]{WORLD_STRING, HELLO_STRING, GREAT_STRING});
    public static StringList NOT_EQUAL_LIST = new StringListImpl(new String[]{WORLD_STRING, GREAT_STRING});
    public static StringList FIRST_LIST_FOR_ADD = new StringListImpl(new String[]{WORLD_STRING, HELLO_STRING, HELLO_STRING, WORLD_STRING, GREAT_STRING});
    public static StringList SECOND_LIST_FOR_ADD = new StringListImpl(new String[]{HELLO_STRING, HELLO_STRING, GREAT_STRING, WORLD_STRING, GREAT_STRING});
}
