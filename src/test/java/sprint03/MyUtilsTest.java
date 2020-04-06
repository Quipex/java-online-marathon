package sprint03;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MyUtilsTest {
    private static Map<int[][], int[][]> actualToExpectedArraysOfArrays = new HashMap<>();

    static {
        actualToExpectedArraysOfArrays.put(
                new int[][]{
                        {1, 2, 3},
                        {1, 4},
                        {3, 2},
                        {3, 3, 5}
                },
                new int[][]{
                        {3, 2},
                        {3, 3, 5},
                        {1, 2, 3},
                        {1, 4}
                }
        );
        actualToExpectedArraysOfArrays.put(
                new int[][]{
                        {2},
                        {3, 2, 3},
                        {2, 5},
                        {3},
                        {},
                        {3, 2}
                },
                new int[][]{
                        {3},
                        {3, 2, 3},
                        {3, 2},
                        {2},
                        {2, 5},
                        {}
                }
        );
    }

    @Test
    public void arrTest() {
        actualToExpectedArraysOfArrays.forEach((actualArrOfArrays, expectedArrOfArrays) -> {
            MyUtils.arrSort(actualArrOfArrays);
            for (int i = 0; i < actualArrOfArrays.length; i++) {
                assertArrayEquals(actualArrOfArrays[i], expectedArrOfArrays[i]);
            }
        });
    }

    private static Map<List<String>, List<String>> actualToExpectedStrings = new HashMap<>();

    static {
        actualToExpectedStrings.put(Arrays.asList("zz", "abc", "aa", "aaa"),
                Arrays.asList("aa", "zz", "aaa", "abc"));
    }

    @Test
    public void strArrTest() {
        actualToExpectedStrings.forEach((actualList, expectedList) -> assertArrayEquals(
                expectedList.toArray(new String[0]),
                MyUtils.strSort(actualList).toArray(new String[0]))
        );
    }

    @Test
    public void listMapCompareTest() {
        List<String> strings = Arrays.asList("aa", "bb", "aa", "cc");
        Map<String, String> intsToStrings = new HashMap<>();
        intsToStrings.put("1", "cc");
        intsToStrings.put("2", "bb");
        intsToStrings.put("3", "cc");
        intsToStrings.put("4", "aa");
        intsToStrings.put("5", "cc");
        assertTrue(MyUtils.listMapCompare(strings, intsToStrings));
    }

    @Test
    public void createNoteBookTest() {
        Map<String, String> givenPhonesToNames = new HashMap<>();
        givenPhonesToNames.put("0967654321", "Petro");
        givenPhonesToNames.put("0677654321", "Petro");
        givenPhonesToNames.put("0501234567", "Ivan");
        givenPhonesToNames.put("0970011223", "Stepan");
        givenPhonesToNames.put("0631234567", "Ivan");

        Map<String, List<String>> expectedNamesToPhones = new HashMap<>();
        expectedNamesToPhones.put("Ivan", Arrays.asList("0501234567", "0631234567"));
        expectedNamesToPhones.put("Petro", Arrays.asList("0967654321", "0677654321"));
        expectedNamesToPhones.put("Stepan", Arrays.asList("0970011223"));
        assertEquals(expectedNamesToPhones, MyUtils.createNotebook(givenPhonesToNames));
    }

    @Test
    public void commonStudentsTest() {
        List<MyUtils.Student> list1 = new ArrayList<>(Arrays.asList(new MyUtils.Student(1, "Ivan"), new MyUtils.Student(2, "Petro"),
                new MyUtils.Student(3, "Stepan")));
        List<MyUtils.Student> list2 = new ArrayList<>(Arrays.asList(new MyUtils.Student(1, "Ivan"), new MyUtils.Student(3, "Stepan"),
                new MyUtils.Student(4, "Andriy")));
        Set<MyUtils.Student> actualSet = MyUtils.commonStudents(list1, list2);
        HashSet<MyUtils.Student> expectedSet = new HashSet<>(Arrays.asList(new MyUtils.Student(3, "Stepan"), new MyUtils.Student(1, "Ivan")));
        assertEquals(expectedSet, actualSet);
    }
}
