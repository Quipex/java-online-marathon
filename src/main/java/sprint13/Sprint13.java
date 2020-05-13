package sprint13;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Sprint13 {
	
	
	public static Calendar convertDateToCalendar(Date date) {
		return new Calendar.Builder().setInstant(date).build();
	}
	
	
	/*
	Write a method to get the name of last day of the given month in given year.

	Use GregorianCalendar class to solve this exercise.
	
	The name of day must corresponds next format: Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday.
	
	If month isn't correct then name is "Wrong Month".
	 */
	public static String lastDayOfMonth(int month, int year) {
		if (month < 0 || month > 11) {
			return "Wrong Month";
		}
		GregorianCalendar calendar = new GregorianCalendar(year, month, 1);
		int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		calendar.set(year, month, lastDay);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		switch (dayOfWeek) {
			case 1:
				return "Sunday";
			case 2:
				return "Monday";
			case 3:
				return "Tuesday";
			case 4:
				return "Wednesday";
			case 5:
				return "Thursday";
			case 6:
				return "Friday";
			case 7:
				return "Saturday";
			default:
				throw new RuntimeException("Unknown enum number: " + dayOfWeek);
		}
	}
	
	
	/*
	Write a method to check if a year is a leap year or not, using for this the LocalDate class.

	If a year is leap then method should return true, otherwise - false.
	 */
	
	public static boolean isLeapYear(int year) {
		return LocalDate.of(year, 1, 1).isLeapYear();
	}
	
	
	/*
	Write a method to get the date n-years m-months and k-days after today using new DateTime API.

	Return the obtained date in the format ISO_LOCAL_DATE.
	 */
	public static String getDateAfterToday(int years, int months, int days) {
		return LocalDate.now().plusYears(years).plusMonths(months).plusDays(days)
				.format(DateTimeFormatter.ISO_LOCAL_DATE);
	}
	
	
	/*
	Write a method to read from a file a character-oriented data and return these data as String object.
	For example, next fragment:
		This is text fragment
		that contains some text data
		and can be read!
	
	after reading will be transform to the next String object:
	"This is text fragment\nthat contains some text data\nand can be read!"
	 */
	public static String readFile(String filename) {
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
				sb.append('\n');
			}
			// removing last \n
			sb.setLength(sb.length() - 1);
			return sb.toString();
		} catch (IOException e) {
			throw new RuntimeException("Can't open file");
		}
	}
	
	
	/*
	Create the method writeFile(String filename, String text) that write the text to file as sequence
	of bytes in binary format.
	
	For example, the text fragment:
		Hello!
	should be represented in the file as a sequence of 7-bit bytes without spaces between them:
		100100011001011101100110110011011110100001
	If less than 7 bits are required to represent the character then add to binary sequence leading zeros '0'.
	 */
	public static void writeFile(String filename, String text) {
		try (OutputStream os = new FileOutputStream(filename)) {
			byte[] textBytes = text.getBytes();
			StringBuilder binaryString = new StringBuilder();
			for (byte textByte : textBytes) {
				binaryString.append(Integer.toBinaryString(textByte));
				int leadingZeros = 7 - binaryString.length();
				while (leadingZeros != 0) {
					binaryString.insert(0, "0");
					leadingZeros--;
				}
				os.write(binaryString.toString().getBytes());
				binaryString.setLength(0);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	/*
	Create the method readFile(String filename) that read from file a sequence of bytes in binary
	format from previous task and return ridable string.

	For example, the sequence of 7-bit bytes
		100100011001011101100110110011011110100001
	
	should be represented as text fragment:
		Hello!
	 */
	public static String readFile1(String filename) {
		try (InputStream is = new FileInputStream(filename)) {
			int charAsInt;
			StringBuilder stringBuilder = new StringBuilder();
			while ((charAsInt = is.read()) != -1) {
				char ch = (char) charAsInt;
				stringBuilder.append(ch);
			}
			return decode(stringBuilder.toString());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private static final int NUMBER_OF_BITS = 7;
	
	private static String decode(String textBytes) {
		int characterNum = textBytes.length() / NUMBER_OF_BITS;
		int leftIndex = 0;
		byte[] textAsBytes = new byte[characterNum];
		for (int i = 0; i < characterNum; i++) {
			String sevenBitRepresentation = textBytes.substring(leftIndex, leftIndex + NUMBER_OF_BITS);
			textAsBytes[i] = Byte.parseByte(sevenBitRepresentation, 2);
			leftIndex += 7;
		}
		return new String(textAsBytes);
	}
}
