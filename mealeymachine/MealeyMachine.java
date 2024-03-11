
package mealeymachine;


import java.util.Scanner;


public class MealeyMachine {

    public static void main(String[] args) {
       String alphabet, output_alphabet;
        int numberOfStates;
        String stateInputNode[];
        String statesInput[];
        Node stateNode[];

        Scanner scanner = new Scanner(System.in);
        System.out.println("Alfabeyi virgul ile girin :");
        alphabet = scanner.nextLine();

        System.out.println("Olasi cikti sembolleri alfabesini virgul ile girin :");
        output_alphabet = scanner.nextLine();

        System.out.println("State sayisini girin :");
        numberOfStates = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Girdi tablosu icin bilgileri bosluk birakarak girin :");
        int tableColumn = 1;
        for (int i = 0; i < alphabet.split(",").length; i++) {
            System.out.print("           After input " + alphabet.split(",")[i]);
            tableColumn = i;
        }
        System.out.println("\nOld State" + ("/ New State / Output ").repeat(tableColumn+1));

        statesInput = new String[numberOfStates]; //Satır girdileri için
        stateNode = new Node[numberOfStates]; //Stateleri tanımlamak için

        for (int i = 0; i < numberOfStates; i++) {
            statesInput[i] = scanner.nextLine(); //Satırlar alınır
            stateInputNode = statesInput[i].split(" "); //Herbir satırı boşluklara göre ayırmak için
            stateNode[i] = new Node(stateInputNode[0], (stateInputNode[0].charAt(1) - '0'), new Transition[alphabet.split(",").length]);
            //Stateleri tanımla

            for (int j = 1; j <= alphabet.split(",").length; j++) {
                stateNode[i].getTransitions()[j-1] = new Transition(alphabet.split(",")[j-1].charAt(0), (stateInputNode[(2*j) - 1].charAt(1) - '0'),stateInputNode[(2*j)].charAt(0));
                //Herbir state in geçişlerini tanımla
            }

        }

        System.out.println("Input Stringi girin :");
        String inputString = scanner.nextLine(); //İnput string alınır
        scanner.close();

        Node currentState = stateNode[0]; //İlk state den başlayarak o an ki string tutulur.
        Node nextState; //Sonraki state için değişken
        String states = "->" + currentState.getStatename(); //Geçişleri yazdırmak için String
        String output = ""; //Çıkışları yazdırmak için String
        for (int indx = 0; indx < inputString.length(); indx++) {
            int a = Math.abs(alphabet.split(",")[0].charAt(0) - inputString.charAt(indx)); //Sonraki state için geçişi seçme
            
            output += "   " + currentState.getTransitions()[a].getOutput(); //Output çıkışına anlık State in geçişinden output ekle
            nextState = stateNode[currentState.getTransitions()[a].nextState]; //Sonraki state e geçmek için anlık state in geçişinden sonraki statein 
                                                                                //numarasına göre state dizisinden atama
            currentState = nextState;
            
            states += "->" + nextState.getStatename();
        }
        String yeniString = String.join("   ", inputString.split("(?!^)")); //Input stringine boşluk eklemek için
        System.out.println("Input String    " + yeniString);
        System.out.println("State    " + states);
        System.out.println("Output       " + output);
        
    }
    }
    
