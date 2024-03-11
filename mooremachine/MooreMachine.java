package mooremachine;


import java.util.Scanner;

public class MooreMachine {

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
        String transitionTableColumnNames = "/";
        
        for (int i = 0; i < alphabet.split(",").length; i++) {
            transitionTableColumnNames += "After input " + alphabet.split(",")[i] + "/";
        }
        
        System.out.println("Old State " + transitionTableColumnNames + "OutputTable");

        statesInput = new String[numberOfStates]; // Satır girdileri için
        stateNode = new Node[numberOfStates]; // Stateleri tanımlamak için

        for (int i = 0; i < numberOfStates; i++) {
            statesInput[i] = scanner.nextLine(); // Satırlar alınır.
            stateInputNode = statesInput[i].split(" "); //Herbir satırı bosluklara göre ayırmak için
            stateNode[i] = new Node(stateInputNode[0], stateInputNode[1 + alphabet.split(",").length].charAt(0), (stateInputNode[0].charAt(1) - '0'), new Transition[alphabet.split(",").length]);
            //Statelerin tanımlanması

            for (int j = 0; j < alphabet.split(",").length; j++) {
                stateNode[i].getTransitions()[j] = new Transition(alphabet.split(",")[j].charAt(0), (stateInputNode[j + 1].charAt(1) - '0'));
                // Statelerin geçişleri tabloya göre tanımlanıyor.
            }

        }


        System.out.println("Input Stringi girin :");
        String inputString = scanner.nextLine(); //İnput string için
        scanner.close();

        Node currentState = stateNode[0]; //Anlık state için
        Node nextState; // Sonraki state için
        String states = currentState.getStatename(); //Default olarak ilk State in ismi tanımla
        String output = "" + currentState.getOutput(); //output Stringini tanımla ve ilk State in outputunu ekle
        
        for (int indx = 0; indx < inputString.length(); indx++) {
            int a = Math.abs(alphabet.split(",")[0].charAt(0) - inputString.charAt(indx)); //Sonraki state için geçişi secme

            nextState = stateNode[currentState.getTransitions()[a].nextState]; //Şuanki State in inputString e göre geçişlerinden nextState i tanımla
            currentState = nextState;
            states += " " + nextState.getStatename();
            output += "  " + currentState.getOutput();

        }
        String yeniString = String.join("  ", inputString.split("(?!^)"));
        System.out.println("Input String    " + yeniString);
        System.out.println("State        " + states);
        System.out.println("Output       " + output);
    }

}
