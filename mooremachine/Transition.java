
package mooremachine;


public class Transition {
    char transitionName;
    int nextState;

    public Transition(char transitionName, int nextState) {
        this.transitionName = transitionName;
        this.nextState = nextState;
    }

    public char getTransitionName() {
        return transitionName;
    }

    public void setTransitionName(char transitionName) {
        this.transitionName = transitionName;
    }

    public int getNextState() {
        return nextState;
    }

    public void setNextState(int nextState) {
        this.nextState = nextState;
    }

    @Override
    public String toString() {
        return "Transition{" + "transitionName=" + transitionName + ", nextState=" + nextState + '}';
    }
    
}
