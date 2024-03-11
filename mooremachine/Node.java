
package mooremachine;


public class Node {
    String Statename;
    char output;
    int stateNum;
    Transition transitions[];

    public Node(String Statename, char output, int stateNum, Transition[] transitions) {
        this.Statename = Statename;
        this.output = output;
        this.stateNum = stateNum;
        this.transitions = transitions;
    }

    public String getStatename() {
        return Statename;
    }

    public void setStatename(String Statename) {
        this.Statename = Statename;
    }

    public char getOutput() {
        return output;
    }

    public void setOutput(char output) {
        this.output = output;
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
        return "Node{" + "Statename=" + Statename + ", output=" + output + ", stateNum=" + stateNum + '}';
    }
    
}
