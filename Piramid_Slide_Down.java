/*
Lyrics...
Pyramids are amazing! Both in architectural and mathematical sense. If you have a computer, you can mess with pyramids even if you are not in Egypt at the time. For example, let's consider the following problem. Imagine that you have a pyramid built of numbers, like this one here:

   /3/
  \7\ 4
 2 \4\ 6
8 5 \9\ 3
Here comes the task...
Let's say that the 'slide down' is the maximum sum of consecutive numbers from the top to the bottom of the pyramid. As you can see, the longest 'slide down' is 3 + 7 + 4 + 9 = 23

Your task is to write a function that takes a pyramid representation as an argument and returns its largest 'slide down'. For example:

* With the input `[[3], [7, 4], [2, 4, 6], [8, 5, 9, 3]]`
* Your function should return `23`.
By the way...
My tests include some extraordinarily high pyramids so as you can guess, brute-force method is a bad idea unless you have a few centuries to waste. You must come up with something more clever than that.

(c) This task is a lyrical version of Problem 18 and/or Problem 67 on ProjectEuler.

*/

public class LongestSlideDown {

    public static int longestSlideDown(int[][] piramide) {
        int n = piramide.length;

        // Empezamos desde la penúltima fila y vamos acumulando los máximos
        for (int fila = n - 2; fila >= 0; fila--) {
            for (int col = 0; col < piramide[fila].length; col++) {
                // Elegimos el máximo de los dos números debajo y lo sumamos al actual
                piramide[fila][col] += Math.max(piramide[fila + 1][col], piramide[fila + 1][col + 1]);
            }
        }
        return piramide[0][0]; // El valor en la cima tendrá la máxima suma
    }
}
