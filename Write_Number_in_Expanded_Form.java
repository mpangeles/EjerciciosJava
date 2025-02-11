/*You will be given a number and you will need to return it as a string in Expanded Form. For example:

   12 --> "10 + 2"
   45 --> "40 + 5"
70304 --> "70000 + 300 + 4"
NOTE: All numbers will be whole numbers greater than 0.

If you liked this kata, check out part 2!!*/

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class Kata {
    public static String expandedForm(int num) {
        String strNumero = Integer.toString(num);
        StringBuilder resultado = new StringBuilder();
        int j=strNumero.length()-1;
        List<String> list = new ArrayList<String>();
        for (int i = 0; i<strNumero.length(); i++) {
          int unidades =(int) Math.pow(10, j);
          String digit=String.valueOf(strNumero.charAt(i));
          String numdesc=String.valueOf( Integer.valueOf(digit)*unidades );

            if ( Integer.valueOf(digit)>0){
               list.add(numdesc);
            }
          j--;
        }
        return list.stream().map(Object::toString)
                        .collect(Collectors.joining(" + "));
    }
}
