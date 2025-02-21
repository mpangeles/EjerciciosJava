/*

Description:
If n is the numerator and d the denominator of a fraction, that fraction is defined a (reduced) proper fraction if and only if GCD(n, d) = 1.

For example 5/16 is a proper fraction, while 6/16 is not, as both 6 and 16 are divisible by 2, thus the fraction can be reduced to 3/8.

Now, if you consider a given number d, how many proper fractions can be built using d as a denominator?

For example, let's assume that d is 15: you can build a total of 8 different proper fractions between 0 and 1 with it: 1/15, 2/15, 4/15, 7/15, 8/15, 11/15, 13/15 and 14/15.

You are to write a function that computes how many proper fractions you can build with a given
*/

public class ProperFractions {
  public static long properFractions(long n) {
      long cont1=0,cont=0;
     
      /* for (int i=1;i<=n;i++){
           cont1=0;
            if(i/n!=1){
              for (int j=2;j<n;j++){
                   if(i%j==0 && n%j==0){
                     cont1++;
                     break;
                   }
              }
            
            if(cont1==0){
            
              cont++;
            }
           }    
           
       }*/
    
      if (n==1) return 0;
        cont=n;
        for(long i=2;i*i<=n;i++){
        
          if(n%i<1){
            while(n%i<1)
               
              n/=i;
            cont-=cont/i;
            
          }
        }
        if(n>1) cont-=cont/n;
    
        return cont;
    
  
  }
}
