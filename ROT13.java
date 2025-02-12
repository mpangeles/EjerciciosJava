/*
How can you tell an extrovert from an introvert at NSA?
Va gur ryringbef, gur rkgebireg ybbxf ng gur BGURE thl'f fubrf.

I found this joke on USENET, but the punchline is scrambled. Maybe you can decipher it?
According to Wikipedia, ROT13 is frequently used to obfuscate jokes on USENET.

For this task you're only supposed to substitute characters. Not spaces, punctuation, numbers, etc.

Test examples:

"EBG13 rknzcyr." -> "ROT13 example."

"This is my first ROT13 excercise!" -> "Guvf vf zl svefg EBG13 rkprepvfr!"

*/

import java.util.stream.IntStream;
class Solution {

   public static String rot13(String message) {
       char[] abecedario={'A','B','C','D',
                          'E','F','G','H',
                          'I','J','K','L',
                          'M','N','O','P',
                          'Q','R','S','T',
                          'U','V','W','X',
                          'Y','Z','a','b',
                          'c','d','e','f',
                          'g','h','i','j',
                          'k','l','m','n',
                          'o','p','q','r',
                          's','t','u','v',
                          'w','x','y','z'};
             char[] rot13={'N','O','P','Q',
                           'R','S','T','U',
                           'V','W','X','Y',
                           'Z','A','B','C',
                           'D','E','F','G',
                           'H','I','J','K',
                           'L','M','n','o',
                           'p','q','r','s',
                           't','u','v','w',
                           'x','y','z','a',
                           'b','c','d','e',
                           'f','g','h','i',
                           'j','k','l','m'};
        int len=abecedario.length;
        char[] chmessage=message.toCharArray();
        StringBuilder resultado = new StringBuilder();
        for (int x=0;x<chmessage.length;x++) {
        if(String.valueOf(chmessage[x]).matches("[A-Z]*") || String.valueOf(chmessage[x]).matches("[a-z]*") ){
            char letter=chmessage[x];
            int indexfind=IntStream.range(0, len)
              .filter(i -> letter == abecedario[i])
              .findFirst() // first occurrence
              .orElse(-1);
             resultado.append(rot13[indexfind]);
         }else{
           resultado.append(chmessage[x]);
         }
       }
     return resultado.toString();
   }
}
