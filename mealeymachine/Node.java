
package mealeymachine;


public class Node {
    String Statename;
    int stateNum;
    Transition transitions[];

    public Node(String Statename, int stateNum, Transition[] transitions) {
        this.Statename = Statename;
        this.stateNum = stateNum;
        this.transitions = transitions;
    }

    public String getStatename() {
        return Statename;
    }

    public void setStatename(String Statename) {
        this.Statename = Statename;
    }



    public int getStateNum() {
        return stateNum;
    }

    public void setStateNum(int stateNum) {
        this.stateNum = stateNum;
    }

    public Transition[] getTransitions() {
        return transitions;
    }

    public void setTransitions(Transition[] transitions) {
        this.transitions = transitions;
    }

    @Override
    public String toString() {
        return "Node{" + "Statename=" + Statename + ", stateNum=" + stateNum + '}';
    }
    
}
