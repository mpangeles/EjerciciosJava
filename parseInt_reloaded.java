import java.util.HashMap;
import java.util.Map;

public class Parser {
    
    public static int parseInt(String numStr) {
     int number=0;
     Map<String, Integer> dictionary = new HashMap<String, Integer>();
     dictionary.put("zero",0);
     dictionary.put("one",1);
     dictionary.put("two",2);
     dictionary.put("three",3); 
     dictionary.put("four",4);  
     dictionary.put("five",5);
     dictionary.put("six",6);
     dictionary.put("seven",7); 
     dictionary.put("eight",8); 
     dictionary.put("nine",9);
     dictionary.put("ten",10); 
     dictionary.put("eleven",11);
     dictionary.put("twelve",12);
     dictionary.put("thirteen",13);
     dictionary.put("fourteen",14); 
     dictionary.put("fifteen",15);  
     dictionary.put("sixteen",16);
     dictionary.put("seventeen",17);
     dictionary.put("eighteen",18); 
     dictionary.put("nineteen",19); 
     dictionary.put("twenty",20);
     dictionary.put("thirty",30);
     dictionary.put("forty",40);
     dictionary.put("fifty",50);
     dictionary.put("sixty",60);
     dictionary.put("seventy",70);
     dictionary.put("eighty",80);
     dictionary.put("ninety",90); 
     dictionary.put("hundred",100);
     dictionary.put("thousand",1000); 
     dictionary.put("million",1000000); 
       
      String[] split= numStr.split("[ ]|-");
     
     for (int i = 0; i < split.length; i++) {
            for (String key : dictionary.keySet()) {
                if (split[i].toLowerCase().equals(key)) {
                    if (dictionary.get(key) == 100) {
                        int temp = number % 100;
                        number -= temp;
                        number += temp * (dictionary.get(key));
                    }
                    else if (dictionary.get(key) > 100)
                        number *= (dictionary.get(key));
                    else
                        number += dictionary.get(key);
                      break;
                }
            }
        }
        return number;
    }
}