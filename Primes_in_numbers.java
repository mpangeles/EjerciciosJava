/*Given a positive number n > 1 find the prime factor decomposition of n. The result will be a string with the following form :

 "(p1**n1)(p2**n2)...(pk**nk)"
with the p(i) in increasing order and n(i) empty if n(i) is 1.

Example: n = 86240 should return "(2**5)(5)(7**2)(11)"*/

import java.util.LinkedHashMap;
import java.util.Map;
public class PrimeDecomp {

    public static String factors(int n) {
        // your code
       Map<Integer, Integer> factores = new LinkedHashMap<>();
       int divisor = 2;
       while (n>1){
          while (n% divisor==0){
                factores.put(divisor, factores.getOrDefault(divisor, 0) + 1);
                n /= divisor;
          }

          divisor++;
       }

      StringBuilder resultado = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : factores.entrySet()) {
            resultado.append("(").append(entry.getKey());
            if (entry.getValue() > 1) {
                resultado.append("**").append(entry.getValue());
            }
            resultado.append(")");
        }

        return resultado.toString();

    }

}
