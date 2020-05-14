package sprint14;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Sprint14 {
	/*
	Let the key of Map is project name and value contains list of participants.
	Create a Stream<String> nameList(Map<String, Stream<String>> map) method of the MyUtils class to build sorted stream of all participants without duplication.
	Please ignore null or empty strings, extra spaces and case sensitivity.
	Throw NullPointerException if map is null.
	For example, for a given map
	{"Desktop"=[" iVan", "PeTro ", " Ira "], "Web"=["STepan", "ira ", " Andriy ", "an na"], "Spring"=["Ivan", "Anna"]}
	you should get
	["Andriy", "Anna", "Ira", "Ivan", "Petro ", "Stepan"]
	 */
	
	public static Stream<String> nameList(Map<String, Stream<String>> map) {
		return map.values().stream()
				.filter(Objects::nonNull)
				.flatMap(stringStream -> stringStream.filter(Objects::nonNull)
						.map(str -> str.replace(" ", "").toLowerCase()))
				.filter(s -> !s.isEmpty())
				.map(str -> {
					String restOfTheWord = str.length() == 1 ? "" : str.substring(1);
					return str.substring(0, 1).toUpperCase() + restOfTheWord;
				})
				.distinct()
				.sorted();
	}
	
	/*
	Create a Map<String, Stream<String>> phoneNumbers(List<Stream<String>> list) method of the
	MyUtils class to build a Map of all phone numbers.
	
	The key of Map is code of network and value contains sorted list of phones.
	
	Remove all spaces, brakets and dashes from phone numbers.
	
	For example, for a given
	[["093 987 65 43", "(050)1234567", "12-345"], ["067-21-436-57", "050-2345678", "0939182736", "224-19-28"],
	["(093)-11-22-334", "044 435-62-18", "721-73-45"]]
	you should get
	{"050"=["1234567", "2345678"], "067"=["2143657"], "093"=["9876543", "9182736", "1122334"], "044"=["4356218"],
	"loc"=["7217345", "2241928"], "err"=["12345"]}
	 */
	
	public Map<String, Stream<String>> phoneNumbers(List<Stream<String>> list) {
		Map<String, List<String>> codesToNumbers = new HashMap<>();
		
		list.stream()
//				filter null streams
				.filter(Objects::nonNull)
				.flatMap(stringStream ->
//						filter null strings
						stringStream.filter(Objects::nonNull)
								.map(s -> s.replaceAll("[-()\\s]", "")))
				.filter(s -> !s.isEmpty())
				.sorted()
				.distinct()
				.forEach(numbers -> populateCodeToNumbers(codesToNumbers, numbers));

//		codesToNumbers.forEach((key, value) -> System.out.println(key + "=" + value));
		return codesToNumbers.entrySet().stream()
				.collect(HashMap::new, (hashMap, stringListEntry) ->
								hashMap.put(stringListEntry.getKey(), stringListEntry.getValue().stream()),
						HashMap::putAll);
	}
	
	private void populateCodeToNumbers(Map<String, List<String>> codesToNumbers, String digits) {
		int numberLen = digits.length();
		switch (numberLen) {
			case 7:
				mergeMapWithNewNumbers(codesToNumbers, "loc", digits);
				break;
			case 10:
				mergeMapWithNewNumbers(codesToNumbers, digits.substring(0, 3), digits.substring(3, 10));
				break;
			default:
				mergeMapWithNewNumbers(codesToNumbers, "err", digits);
				break;
		}
	}
	
	private void mergeMapWithNewNumbers(Map<String, List<String>> codesToNumbers, String code, String number) {
		List<String> savedNumbers = codesToNumbers.getOrDefault(code, new ArrayList<>());
		savedNumbers.add(number);
		codesToNumbers.putIfAbsent(code, savedNumbers);
	}
	
	/*
	Create a int sumEven(Stream<IntStream> stream) method of the MyUtils class to sum minimal positive even numbers from all Streams.
	Return zero if minimum positive even element was not found in stream.
	For example, for a given
	[[-2, -4, 1, 8, 3, 10], [2, -4, 4, 0, 3, 1], [1, -4, 3, 5, 3, 1]]
	you should get 10 (8+2+0)
	 */
	
	public int sumEven(Stream<IntStream> stream) {
		return stream.mapToInt(intStream -> intStream.filter(num -> num > 0 && num % 2 == 0)
				.min().orElse(0))
				.sum();
	}
	
	/*
	Create a int countNumbers(IntStream intNum, Stream<String> strNum) method of the MyUtils class to count of
	numbers that is divisible by 3 or contains the digit 3.
	The parameters of the method are two Streams with integers and Strings with one number.
	For example, for a given
	[[3, 2, 1, 13, 21, 15], ["9", "4", "23", "0", "32", "5"]]
	you should get 7
	 */
	
	public static long countNumbers(IntStream intNum, Stream<String> strNum) {
		long count1 = 0;
		if (intNum != null) {
			count1 = intNum
					.filter(num -> dividesBy3(num) || contains3(String.valueOf(num)))
					.count();
		}
		long count2 = 0;
		if (strNum != null) {
			count2 = strNum
					.filter(Objects::nonNull)
					.filter(s -> !s.isEmpty())
					.filter(sNum -> contains3(sNum) || dividesBy3(Integer.parseInt(sNum)))
					.count();
		}
		return count1 + count2;
	}
	
	private static boolean contains3(String str) {
		return str.contains("3");
	}
	
	private static boolean dividesBy3(int num) {
		return num % 3 == 0 && num != 0;
	}
	
	/*
	Create a Stream<Integer> duplicateElements(Stream<Integer> stream) method of the MyUtils class to return a sorted
	stream of duplicated elements of the input stream.
	For example, for a given elements
	[3, 2, 1, 1, 12, 3, 8, 2, 4, 2]
	you should get
	[1, 2, 3]
	 */
	
	public Stream<Integer> duplicateElements(Stream<Integer> stream) {
		return stream.filter(onlyDuplicates()).distinct().sorted();
	}
	
	private Predicate<? super Integer> onlyDuplicates() {
		Set<Integer> seenElements = new HashSet<>();
		return number -> number != null && !seenElements.add(number);
	}
}
