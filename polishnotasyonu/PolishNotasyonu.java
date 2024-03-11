
package polishnotasyonu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PolishNotasyonu {
    
    static double hesapla(double x1,double x2,char operator){
        double sonuc = 0;
        
        switch(operator){
            case '+' -> sonuc = x1 + x2;
            case '-' -> sonuc = x1 - x2;
            case '*' -> sonuc = x1 * x2;
            case '/' -> sonuc = x1 / x2;
            
        }
        
        return sonuc;
    }
    
    static boolean isOperand(String text){
        return Character.isDigit(text.charAt(0));
    }
    
    static boolean isOperator(String text){
        return text.contains("+") || text.contains("*") || text.contains("-") || text.contains("/");
    }
    
    public static void main(String[] args) {
        String metin;
        Scanner input = new Scanner(System.in);
        System.out.println("Bosluk birakarak Polish Notasyonunu girin :");
        metin = input.nextLine();
        String S1[] = metin.split(" ");
        ArrayList<String> pol = new ArrayList<>();
        pol.addAll(Arrays.asList(S1));
        double result = 0;
        
        while(pol.size() > 1){
            for(int i = 0;i < pol.size();i++){
                if(isOperator(pol.get(i)) && i + 2 < pol.size()){
                    if(isOperand(pol.get(i+1)) && isOperand(pol.get(i+2))){
                        result = hesapla(Double.parseDouble(pol.get(i+1)),Double.parseDouble(pol.get(i+2)),pol.get(i).charAt(0));
                        pol.remove(i+1);
                        pol.remove(i+1);
                        pol.set(i, String.valueOf(result));
                    }
                   
                }
                if(pol.size() == 1)
                    break;
            }
        }
        
        for(int i = 0;i < pol.size();i++){
            System.out.println(i + " " + pol.get(i));
        }
        
    }
}