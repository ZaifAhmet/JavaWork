package cfg_toplamagacı;

import java.util.*;

public class Cfg_ToplamAgacı {

    public static Node generateTree(Node root, String cfg[][], int dur) {

        if (dur >= 10) {
            return root;
        }

        for (String[] cfg1 : cfg) {
            int indx = root.txt.indexOf(cfg1[0]);
            if (indx != -1) {
                for (String split : cfg1[1].split("\\|")) {
                    String txt = root.txt.replaceFirst(cfg1[0], split);
                    root.children.add(new Node(txt));
                }
            }
        }

        if (!root.children.isEmpty()) {
            for (int i = 0; i < root.children.size(); i++) {
                generateTree(root.children.get(i), cfg, ++dur);
            }
        }

        return root;
    }

    static void levelorderRoot(Node root, List<String> printData) {
        if (root != null) {
            List<Node> level = new ArrayList<>();
            level.add(root);
            levelorder(level, printData);
        }
    }

    static void levelorder(List<Node> prevLevel, List<String> printData) {

        List<Node> curLevel = new ArrayList<>();

        for (int i = 0; i < prevLevel.size(); i++) {
            for (int j = 0; j < prevLevel.get(i).children.size(); j++) {
                curLevel.add(prevLevel.get(i).children.get(j));
                printData.add(prevLevel.get(i).children.get(j).txt);
            }
        }
        prevLevel = curLevel;
        
        if (!prevLevel.isEmpty()) {
            levelorder(prevLevel, printData);
        }

    }

    public static void main(String[] args) {
        long baslangicZamani = System.nanoTime();
        Scanner input = new Scanner(System.in);
        System.out.println("Toplam dil agaci olusturulacak CFG'yi girin :");
        String metin = input.nextLine();
        String satırlar[] = metin.split(",");
        String cfg[][] = new String[satırlar.length][];

        for (int i = 0; i < satırlar.length; i++) {
            cfg[i] = satırlar[i].split("->");
            System.out.println(Arrays.toString(cfg[i]));
        }
        Node root = new Node(cfg[0][0]);
        root = generateTree(root, cfg, 0);
        List<String> printData = new ArrayList<>();
        levelorderRoot(root, printData);
        Set<String> yazilacak = new HashSet<>();
        Set<String> tekrarlanan = new HashSet<>();
        List<String> printData2 = new ArrayList<>();
        
        for (String s : printData) {
            if (!containsUpperCase(s)) {
                printData2.add(s);
                
            }
        }
        
        yazilacak.addAll(printData2);

        System.out.println("Tum Kelimeler : " + printData2);

        System.out.print("Uretilen Kelimeler : ");

        for (String s : yazilacak) {
            System.out.print(s + " ");
            if (Collections.frequency(printData2, s) > 1) {
                tekrarlanan.add(s);
            }
        }

        System.out.println("");
        System.out.print("Tekrarlanan Kelimeler : ");
        for (String s : tekrarlanan) {
            System.out.print(s + " ");
        }
        System.out.println("");
        long bitisZamani = System.nanoTime();
        var time =((bitisZamani - baslangicZamani) * 0.000001);
        System.out.println(time+ " ms");
    }

    public static boolean containsUpperCase(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

}
