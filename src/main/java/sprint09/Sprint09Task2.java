package sprint09;
import java.util.*;

public class Sprint09Task2 {
    /*
    Given a text containing brackets  '(', ')', '{', '}', '[' and ']'.

    Sequences "\\(", "\\)", "\\[", "\\]", "\\{" and "\\}" are not brackets.

    Write a boolean verifyBrackets(String text) method of the MyUtils class to check a input text.

    The brackets must close in the correct order, for example "()", "()[]{}", "{(())}" and "(\\()" are all valid
    but "(]", ")(" and "([)]" are not.
     */
    public static class MyUtils {
        public static boolean verifyBrackets(String text) {
            String filteredText = text.replaceAll("\\\\.", "");

            Queue<Character> charStack = Collections.asLifoQueue(new ArrayDeque<>());
            for (char currentChar : filteredText.toCharArray()) {
                if (matchesAny(currentChar, "{([")) {
                    charStack.add(currentChar);
                } else {
                    if (charStack.isEmpty()) {
                        return false; // that means that no opening bracket was found, but already found closing one
                    }
                    Character lastOpeningBracket = charStack.poll();
                    if (lastOpeningBracket == '{') {
                        if (currentChar != '}') {
                            return false;
                        }
                    }
                    if (lastOpeningBracket == '(') {
                        if (currentChar != ')') {
                            return false;
                        }
                    }
                    if (lastOpeningBracket == '[') {
                        if (currentChar != ']') {
                            return false;
                        }
                    }
                }
            }
//            if charStack is not empty - text's unbalanced
            return charStack.isEmpty();
        }

        private static boolean matchesAny(char ch, String matcher) {
            for (char match : matcher.toCharArray()) {
                if (match == ch) {
                    return true;
                }
            }
            return false;
        }
    }
}
