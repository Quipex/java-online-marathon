package sprint09;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

public class Sprint09Task4 {
    /*
    Write a String differentWords(String originalText, String modifyText) method of the MyUtils class
    to compare originalText and modifyText.

    The differentWords() method return the modified text with uppercase of additional words.

    For example, for a given originalText:
    Java is a programming language.
    and modifyText:
    Java is a   general-purpose programming   language.
    you should get:
    Java is a   GENERAL-PURPOSE programming   language.
     */

    public static class MyUtils {
        public static String differentWords(String original, String mod) {
            Queue<String> originalWords = splitIntoWordsAndSpaces(original);
            Queue<String> moddedWords = splitIntoWordsAndSpaces(mod);
            StringBuilder result = new StringBuilder();
            String originalWord = originalWords.poll();
            while (!moddedWords.isEmpty()) {
                String moddedWord = moddedWords.poll();
                if (originalWord == null || !moddedWord.trim().equals(originalWord.trim())) {
                    result.append(moddedWord.toUpperCase());
                } else {
                    result.append(moddedWord);
                    originalWord = originalWords.poll();
                }
            }
            return result.toString();
        }

        private static Queue<String> splitIntoWordsAndSpaces(String original) {
            Queue<String> wordsAndSpaces = new ArrayDeque<>();
            char[] chars = original.toCharArray();
            StringBuilder word = new StringBuilder();
            Boolean lastLetterWord = null;
            for (int i = 0; i < chars.length; i++) {
                char ch = chars[i];
                if (lastLetterWord == null) {
                    lastLetterWord = isPartOfWord(ch);
                }

                if (isPartOfWord(ch)) {
                    if (!lastLetterWord) {
                        wordsAndSpaces.add(word.toString());
                        word.setLength(0);
                    }
                } else {
                    if (lastLetterWord) {
                        wordsAndSpaces.add(word.toString());
                        word.setLength(0);
                    }
                }
                lastLetterWord = isPartOfWord(ch);
                word.append(ch);
            }
            if (isBuilderPending(word)) {
                wordsAndSpaces.add(word.toString());
            }
            return wordsAndSpaces;
        }

        private static boolean isBuilderPending(StringBuilder builder) {
            return builder.length() != 0;
        }

        private static boolean isPartOfWord(char ch) {
            return Character.isLetter(ch) || ch == '-';
        }
    }
}
