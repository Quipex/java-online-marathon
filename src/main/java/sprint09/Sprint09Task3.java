package sprint09;

public class Sprint09Task3 {
    /*
    Pig Latin is a spoken "secret code" that many English-speaking children learn.
    The rules for written Pig Latin are:
    If a word begins with a consonant cluster, move it to the end and add "ay";
    If a word begins with a vowel, add "hay" to the end;
    Write a String pigLatinConverter(String text) method of the MyUtils class to convert input text.
    For example, for a given text
    Pig Latin is simply a form of jargon unrelated to Latin.
    you should get
    igPay atinLay ishay implysay ahay ormfay ofhay argonjay unrelatedhay otay atinLay.
    For more information, see https://en.wikipedia.org/wiki/Pig_Latin
     */
    public static class MyUtils {
        public static String pigLatinConverter(String text) {
            StringBuilder pigLatinText = new StringBuilder();
            StringBuilder letterAccumulator = new StringBuilder();
            for (int i = 0; i < text.length(); i++) {
                char ch = text.charAt(i);
                if (Character.isLetter(ch)) {
                    letterAccumulator.append(ch);
                } else {
                    if (letterAccumulator.length() != 0) {
                        pigLatinText.append(wordToPigLatin(letterAccumulator.toString()));
                        letterAccumulator.setLength(0); // empty buffer
                    }
                    pigLatinText.append(ch);
                }
            }
            if (letterAccumulator.length() != 0) {
                pigLatinText.append(wordToPigLatin(letterAccumulator.toString()));
            }
            return pigLatinText.toString();
        }

        private static String wordToPigLatin(String word) {
            int len = word.length();
            int vowelIndex = -1;
            for (int i = 0; i < len; i++) {
                if (isVowel(word.charAt(i))) {
                    vowelIndex = i;
                    break;
                }
            }
            if (vowelIndex == -1) {
                return word + "ay";
            }
//            no need for StringBuilder here, as the words aren't expected to be large
            if (vowelIndex == 0) {
                return word + "hay";
            } else {
                return word.substring(vowelIndex) + word.substring(0, vowelIndex) + "ay";
            }
        }

        private static boolean isVowel(char ch) {
            return "aeiouyAEIOUY".indexOf(ch) != -1;
        }
    }
}
