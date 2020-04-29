package sprint09;

import java.util.regex.Pattern;

public class Sprint09Task5 {
    /*
    Write a String reformatLines(String text) method of the MyUtils class to replacing all spaces with one and reformat lines of input text.
    Length of every lines should not exceed 60 characters.
    For example, for a given text
    Java    was      originally developed
       by    James   Gosling at Sun Microsystems (which
     has since been
    acquired by Oracle) and released in 1995
     as a core component of Sun Microsystems' Java platform.
    you should get
    Java was originally developed by James Gosling at Sun
    Microsystems (which has since been acquired by Oracle) and
    released in 1995 as a core component of Sun Microsystems'
    Java platform.
     */

    public static class MyUtils {
        public static String reformatLines(String text) {
            StringBuilder formattedText = new StringBuilder();
            int characters = 0;
            for (String word : text.split("\\s+")) {
                int wordLength = word.length();
                if (characters + wordLength > 60) {
                    formattedText.append("\n").append(word);
                    characters = wordLength;
                } else {
                    if (formattedText.length() != 0) {
                        formattedText.append(" ");
                        characters++;
                    }
                    formattedText.append(word);
                    characters += wordLength;
                }
            }
            return formattedText.toString();
        }
    }

}
