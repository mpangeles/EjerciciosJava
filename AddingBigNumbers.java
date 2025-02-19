/*We need to sum big numbers and we require your help.

Write a function that returns the sum of two numbers. The input numbers are strings and the function must return a string.*/

public class Kata {
  public static String add(String a, String b) {
    StringBuilder suma = new StringBuilder();
        int llevamos = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
     //Suma de derecha a izquierda 
      while (i >= 0 || j >= 0 || llevamos > 0) {
       int digito1 = (i >= 0) ? a.charAt(i) - '0' : 0;
       int digito2 = (j >= 0) ? b.charAt(j) - '0' : 0;
       int sum= digito1+digito2+llevamos;
       llevamos= sum/10;
       suma.append(sum % 10);
        i--;
        j--;
     }
      String resultado=suma.reverse().toString();
     if (resultado.startsWith("0")){
          resultado= resultado.replaceFirst("^0+", "");
     }
     return resultado;
   }
  
}