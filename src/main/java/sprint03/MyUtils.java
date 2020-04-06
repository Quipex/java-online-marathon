package sprint03;

import java.util.*;


public class MyUtils {
    /*
        Create a arrSort() method of the MyUtils class to sort a two-dimensional integer array by
        descending the elements of the first column.  In the case of equality of elements in the first column,
        the elements of the second column must be sorted in ascending order.

        For example, for a given array
         1 2 3
         1 4
         3 2
         3 3 5
         you should get
         3 2
         3 3 5
         1 2 3
         1 4
     */
    public static int[][] arrSort(int[][] arrayOfArrays) {
        Arrays.sort(arrayOfArrays, (thisArray, thatArray) -> {
//                descending
            if (thisArray.length == 0) {
                return 1;
            }
            if (thatArray.length == 0) {
                return -1;
            }
            int difference = thatArray[0] - thisArray[0];
            if (difference == 0) {
//                ascending
                if (thisArray.length == 1) {
                    return -1;
                }
                if (thatArray.length == 1) {
                    return 1;
                }
                return thisArray[1] - thatArray[1];
            }
            return difference;
        });
        return arrayOfArrays;
    }

    /*
        Create the strSort() method of the MyUtils class to sort a list of strings first by length and alphabetically
        within the same length. The original list must be unchanged.
        For example, for a given list
        [zz, abc, aa, aaa]
        you should get
        [aa, zz, aaa, abc].
     */
    public static List<String> strSort(List<String> originList) {
        ArrayList<String> copiedList = new ArrayList<>(originList);
        copiedList.sort((thisString, thatString) -> {
            int difference = thisString.length() - thatString.length();
            if (difference == 0) {
                return thisString.compareTo(thatString);
            }
            return difference;
        });
        return copiedList;
    }

    /*
        Create a listMapCompare() method of the MyUtils class to compare the contents of a list of strings and the values of a map.
        For example, for a given list [aa, bb, aa, cc] and map {1=cc, 2=bb, 3=cc, 4=aa, 5=cc} you should get true.
     */
    public static boolean listMapCompare(List<String> list, Map<String, String> map) {
        return map.values().containsAll(list) && list.containsAll(map.values());
    }

    /*
        Create a createNotebook() method of the MyUtils class to create a new map with name as key and phone list as value.
        The method receives a map  with phone as key and name as value.
        For example, for a given map
        {0967654321=Petro, 0677654321=Petro, 0501234567=Ivan, 0970011223=Stepan, 0631234567=Ivan}
        you should get
        {Ivan=[0501234567, 0631234567], Petro=[0967654321, 0677654321], Stepan=[0970011223]}.
     */
    public static Map<String, List<String>> createNotebook(Map<String, String> phonesToNames) {
        Map<String, List<String>> namesToPhones = new HashMap<>();
        phonesToNames.forEach((phone, name) -> {
            List<String> phones;
            if (namesToPhones.containsKey(name)) {
                phones = namesToPhones.get(name);
            } else {
                phones = new ArrayList<>();
            }
            phones.add(phone);
            namesToPhones.put(name, phones);
        });
        return namesToPhones;
    }

    /*
        Create the commonStudents() method of the MyUtils class to return a HashSet of common elements of two student lists.
        For example, for a given list1
        [Students [id=1, name=Ivan], Students [id=2, name=Petro], Students [id=3, name=Stepan]]
        and list2
        [Students [id=1, name=Ivan], Students [id=3, name=Stepan], Students [id=4, name=Andriy]]
        you should get
        [Students [id=3, name=Stepan], Students [id=1, name=Ivan]].
     */

    public static class Student {
        private int id;
        private String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public Student() {
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return id == student.id &&
                    Objects.equals(name, student.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    public static Set<Student> commonStudents(List<Student> list1, List<Student> list2) {
        list1.retainAll(list2);
        return new HashSet<>(list1);
    }
}
