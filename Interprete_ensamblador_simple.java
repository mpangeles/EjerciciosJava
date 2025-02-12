/*
Esta es la primera parte de esta serie de katas. La segunda parte está aquí .

Queremos crear un intérprete simple de ensamblador que admita las siguientes instrucciones:

mov x y- copia y(ya sea un valor constante o el contenido de un registro) en un registrox
inc x- aumenta el contenido del registro xen uno
dec x- disminuye el contenido del registro xen uno
jnz x y- salta a una instrucción yque se aleja (positivo significa hacia adelante, negativo significa hacia atrás, y puede ser un registro o una constante), pero solo si x(una constante o un registro) no es cero
Los nombres de los registros están ordenados alfabéticamente (solo letras). Las constantes son siempre números enteros (positivos o negativos).

Nota: la jnzinstrucción se mueve en relación a sí misma. Por ejemplo, un desplazamiento de -1continuaría en la instrucción anterior, mientras que un desplazamiento de 2omitiría la siguiente instrucción.

La función tomará como entrada una lista con la secuencia de instrucciones del programa y las ejecutará. El programa finaliza cuando no quedan más instrucciones para ejecutar, entonces retorna un diccionario (una tabla en COBOL) con el contenido de los registros.

Además, cada inc/ dec/ jnzen un registro siempre será precedido por un moven el registro primero, por lo que no necesita preocuparse por registros no inicializados.
*/
import java.util.HashMap;
import java.util.Map;

public class SimpleAssembler {
  public static Map<String, Integer> interpret(String[] program) {
        Map<String, Integer> out = new HashMap<String, Integer>();
        int i =0;

        while (i < program.length) {
           String[] instruction = program[i].split(" ");
           String cmd = instruction[0], x = instruction[1];
            switch (cmd) {
                case "mov":
                    String y = instruction[2];
                    out.put(x, y.matches("-?\\d+") ? Integer.parseInt(y) : out.get(y));
                    break;
                case "inc":
                    out.put(x, out.get(x) + 1);
                    break;
                case "dec":
                    out.put(x, out.get(x) - 1);
                    break;
                case "jnz":
                    int value = x.matches("-?\\d+") ? Integer.parseInt(x) : out.get(x);
                    int offset = instruction[2].matches("-?\\d+") ? Integer.parseInt(instruction[2]) : out.get(instruction[2]);
                    if (value != 0) {
                        i += offset;
                        continue;
                    }
                    break;
            }
            i++;
        }
        return out;
    }
}
