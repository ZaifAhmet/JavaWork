
package cfg_toplamagacı;


import java.util.LinkedList;
import java.util.List;


public class Node {

    
    String txt;
    List<Node> children = new LinkedList();

    public Node(String txt) {
        this.txt = txt;
        
    }
    public Node(String txt,List<Node> Child){
        this.txt = txt;
        this.children = Child;
    }
   
    

}
