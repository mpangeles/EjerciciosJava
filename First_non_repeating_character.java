/*Write a function named first_non_repeating_letter† that takes a string input, and returns the first character that is not repeated anywhere in the string.

For example, if given the input 'stress', the function should return 't', since the letter t only occurs once in the string, and occurs first in the string.

As an added challenge, upper- and lowercase letters are considered the same character, but the function should return the correct case for the initial letter. For example, the input 'sTreSS' should return 'T'.

If a string contains all repeating characters, it should return an empty string ("");

† Note: the function is called firstNonRepeatingLetter for historical reasons, but your function should handle any Unicode character.*/

import java.util.LinkedHashMap;
import java.util.Map;

public class Kata {
  public static String firstNonRepeatingLetter(String s){
    // Add your code her
     char[] aCaracteres = s.toLowerCase().toCharArray();
     char[] aCaracteresOriginal = s.toCharArray();
     Map<Character, Integer> conteo = new LinkedHashMap<>();
     Map<Character, Character> letras = new LinkedHashMap<>();
    for (int x=0;x<aCaracteres.length;x++) {
            conteo.put(aCaracteres[x], conteo.getOrDefault(aCaracteres[x], 0) + 1);
            letras.put(aCaracteres[x],aCaracteresOriginal[x]);
        }
     for (Map.Entry<Character, Integer> entry : conteo.entrySet()) {
            if (entry.getValue() == 1) {

                return  String.valueOf(letras.get(entry.getKey()));
            }
      }
    return "";
  }
